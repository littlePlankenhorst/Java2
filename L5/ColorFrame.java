import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class ColorFrame extends Frame {
    private Choice colorChoice;
    private Random random;

    public ColorFrame() {
        setBounds(100, 100, 300, 200);
        setLayout(new FlowLayout());
        setTitle("Színválasztó");
        
        random = new Random();
        
        colorChoice = new Choice();
        colorChoice.add("red");
        colorChoice.add("green");
        colorChoice.add("blue");
        colorChoice.add("random");
        

        add(colorChoice);
        

        colorChoice.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                String selected = colorChoice.getSelectedItem();
                switch(selected) {
                    case "red":
                        setBackground(Color.RED);
                        break;
                    case "green":
                        setBackground(Color.GREEN);
                        break;
                    case "blue":
                        setBackground(Color.BLUE);
                        break;
                    case "random":
                        setBackground(new Color(
                            random.nextInt(256),
                            random.nextInt(256),
                            random.nextInt(256)
                        ));
                        break;
                }
            }
        });
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });
        
        setVisible(true);
    }

    public static void main(String[] args) {
        new ColorFrame();
    }
}
