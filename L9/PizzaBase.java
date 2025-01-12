import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

public class PizzaBase implements Pizza {

    protected BufferedImage img;


    public PizzaBase() {
        try {
            img = ImageIO.read(new File("./img/pizza_base.png")); // Ensure the path is correct
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public String getIngredients() {
        return getClass().getName();
    }

    @Override
    public void bake(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }

    @Override
    public int getPrice() {
        return 10; // Base price for the pizza
    }
}
