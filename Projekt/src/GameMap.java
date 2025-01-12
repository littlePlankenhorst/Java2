import java.awt.Graphics;

public interface GameMap {
    void draw(Graphics g);
    boolean isWall(int x, int y);
} 