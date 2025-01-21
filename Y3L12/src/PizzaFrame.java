import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.time.chrono.MinguoEra;

public class PizzaFrame extends JFrame{
    public PizzaFrame() {

        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());


        final Pizza[] pizza = {new PizzaBase()};

//        pizza[0] = new Tomato(pizza[0]);
//        pizza[0] = new Salami(pizza[0]);
//        pizza[0] = new Corn(pizza[0]);
//        pizza[0] = new Olive(pizza[0]);

//        System.out.println("Price: " + pizza[0].getPrice());
//        System.out.println("Ingredients: " + pizza[0].getIngredients());

        PizzaPanel pizzaPanel = new PizzaPanel(pizza[0]);
        frame.add(pizzaPanel, BorderLayout.CENTER);
        //frame.pack();
        JPanel Menu = new JPanel();
        frame.add(Menu,BorderLayout.EAST);
        JMenuBar options = new JMenuBar();
        JMenu ingredientsMenu = new JMenu("Ingredients");

        JCheckBoxMenuItem tomato = new JCheckBoxMenuItem("Tomato");
        JCheckBoxMenuItem corn = new JCheckBoxMenuItem("Corn");
        JCheckBoxMenuItem olive = new JCheckBoxMenuItem("Olive");
        JCheckBoxMenuItem salami = new JCheckBoxMenuItem("Salami");
        JCheckBoxMenuItem mushroom = new JCheckBoxMenuItem("Mushroom");
        ingredientsMenu.add(tomato);
        ingredientsMenu.add(corn);
        ingredientsMenu.add(olive);
        ingredientsMenu.add(salami);
        ingredientsMenu.add(mushroom);
        options.add(ingredientsMenu);
        Menu.add(options);

