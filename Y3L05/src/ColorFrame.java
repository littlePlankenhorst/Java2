import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class ColorFrame extends Frame{
    public ColorFrame() throws HeadlessException {
        Frame frame = new Frame("ColorFrame");
        Choice ColorChooser = new Choice();
        ColorChooser.add("Green");
        ColorChooser.add("Red");
        ColorChooser.add("Blue");
        ColorChooser.add("Random");

        Random random = new Random();
        ColorChooser.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String selected = ColorChooser.getSelectedItem();
                switch(selected){
                    case "Green":
                        frame.setBackground(Color.green);
                        break;
                    case "Red":
                        frame.setBackground(Color.RED);
                        break;
                    case "Blue":
                        frame.setBackground(Color.BLUE);
                        break;
                    case "Random":
                        frame.setBackground(new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256)));
                }
            }
        });

        frame.add(ColorChooser);
        frame.setSize(300,300);
        frame.setVisible(true);
        frame.setLayout(new FlowLayout());
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
