import java.awt.*;
import javax.swing.*;

public class PizzaPanel extends JPanel {
    private Pizza pizza;

    public PizzaPanel(Pizza pizza) {
        this.pizza = pizza;
        setPreferredSize(new Dimension(400, 400));
    }

    public void updatePizza(Pizza pizza) {
        this.pizza = pizza;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        pizza.bake(g);
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }
}
