import javax.swing.*;
import java.awt.*;

public class FlowerFrame extends JFrame {
    public FlowerFrame() throws HeadlessException {
        JFrame frame = new JFrame("GardenFrame");
        int number=5;

        Flower[] flowers= new Flower[number];
        Controller[] controllers = new Controller[number];
        View[] views = new View[number];
        frame.setLayout(new GridLayout(1, number));
        for (int i=0;i < flowers.length;i++){
            flowers[i] = new Flower();
            views[i] = new View(flowers[i],i+1);
            frame.add(views[i]);
            controllers[i] = new Controller();
            controllers[i].growFlower(flowers[i], views[i]::repaint);
        }

        frame.setSize(600,500);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    public static void main(String[] args) {
        new FlowerFrame();
    }
}
