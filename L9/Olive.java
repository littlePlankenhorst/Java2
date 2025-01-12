
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.*;
import java.io.*;

public class Olive extends PizzaIngredient {

    protected BufferedImage img;

    public Olive(Pizza pizza) {
        super(pizza);
        try {
            img = ImageIO.read(new File("./img/olive.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void bake(Graphics g) {
        super.bake(g);

        g.drawImage(img, 0, 0, null);
    }

    @Override
    public int getPrice() {
        return super.getPrice()+1;
    }

    @Override
    public String getIngredients() {
        return super.getIngredients()+' '+getClass().getName();
    }
}