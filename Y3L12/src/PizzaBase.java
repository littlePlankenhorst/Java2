import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class PizzaBase implements Pizza {

    protected BufferedImage img;


    public PizzaBase() {
        try {
            img = ImageIO.read(Objects.requireNonNull(getClass().getResource("img/pizza_base.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void bake(Graphics g) {
        g.drawImage(img,0, 0,null);
    }

    @Override
    public int getPrice() {
        return 10;
    }

    @Override
    public String getIngredients() {
        return getClass().getSimpleName();
    }
}
