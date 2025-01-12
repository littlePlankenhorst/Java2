import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        int numberOfFlowers = 5;
        Flower[] flowers = new Flower[numberOfFlowers];
        for (int i = 0; i < numberOfFlowers; i++) {
            flowers[i] = new Flower(150 + (int) (Math.random() * 100));
        }

        View gardenView = new View(flowers);

        Controller controller = new Controller(flowers, gardenView::repaint);

        JFrame frame = new JFrame("Garden Simulation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.add(gardenView);
        frame.setVisible(true);

        controller.startGrowth();
    }
}
