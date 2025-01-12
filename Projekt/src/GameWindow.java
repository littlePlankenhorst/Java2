import java.awt.*;
import java.awt.event.*;

public class GameWindow extends Frame {
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    private static final int TOP_MARGIN = 50;  
    private static final int WALL_PADDING = 30;
    
    private GameMap gameMap;
    private Snake snake;
    private boolean gameOver = false;
    private Fruit fruit;
    private AntiFruit antiFruit;

    private Image offscreenBuffer;
    private Graphics offscreenGraphics;
    
    private SnakeSegment.SegmentShape selectedShape = SnakeSegment.SegmentShape.CIRCLE;  
    
    private Background background;
    private GameMusic gameMusic;
    
    private boolean isMuted = false;
    private Checkbox muteCheckbox;
    
    private Score score;
    
    public GameWindow() {
        gameMusic = new GameMusic();
        
        setTitle("Snake Game");
        
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        
        setLocationRelativeTo(null);
        
        setResizable(false);
        
        muteCheckbox = new Checkbox("Mute Music");
        muteCheckbox.addItemListener(e -> {
            isMuted = muteCheckbox.getState();
            if (isMuted) {
                gameMusic.stop();
            } else if (!gameOver) {
                gameMusic.start();
            }
        });
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        
        setVisible(true);
        showMainMenu();
    }
    
