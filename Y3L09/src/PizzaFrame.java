import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PizzaFrame extends JFrame{
    public PizzaFrame() {

        JFrame frame = new JFrame();

        Pizza pizza = new PizzaBase();

        pizza = new Tomato(pizza);
        pizza = new Salami(pizza);
        pizza = new Corn(pizza);
        pizza = new Olive(pizza);

        System.out.println("Price: " + pizza.getPrice());
        System.out.println("Ingredients: " + pizza.getIngredients());

        PizzaPanel pizzaPanel = new PizzaPanel(pizza);
        frame.add(pizzaPanel);
        frame.pack();



        frame.setSize(500,500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new PizzaFrame();
    }
}