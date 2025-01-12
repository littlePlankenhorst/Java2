import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;
import javax.swing.*;

public class PizzaFrame extends JFrame {
    private Pizza pizza;
    private PizzaPanel pizzaPanel;
    private JPanel buttonPanel;
    private JLabel priceLabel;
    private JLabel ingredientsLabel;
    private List<String> currentIngredients;
    private Map<String, JCheckBox> ingredientCheckboxes;

    public PizzaFrame() {
        setTitle("Pizza Builder");
        setLayout(new BorderLayout());
        currentIngredients = new ArrayList<>();
        ingredientCheckboxes = new HashMap<>();

        // Initialize base pizza
        pizza = new PizzaBase();
        
        // Create pizza display panel
        pizzaPanel = new PizzaPanel(pizza);
        add(pizzaPanel, BorderLayout.CENTER);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, 1, 5, 5));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(buttonPanel, BorderLayout.EAST);

        JLabel ingredientsTitle = new JLabel("Select Ingredients:");
        ingredientsTitle.setFont(new Font("Arial", Font.BOLD, 14));
        buttonPanel.add(ingredientsTitle);

        addIngredientCheckbox("Tomato");
        addIngredientCheckbox("Salami");
        addIngredientCheckbox("Mushroom");
        addIngredientCheckbox("Corn");
        addIngredientCheckbox("Olive");

        buttonPanel.add(Box.createVerticalStrut(20)); 
        JPanel filePanel = new JPanel(new GridLayout(2, 1, 5, 5));
        filePanel.setBorder(BorderFactory.createTitledBorder("Recipe Management"));
        
        JButton saveButton = new JButton("Save Pizza Recipe");
        saveButton.addActionListener(e -> savePizza());
        filePanel.add(saveButton);

        JButton loadButton = new JButton("Load Pizza Recipe");
        loadButton.addActionListener(e -> loadPizza());
        filePanel.add(loadButton);

        buttonPanel.add(filePanel);

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(2, 1));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        priceLabel = new JLabel("Price: $" + pizza.getPrice());
        ingredientsLabel = new JLabel("Ingredients: " + pizza.getIngredients());
        infoPanel.add(priceLabel);
        infoPanel.add(ingredientsLabel);
        add(infoPanel, BorderLayout.SOUTH);

        setSize(800, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void addIngredientCheckbox(String ingredientName) {
        JCheckBox checkbox = new JCheckBox(ingredientName);
        checkbox.addActionListener(e -> updatePizzaFromCheckboxes());
        ingredientCheckboxes.put(ingredientName, checkbox);
        buttonPanel.add(checkbox);
    }

    private void updatePizzaFromCheckboxes() {

        pizza = new PizzaBase();
        currentIngredients.clear();

        for (Map.Entry<String, JCheckBox> entry : ingredientCheckboxes.entrySet()) {
            if (entry.getValue().isSelected()) {
                currentIngredients.add(entry.getKey());
                pizza = createIngredient(entry.getKey(), pizza);
            }
        }
        updatePizzaDisplay();
    }

    private Pizza createIngredient(String ingredientName, Pizza basePizza) {
        return switch (ingredientName) {
            case "Tomato" -> new Tomato(basePizza);
            case "Salami" -> new Salami(basePizza);
            case "Mushroom" -> new Mushroom(basePizza);
            case "Corn" -> new Corn(basePizza);
            case "Olive" -> new Olive(basePizza);
            default -> basePizza;
        };
    }

    private void updatePizzaDisplay() {
        pizzaPanel.updatePizza(pizza);
        priceLabel.setText("Price: $" + pizza.getPrice());
        ingredientsLabel.setText("Ingredients: " + pizza.getIngredients());
        revalidate();
        repaint();
    }

    private void savePizza() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            try (PrintWriter writer = new PrintWriter(fileChooser.getSelectedFile())) {
                for (String ingredient : currentIngredients) {
                    writer.println(ingredient);
                }
                JOptionPane.showMessageDialog(this, "Pizza recipe saved successfully!");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error saving pizza recipe: " + e.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void loadPizza() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try (BufferedReader reader = new BufferedReader(new FileReader(fileChooser.getSelectedFile()))) {
                ingredientCheckboxes.values().forEach(cb -> cb.setSelected(false));
                
         
                pizza = new PizzaBase();
                currentIngredients.clear();

                String ingredient;
                while ((ingredient = reader.readLine()) != null) {
                    JCheckBox checkbox = ingredientCheckboxes.get(ingredient);
                    if (checkbox != null) {
                        checkbox.setSelected(true);
                        currentIngredients.add(ingredient);
                        pizza = createIngredient(ingredient, pizza);
                    }
                }
                updatePizzaDisplay();
                JOptionPane.showMessageDialog(this, "Pizza recipe loaded successfully!");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error loading pizza recipe: " + e.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PizzaFrame());
    }
}