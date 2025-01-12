import java.awt.*;

public class GrassBackground implements Background {
    private final Color BACKGROUND_COLOR = new Color(34, 139, 34);  
    private final Color WALL_COLOR = Color.BLACK;
    
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