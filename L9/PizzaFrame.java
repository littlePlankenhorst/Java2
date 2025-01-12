import java.awt.*;
import javax.swing.*;

public class PizzaFrame extends JFrame {
    public PizzaFrame() {
        setTitle("PizzaFrame");
        setLayout(new FlowLayout(5, 25, 15));

        Pizza pizza = new PizzaBase();

        pizza = new Tomato(pizza);
        pizza = new Salami(pizza);
        pizza = new Mushroom(pizza);
        pizza = new Corn(pizza);
        pizza = new Olive(pizza);

        PizzaPanel pizzaPanel = new PizzaPanel(pizza);
        add(pizzaPanel);

        System.out.println("Pizza Price: " + pizza.getPrice());
        System.out.println("Pizza Ingredients: " + pizza.getIngredients());

        pack();
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new PizzaFrame();
    }
}