    private void startGame() {
        removeAll();  
        
        score = new Score();
        
        gameMap = new GameMapImpl(
            WINDOW_WIDTH,
            WINDOW_HEIGHT - TOP_MARGIN,
            background.getWallColor()
        );
        
        snake = new SnakeImpl(
            WINDOW_WIDTH / 2,
            TOP_MARGIN + (WINDOW_HEIGHT - TOP_MARGIN) / 2,
            selectedShape
        );
        
        gameOver = false;
        
        fruit = new Fruit();
        antiFruit = new AntiFruit();
        randomizeFruitPositions();
        
        if (!isMuted) {
            gameMusic.start();
        }
        
        setFocusable(true);
        requestFocus();
        
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (!gameOver) {
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_UP:
                            snake.setDirection(Direction.UP);
                            break;
                        case KeyEvent.VK_DOWN:
                            snake.setDirection(Direction.DOWN);
                            break;
                        case KeyEvent.VK_LEFT:
                            snake.setDirection(Direction.LEFT);
                            break;
                        case KeyEvent.VK_RIGHT:
                            snake.setDirection(Direction.RIGHT);
                            break;
                    }
                }
            }
        });
        
        new Thread(() -> {
            while (!gameOver) {
                snake.move();
                
                if (!gameOver) {
                    if (snake.collidesWithWall(gameMap)) {
                        handleGameOver();
                    }
                    
                    if (snake.collidesWithSelf()) {
                        handleGameOver();
                    }
                    
                    if (antiFruit.isColliding(snake.getHeadPosition(), snake.getSegmentSize())) {
                        Fruit.playBiteSound(); 
                        handleGameOver();
                    }
                    
                    if (fruit.isColliding(snake.getHeadPosition(), snake.getSegmentSize())) {
                        Fruit.playBiteSound(); 
                        snake.grow();
                        int points = fruit.getValue() * 5;
                        score.addPoints(points);
                        
                        fruit.randomizePosition(
                            WINDOW_WIDTH - 2 * WALL_PADDING,
                            WINDOW_HEIGHT - TOP_MARGIN - 2 * WALL_PADDING,
                            gameMap,
                            TOP_MARGIN,
                            WALL_PADDING
                        );
                        antiFruit.randomizePosition(
                            WINDOW_WIDTH - 2 * WALL_PADDING,
                            WINDOW_HEIGHT - TOP_MARGIN - 2 * WALL_PADDING,
                            gameMap,
                            TOP_MARGIN,
                            WALL_PADDING
                        );
                    }
                }
                
                repaint();
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        
        repaint();
    }
    
    private void randomizeFruitPositions() {
        fruit.randomizePosition(
            WINDOW_WIDTH - 2 * WALL_PADDING,
            WINDOW_HEIGHT - TOP_MARGIN - 2 * WALL_PADDING,
            gameMap,
            TOP_MARGIN,
            WALL_PADDING
        );
        
        antiFruit.randomizePosition(
            WINDOW_WIDTH - 2 * WALL_PADDING,
            WINDOW_HEIGHT - TOP_MARGIN - 2 * WALL_PADDING,
            gameMap,
            TOP_MARGIN,
            WALL_PADDING
        );
    }
    
    @Override
    public void paint(Graphics g) {
        if (offscreenGraphics != null) {

            offscreenGraphics.setColor(Color.BLACK);
            offscreenGraphics.fillRect(0, 0, getWidth(), getHeight());
            
            offscreenGraphics.setColor(new Color(0, 0, 0)); 
            offscreenGraphics.fillRect(0, 0, WINDOW_WIDTH, TOP_MARGIN);
            
            if (score != null) {
                offscreenGraphics.setFont(new Font("Arial", Font.BOLD, 16));
                offscreenGraphics.setColor(Color.WHITE);
                
                offscreenGraphics.drawString("Mute: " + (isMuted ? "On" : "Off"), 20, 45);
                
                String scoreText = "Score: " + score.getCurrentScore();
                FontMetrics metrics = offscreenGraphics.getFontMetrics();
                int scoreX = (WINDOW_WIDTH - metrics.stringWidth(scoreText)) / 2;
                offscreenGraphics.drawString(scoreText, scoreX, 45);
                
                String highScoreText = "High Score: " + Score.getHighScore();
                int highScoreX = WINDOW_WIDTH - metrics.stringWidth(highScoreText) - 20;
                offscreenGraphics.drawString(highScoreText, highScoreX, 45);
            }
            
            offscreenGraphics.translate(0, TOP_MARGIN);
            
            if (background != null) {
                background.draw(offscreenGraphics, getWidth(), getHeight() - TOP_MARGIN);
            }
            
            if (gameMap != null) gameMap.draw(offscreenGraphics);
            if (fruit != null) fruit.draw(offscreenGraphics);
            if (antiFruit != null) antiFruit.draw(offscreenGraphics);
            if (snake != null) snake.draw(offscreenGraphics);
            
            offscreenGraphics.translate(0, -TOP_MARGIN);
            
            if (gameOver) {
                offscreenGraphics.setColor(new Color(0, 0, 0, 180)); 
                offscreenGraphics.fillRect(0, 0, getWidth(), getHeight());
                
                offscreenGraphics.setColor(Color.RED);
                offscreenGraphics.setFont(new Font("Arial", Font.BOLD, 40));
                FontMetrics metrics = offscreenGraphics.getFontMetrics();
                String gameOverText = "Game Over!";
                int x = (getWidth() - metrics.stringWidth(gameOverText)) / 2;
                int y = getHeight() / 3;
                offscreenGraphics.drawString(gameOverText, x, y);
                
                offscreenGraphics.setFont(new Font("Arial", Font.BOLD, 25));
                String finalScoreText = "Final Score: " + score.getCurrentScore();
                int scoreX = (getWidth() - metrics.stringWidth(finalScoreText)) / 2;
                offscreenGraphics.drawString(finalScoreText, scoreX+50, y + 50);
            }
            
            g.drawImage(offscreenBuffer, 0, 0, this);
        }
    }
    
    @Override
    public void update(Graphics g) {
        if (offscreenBuffer == null || 
            offscreenBuffer.getWidth(null) != getWidth() || 
            offscreenBuffer.getHeight(null) != getHeight()) {
            
            offscreenBuffer = createImage(getWidth(), getHeight());
            offscreenGraphics = offscreenBuffer.getGraphics();
            
            if (offscreenGraphics instanceof Graphics2D) {
                Graphics2D g2d = (Graphics2D) offscreenGraphics;
                g2d.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
                );
            }
        }
        
        paint(g);
    }
    
    private void handleGameOver() {
        gameOver = true;
        gameMusic.stop();
        Fruit.playWallHitSound();
        score.saveScore();  
        showGameOverOptions();
    }
    
    private void showGameOverOptions() {
        Panel optionsPanel = new Panel();
        optionsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));  
        optionsPanel.setBounds(
            getWidth()/2 - 150,
            getHeight()/2,  
            300,
            60
        );
        
        Button playAgainButton = new Button("Play Again");
        Button menuButton = new Button("Back to Menu");
        Button exitButton = new Button("Exit");
        
        playAgainButton.setPreferredSize(new Dimension(100, 30));
        menuButton.setPreferredSize(new Dimension(100, 30));
        exitButton.setPreferredSize(new Dimension(100, 30));
        
        playAgainButton.addActionListener(e -> {
            remove(optionsPanel);
            startGame();
        });
        
        menuButton.addActionListener(e -> {
            remove(optionsPanel);
            showMainMenu();
        });
        
        exitButton.addActionListener(e -> System.exit(0));
        
        optionsPanel.add(playAgainButton);
        optionsPanel.add(menuButton);
        optionsPanel.add(exitButton);
        add(optionsPanel);
        validate();
    }
    
    private void showMainMenu() {
        removeAll();
        gameMusic.stop();
        
        gameOver = false;
        snake = null;
        gameMap = null;
        fruit = null;
        antiFruit = null;
        
        Panel mainPanel = new Panel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 10, 0);
        
        Label titleLabel = new Label("Snake Game", Label.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        mainPanel.add(titleLabel, gbc);
        
        Panel mutePanel = new Panel(new FlowLayout(FlowLayout.CENTER));
        muteCheckbox.setFont(new Font("Arial", Font.PLAIN, 14));
        mutePanel.add(muteCheckbox);
        mainPanel.add(mutePanel, gbc);
        
        Panel scorePanel = new Panel(new FlowLayout(FlowLayout.CENTER));
        String[] highScoreInfo = Score.getHighScoreWithTimestamp();
        String highScoreText = "High Score: " + highScoreInfo[1] + 
                              " (Achieved on: " + highScoreInfo[0] + ")";
        Label highScoreLabel = new Label(highScoreText);
        highScoreLabel.setFont(new Font("Arial", Font.BOLD, 16));
        scorePanel.add(highScoreLabel);
        mainPanel.add(scorePanel, gbc);
        
        Panel mapPanel = new Panel(new FlowLayout(FlowLayout.CENTER));
        mapPanel.add(new Label("Select Map: "));
        Choice mapChoice = new Choice();
        mapChoice.add("Grass Map");
        mapChoice.add("Mud Map");
        mapPanel.add(mapChoice);
        mainPanel.add(mapPanel, gbc);
        
        Panel shapePanel = new Panel(new FlowLayout(FlowLayout.CENTER));
        shapePanel.add(new Label("Select Snake Shape: "));
        Choice shapeChoice = new Choice();
        shapeChoice.add("Circle");
        shapeChoice.add("Triangle");
        shapeChoice.add("Rectangle");
        shapePanel.add(shapeChoice);
        mainPanel.add(shapePanel, gbc);
        
        Panel buttonPanel = new Panel(new FlowLayout(FlowLayout.CENTER));
        Button startButton = new Button("Start Game");
        startButton.setPreferredSize(new Dimension(120, 40));
        startButton.setFont(new Font("Arial", Font.BOLD, 14));
        buttonPanel.add(startButton);
        mainPanel.add(buttonPanel, gbc);
        
        startButton.addActionListener(e -> {
            background = mapChoice.getSelectedItem().equals("Grass Map") 
                ? new GrassBackground() 
                : new MudBackground();
            
            switch (shapeChoice.getSelectedItem()) {
                case "Triangle":
                    selectedShape = SnakeSegment.SegmentShape.TRIANGLE;
                    break;
                case "Rectangle":
                    selectedShape = SnakeSegment.SegmentShape.RECTANGLE;
                    break;
                default:
                    selectedShape = SnakeSegment.SegmentShape.CIRCLE;
            }
            
            startGame();
        });
        
        setLayout(new GridBagLayout());  
        add(mainPanel);
        
        validate();
        repaint();
    }
} 