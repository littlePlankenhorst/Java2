import java.awt.*;

public class GameMapImpl implements GameMap {
    private final int width;
    private final int height;
    private final int WALL_THICKNESS = 15;
    private final Color wallColor;
    
    public GameMapImpl(int width, int height, Color wallColor) {
        this.width = width;
        this.height = height;
        this.wallColor = wallColor;
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(wallColor);
        
        g.fillRect(0, 0, width, WALL_THICKNESS);
        
        g.fillRect(0, height - WALL_THICKNESS, width, WALL_THICKNESS);
        
        g.fillRect(0, 0, WALL_THICKNESS, height);
        
        g.fillRect(width - WALL_THICKNESS, 0, WALL_THICKNESS, height);
    }
    
    @Override
    public boolean isWall(int x, int y) {
        return x < WALL_THICKNESS || 
               x >= width - WALL_THICKNESS || 
               y < WALL_THICKNESS || 
               y >= height - WALL_THICKNESS;
    }
} 