import java.awt.*;

public class MudBackground implements Background {
    private final Color BACKGROUND_COLOR = new Color(101, 67, 33); 
    private final Color WALL_COLOR = new Color(58, 38, 19);  
    
    @Override
    public void draw(Graphics g, int width, int height) {
        g.setColor(BACKGROUND_COLOR);
        g.fillRect(0, 0, width, height);
    }
    
    @Override
    public Color getWallColor() {
        return WALL_COLOR;
    }
} 