import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.sound.sampled.*;

public class Fruit {
    private Point position;
    private BufferedImage image;
    private final int SIZE = 25;
    private Random random;
    private static final String[] FRUIT_TYPES = {
        "corn", "olive", "mushroom", "salami"
    };
    private static Clip wallHitSound;
    private int value;
    private static Clip biteSound;
    
    public Fruit() {
        random = new Random();
        loadRandomFruit();
        initializeSound();
    }
    
    private void loadRandomFruit() {
        int index = random.nextInt(FRUIT_TYPES.length);
        String fruitType = FRUIT_TYPES[index];
        value = switch (fruitType) {
            case "corn" -> 1;
            case "olive" -> 2;
            case "mushroom" -> 3;
            case "salami" -> 4;
            default -> 1;
        };
        
        try {
            image = ImageIO.read(new File("img/" + fruitType + ".png"));
        } catch (IOException e) {
            System.out.println("Error loading fruit image: " + e.getMessage());
        }
    }
    
    private void initializeSound() {
        try {
            AudioInputStream wallHitStream = AudioSystem.getAudioInputStream(
                new File("sound/wall_hit.wav")
            );
            wallHitSound = AudioSystem.getClip();
            wallHitSound.open(wallHitStream);
            
            AudioInputStream biteStream = AudioSystem.getAudioInputStream(
                new File("sound/bite.wav")
            );
            biteSound = AudioSystem.getClip();
            biteSound.open(biteStream);
        } catch (Exception e) {
            System.out.println("Error loading sound: " + e.getMessage());
        }
    }
    
    public static void playWallHitSound() {
        if (wallHitSound != null) {
            wallHitSound.setFramePosition(0);
            wallHitSound.start();
        }
    }
    
    public static void playBiteSound() {
        if (biteSound != null && !biteSound.isRunning()) {
            biteSound.setFramePosition(0);
            biteSound.start();
        }
    }
    
    public void randomizePosition(int maxWidth, int maxHeight, GameMap map, int topMargin, int wallPadding) {
        do {
            position = new Point(
                wallPadding + random.nextInt(maxWidth - 2 * wallPadding),
                random.nextInt(maxHeight - 2 * wallPadding)
            );
        } while (map.isWall(position.x, position.y - topMargin));
        
        position.y += topMargin;
        loadRandomFruit();
    }
    
    public void draw(Graphics g) {
        if (image != null) {
            g.drawImage(image, position.x, position.y, SIZE, SIZE, null);
        }
    }
    
    public boolean isColliding(Point snakeHead, int snakeSize) {
        return snakeHead.x < position.x + SIZE &&
               snakeHead.x + snakeSize > position.x &&
               snakeHead.y < position.y + SIZE &&
               snakeHead.y + snakeSize > position.y;
    }
    
    public int getValue() {
        return value;
    }
} 