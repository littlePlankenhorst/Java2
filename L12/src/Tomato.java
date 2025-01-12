import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

public class Tomato extends PizzaIngredient {

    protected BufferedImage img;

    {
        try {
            img = ImageIO.read(new File("./img/tomato.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Tomato(Pizza pizza) {
        super(pizza);
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
