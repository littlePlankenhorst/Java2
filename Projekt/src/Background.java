import java.awt.*;

public interface Background {
    void draw(Graphics g, int width, int height);
    Color getWallColor(); 
} 