        JButton save = new JButton("Save Pizza");
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] saveings= pizza[0].getIngredients().split(", ");
                JFileChooser fileChooser = new JFileChooser();
                if (fileChooser.showSaveDialog(null)==JFileChooser.APPROVE_OPTION){
                    try (PrintWriter writer = new PrintWriter(fileChooser.getSelectedFile())){
                        for(String saveing : saveings){
                            writer.println(saveing);
                        }
                        JOptionPane.showMessageDialog(null,"Sikeresen mentve!");
                    } catch (FileNotFoundException p){
                        System.out.println("Hiba a fajl mentesekor!");
                    }
                }
            }
        });
        Menu.add(save);

        JPanel bottom = new JPanel(new GridLayout(2,1));
        JLabel price= new JLabel("Price: " + pizza[0].getPrice()+"$");
        JLabel ingredients = new JLabel("Ingredients: "+ pizza[0].getIngredients());

        JButton load = new JButton("Load Pizza");
        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                if (fileChooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
                    try(BufferedReader file = new BufferedReader(new FileReader(fileChooser.getSelectedFile()))){
                        tomato.setSelected(false);
                        corn.setSelected(false);
                        mushroom.setSelected(false);
                        salami.setSelected(false);
                        olive.setSelected(false);

                        String ing;
                        pizza[0] = new PizzaBase();
                        while((ing = file.readLine()) != null){
                            if (ing.equals("Tomato")){
                                tomato.setSelected(true);
                                pizza[0] = new Tomato(pizza[0]);
                            } else if (ing.equals("Corn")) {
                                corn.setSelected(true);
                                pizza[0] = new Corn(pizza[0]);
                            } else if (ing.equals("Olive")) {
                                olive.setSelected(true);
                                pizza[0] = new Olive(pizza[0]);
                            } else if (ing.equals("Salami")) {
                                salami.setSelected(true);
                                pizza[0] = new Salami(pizza[0]);
                            } else if (ing.equals("Mushroom")) {
                                mushroom.setSelected(true);
                                pizza[0] = new Mushroom(pizza[0]);
                            }
                        }
                        pizzaPanel.updatePizza(pizza[0]);
                        price.setText("Price: " + pizza[0].getPrice() + "$");
                        ingredients.setText("Ingredients: " + pizza[0].getIngredients());
                    } catch (IOException l){
                        System.out.println("Hiba a fajl betoltesekor");
                    }
                }
            }
        });
        Menu.add(load);


        bottom.add(price);
        bottom.add(ingredients);
        frame.add(bottom, BorderLayout.SOUTH);

        tomato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tomato.isSelected()) {
                    pizza[0] = new Tomato(pizza[0]);
                    //pizzaPanel.updatePizza(pizza[0]);
                    //price.setText("Price: " + pizza[0].getPrice() + "$");
                    //ingredients.setText("Ingredients: " + pizza[0].getIngredients());
                } else {
                    pizza[0] = new PizzaBase();
                    if (corn.isSelected()){
                        pizza[0] = new Corn(pizza[0]);
                    }
                    if (olive.isSelected()){
                        pizza[0]=new Olive(pizza[0]);
                    }
                    if (salami.isSelected()){
                        pizza[0]=new Salami(pizza[0]);
                    }
                    if (mushroom.isSelected()){
                        pizza[0]=new Mushroom(pizza[0]);
                    }
                    pizzaPanel.updatePizza(pizza[0]);
                    price.setText("Price: " + pizza[0].getPrice() + "$");
                    ingredients.setText("Ingredients: " + pizza[0].getIngredients());
                }

            }
        });
        corn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (corn.isSelected()) {
                    pizza[0] = new Corn(pizza[0]);
                    pizzaPanel.updatePizza(pizza[0]);
                    price.setText("Price: " + pizza[0].getPrice() + "$");
                    ingredients.setText("Ingredients: " + pizza[0].getIngredients());
                } else {
                    pizza[0] = new PizzaBase();
                    if (tomato.isSelected()){
                        pizza[0] = new Tomato(pizza[0]);
                    }
                    if (olive.isSelected()){
                        pizza[0]=new Olive(pizza[0]);
                    }
                    if (salami.isSelected()){
                        pizza[0]=new Salami(pizza[0]);
                    }
                    if (mushroom.isSelected()){
                        pizza[0]=new Mushroom(pizza[0]);
                    }
                    pizzaPanel.updatePizza(pizza[0]);
                    price.setText("Price: " + pizza[0].getPrice() + "$");
                    ingredients.setText("Ingredients: " + pizza[0].getIngredients());
                }
            }
        });
        olive.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (olive.isSelected()) {
                    pizza[0] = new Olive(pizza[0]);
                    pizzaPanel.updatePizza(pizza[0]);
                    price.setText("Price: " + pizza[0].getPrice() + "$");
                    ingredients.setText("Ingredients: " + pizza[0].getIngredients());
                } else {
                    pizza[0] = new PizzaBase();
                    if (tomato.isSelected()) {
                        pizza[0] = new Tomato(pizza[0]);
                    }
                    if (corn.isSelected()) {
                        pizza[0] = new Corn(pizza[0]);
                    }
                    if (salami.isSelected()) {
                        pizza[0] = new Salami(pizza[0]);
                    }
                    if (mushroom.isSelected()) {
                        pizza[0] = new Mushroom(pizza[0]);
                    }
                    pizzaPanel.updatePizza(pizza[0]);
                    price.setText("Price: " + pizza[0].getPrice() + "$");
                    ingredients.setText("Ingredients: " + pizza[0].getIngredients());
                }
            }
        });
        salami.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (salami.isSelected()) {
                    pizza[0] = new Salami(pizza[0]);
                    pizzaPanel.updatePizza(pizza[0]);
                    price.setText("Price: " + pizza[0].getPrice() + "$");
                    ingredients.setText("Ingredients: " + pizza[0].getIngredients());
                } else {
                    pizza[0] = new PizzaBase();
                    if (tomato.isSelected()) {
                        pizza[0] = new Tomato(pizza[0]);
                    }
                    if (corn.isSelected()) {
                        pizza[0] = new Corn(pizza[0]);
                    }
                    if (olive.isSelected()) {
                        pizza[0] = new Olive(pizza[0]);
                    }
                    if (mushroom.isSelected()) {
                        pizza[0] = new Mushroom(pizza[0]);
                    }
                    pizzaPanel.updatePizza(pizza[0]);
                    price.setText("Price: " + pizza[0].getPrice() + "$");
                    ingredients.setText("Ingredients: " + pizza[0].getIngredients());
                }
            }
        });
        mushroom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mushroom.isSelected()) {
                    pizza[0] = new Mushroom(pizza[0]);
                    pizzaPanel.updatePizza(pizza[0]);
                    price.setText("Price: " + pizza[0].getPrice() + "$");
                    ingredients.setText("Ingredients: " + pizza[0].getIngredients());
                } else {
                    pizza[0] = new PizzaBase();
                    if (tomato.isSelected()) {
                        pizza[0] = new Tomato(pizza[0]);
                    }
                    if (corn.isSelected()) {
                        pizza[0] = new Corn(pizza[0]);
                    }
                    if (olive.isSelected()) {
                        pizza[0] = new Olive(pizza[0]);
                    }
                    if (salami.isSelected()) {
                        pizza[0] = new Salami(pizza[0]);
                    }
                    pizzaPanel.updatePizza(pizza[0]);
                    price.setText("Price: " + pizza[0].getPrice() + "$");
                    ingredients.setText("Ingredients: " + pizza[0].getIngredients());
                }
            }
        });

        frame.setSize(800,600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new PizzaFrame();
    }
}