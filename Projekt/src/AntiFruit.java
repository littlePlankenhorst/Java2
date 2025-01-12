import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

public class AntiFruit {
    private Point position;
    private BufferedImage image;
    private final int SIZE = 25;
    private Random random;
    
    public AntiFruit() {
        random = new Random();
        try {
            image = ImageIO.read(new File("img/tomato.png"));
        } catch (IOException e) {
            System.out.println("Error loading tomato image: " + e.getMessage());
        }
    }
    
    public void draw(Graphics g) {
        if (image != null) {
            g.drawImage(image, position.x, position.y, SIZE, SIZE, null);
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
    }
    
    public boolean isColliding(Point snakeHead, int snakeSize) {
        return snakeHead.x < position.x + SIZE &&
               snakeHead.x + snakeSize > position.x &&
               snakeHead.y < position.y + SIZE &&
               snakeHead.y + snakeSize > position.y;
    }
} 