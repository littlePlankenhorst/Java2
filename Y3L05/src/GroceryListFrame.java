import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GroceryListFrame extends Frame{
    public GroceryListFrame() throws HeadlessException {

        Frame frame = new Frame("GroceryListFrame");
        List vegs = new List();
        vegs.add("murok");
        vegs.add("pityi");
        List fruits= new List();
        fruits.add("banan");
        fruits.add("alma");
        Button jobbra = new Button("->");
        Button balra = new Button("<-");
        vegs.setMultipleMode(true);
        fruits.setMultipleMode(true);

        jobbra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String toFruits[] = vegs.getSelectedItems();
                for (int i=0;i<toFruits.length;i++)
                {
                    fruits.add(toFruits[i]);
                    vegs.remove(toFruits[i]);
                }
            }
        });
        balra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String toVeggies[] = fruits.getSelectedItems();
                for (int i=0;i<toVeggies.length;i++)
                {
                    vegs.add(toVeggies[i]);
                    fruits.remove(toVeggies[i]);
                }
            }
        });


        frame.add(vegs);
        frame.add(fruits);
        frame.add(jobbra);
        frame.add(balra);
        frame.setSize(275,150);
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
