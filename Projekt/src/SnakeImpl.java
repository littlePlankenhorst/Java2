import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SnakeImpl implements Snake {
    private static final Color[][] COLOR_PAIRS = {
        {new Color(255, 0, 0), new Color(255, 100, 100)},      // Dark red, Light red
        {new Color(0, 0, 255), new Color(100, 100, 255)},      // Dark blue, Light blue
        {new Color(148, 0, 211), new Color(186, 85, 211)},     // Dark purple, Light purple
        {new Color(255, 140, 0), new Color(255, 165, 0)},      // Dark orange, Light orange
        {new Color(75, 0, 130), new Color(138, 43, 226)},      // Indigo variants
        {new Color(255, 20, 147), new Color(255, 105, 180)},   // Deep pink, Hot pink
        {new Color(25, 25, 112), new Color(65, 105, 225)},     // Midnight blue, Royal blue
        {new Color(148, 0, 211), new Color(153, 50, 204)}      // Dark violet, Purple
    };
    
    private Color headColor;
    private Color bodyColor;
    private List<SnakeSegment> body;
    private Direction currentDirection;
    private Direction queuedDirection;
    private long lastDirectionChange;
    private static final long DIRECTION_CHANGE_DELAY = 25;
    private final int HEAD_SIZE = 25;
    private final int BODY_SIZE = 20;
    private final int MOVE_DISTANCE = 20;
    private final SnakeSegment.SegmentShape snakeShape;
    private Point[] interpolatedPositions;
    private static final double INTERPOLATION_STEPS = 5.0;
    private double interpolationProgress = 0.0;
    
    public SnakeImpl(int startX, int startY, SnakeSegment.SegmentShape shape) {
        this.snakeShape = shape;
        
        int colorIndex = new Random().nextInt(COLOR_PAIRS.length);
        headColor = COLOR_PAIRS[colorIndex][0];
        bodyColor = COLOR_PAIRS[colorIndex][1];
        
        body = new ArrayList<>();
        body.add(new SnakeSegment(
            new Point(startX, startY),
            shape,
            HEAD_SIZE,
            headColor
        ));
        
        currentDirection = Direction.RIGHT;
        queuedDirection = currentDirection;
        lastDirectionChange = System.currentTimeMillis();
        interpolatedPositions = new Point[1];
        interpolatedPositions[0] = new Point(startX, startY);
    }
    
    @Override
    public void draw(Graphics g) {
        for (int i = 0; i < body.size(); i++) {
            SnakeSegment segment = body.get(i);
            Point currentPos = segment.getPosition();
            Point prevPos = interpolatedPositions[i];
            
            int x = (int) (prevPos.x + (currentPos.x - prevPos.x) * interpolationProgress);
            int y = (int) (prevPos.y + (currentPos.y - prevPos.y) * interpolationProgress);
            
            Point originalPos = segment.getPosition();
            segment.setPosition(new Point(x, y));
            segment.draw(g);
            segment.setPosition(originalPos);
        }
    }
    
    @Override
    public void move() {
        interpolationProgress += 1.0 / INTERPOLATION_STEPS;
        
        if (interpolationProgress >= 1.0) {
            if (queuedDirection != currentDirection) {
                currentDirection = queuedDirection;
                lastDirectionChange = System.currentTimeMillis();
            }
            
            interpolatedPositions = new Point[body.size()];
            for (int i = 0; i < body.size(); i++) {
                interpolatedPositions[i] = new Point(body.get(i).getPosition());
            }
            
            Point headPos = body.get(0).getPosition();
            Point newHeadPos = new Point(headPos);
            
            switch (currentDirection) {
                case UP -> newHeadPos.y -= MOVE_DISTANCE;
                case DOWN -> newHeadPos.y += MOVE_DISTANCE;
                case LEFT -> newHeadPos.x -= MOVE_DISTANCE;
                case RIGHT -> newHeadPos.x += MOVE_DISTANCE;
            }
            
            for (int i = body.size() - 1; i > 0; i--) {
                Point prevPos = body.get(i - 1).getPosition();
                body.get(i).setPosition(new Point(prevPos));
            }
            
            body.get(0).setPosition(newHeadPos);
            interpolationProgress = 0.0;
        }
    }
    
    @Override
    public void grow() {
        Point lastPos = body.get(body.size() - 1).getPosition();
        body.add(new SnakeSegment(
            new Point(lastPos),
            snakeShape,
            BODY_SIZE,
            bodyColor
        ));
        
        Point[] newInterpolatedPositions = new Point[interpolatedPositions.length + 1];
        System.arraycopy(interpolatedPositions, 0, newInterpolatedPositions, 0, interpolatedPositions.length);
        newInterpolatedPositions[interpolatedPositions.length] = new Point(lastPos);
        interpolatedPositions = newInterpolatedPositions;
    }
    
    @Override
    public boolean collidesWithSelf() {
        Point headPos = body.get(0).getPosition();
        int headSize = body.get(0).getSize();
        
        for (int i = 2; i < body.size(); i++) {
            Point segmentPos = body.get(i).getPosition();
            int segmentSize = body.get(i).getSize();
            
            Point headCenter = new Point(
                headPos.x + headSize/2,
                headPos.y + headSize/2
            );
            Point segmentCenter = new Point(
                segmentPos.x + segmentSize/2,
                segmentPos.y + segmentSize/2
            );
            
            double distance = Math.sqrt(
                Math.pow(headCenter.x - segmentCenter.x, 2) +
                Math.pow(headCenter.y - segmentCenter.y, 2)
            );
            
            if (distance < (headSize + segmentSize) / 2.5) {  
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void setDirection(Direction newDirection) {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastDirectionChange < DIRECTION_CHANGE_DELAY) {
            return;
        }
        
        boolean isValid = switch (newDirection) {
            case UP -> currentDirection != Direction.DOWN;
            case DOWN -> currentDirection != Direction.UP;
            case LEFT -> currentDirection != Direction.RIGHT;
            case RIGHT -> currentDirection != Direction.LEFT;
        };
        
        if (isValid) {
            queuedDirection = newDirection;
            if (currentTime - lastDirectionChange >= DIRECTION_CHANGE_DELAY) {
                currentDirection = newDirection;
                lastDirectionChange = currentTime;
            }
        }
    }
    
    @Override
    public boolean collidesWithWall(GameMap map) {
        Point headPos = body.get(0).getPosition();
        int headSize = body.get(0).getSize();
        
        return map.isWall(headPos.x, headPos.y) ||
               map.isWall(headPos.x + headSize, headPos.y) ||
               map.isWall(headPos.x, headPos.y + headSize) ||
               map.isWall(headPos.x + headSize, headPos.y + headSize);
    }
    
    @Override
    public Point getHeadPosition() {
        return body.get(0).getPosition();
    }
    
    @Override
    public int getSegmentSize() {
        return BODY_SIZE;
    }
} 