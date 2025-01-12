import java.awt.Graphics;
import java.awt.Point;

public interface Snake {
    void draw(Graphics g);
    void move();
    void setDirection(Direction direction);
    boolean collidesWithWall(GameMap map);
    boolean collidesWithSelf();
    void grow();
    Point getHeadPosition();
    int getSegmentSize();
}

enum Direction {
    UP, DOWN, LEFT, RIGHT;
} 