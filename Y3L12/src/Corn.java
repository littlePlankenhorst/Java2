import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Corn extends PizzaIngredient{
    private BufferedImage img;

    public Corn(Pizza pizza) {
        super(pizza);
        try {
            img = ImageIO.read(Objects.requireNonNull(getClass().getResource("img/corn.png")));
        } catch (IOException e) {
            System.out.println("A kepet nem sikerult betolteni");
        }
    }

    @Override
    public void bake(Graphics g) {
        super.bake(g);
        g.drawImage(img,0,0,null);
    }

    @Override
    public int getPrice() {
        return super.getPrice()+2;
    }

    @Override
    public String getIngredients() {
        return super.getIngredients().concat(", "+getClass().getSimpleName());
    }
}
