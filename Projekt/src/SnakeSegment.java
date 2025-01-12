import java.awt.*;

public class SnakeSegment {
    private Point position;
    private SegmentShape shape;
    private int size;
    private Color color;
    
    public enum SegmentShape {
        CIRCLE, TRIANGLE, RECTANGLE
    }
    
    public SnakeSegment(Point position, SegmentShape shape, int size, Color color) {
        this.position = position;
        this.shape = shape;
        this.size = size;
        this.color = color;
    }
    
    public void draw(Graphics g) {
        g.setColor(color);
        switch (shape) {
            case CIRCLE:
                g.fillOval(position.x, position.y, size, size);
                break;
            case TRIANGLE:
                int[] xPoints = {position.x, position.x + size/2, position.x + size};
                int[] yPoints = {position.y + size, position.y, position.y + size};
                g.fillPolygon(xPoints, yPoints, 3);
                break;
            case RECTANGLE:
                g.fillRect(position.x, position.y, size, size);
                break;
        }
    }
    
    public void setPosition(Point position) {
        this.position = new Point(position);
    }
    
    public Point getPosition() {
        return new Point(position);
    }
    
    public int getSize() {
        return size;
    }
} 