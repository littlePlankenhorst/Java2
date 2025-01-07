import java.awt.*;
import java.awt.event.*;

public class GroceryListFrame extends Frame {
    private List fruitsList;
    private List vegetablesList;
    private Button toRightButton;
    private Button toLeftButton;

    public GroceryListFrame() {
        setBounds(100, 100, 500, 300);
        setLayout(new FlowLayout());
        setTitle("Grocery List");

        // Initialize components
        fruitsList = new List(10, true);  // true enables multiple selection
        vegetablesList = new List(10, true);
        toRightButton = new Button("->");
        toLeftButton = new Button("<-");

        // Add fruits
        fruitsList.add("Apple");
        fruitsList.add("Banana");
        fruitsList.add("Orange");
        fruitsList.add("Grape");
        fruitsList.add("Pear");

        // Add vegetables
        vegetablesList.add("Carrot");
        vegetablesList.add("Potato");
        vegetablesList.add("Tomato");
        vegetablesList.add("Cucumber");
        vegetablesList.add("Onion");

        // Add components to frame
        add(fruitsList);
        add(toRightButton);
        add(toLeftButton);
        add(vegetablesList);

        // Right button action
        toRightButton.addActionListener(e -> {
            String[] selectedItems = fruitsList.getSelectedItems();
            for (String item : selectedItems) {
                vegetablesList.add(item);
                fruitsList.remove(item);
            }
        });

        // Left button action
        toLeftButton.addActionListener(e -> {
            String[] selectedItems = vegetablesList.getSelectedItems();
            for (String item : selectedItems) {
                fruitsList.add(item);
                vegetablesList.remove(item);
            }
        });

        // Add window closing handler
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new GroceryListFrame();
    }
}
