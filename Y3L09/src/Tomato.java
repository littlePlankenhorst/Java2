import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Tomato extends PizzaIngredient {
    private BufferedImage img;

    public Tomato(Pizza pizza) {
        super(pizza);
        try {
            img = ImageIO.read(Objects.requireNonNull(getClass().getResource("img/tomato.png")));
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
        return super.getPrice()+3;
    }

    @Override
    public String getIngredients() {
        return super.getIngredients().concat(", "+getClass().getSimpleName());
    }
}
