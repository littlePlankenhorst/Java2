import javax.swing.*;
import java.awt.*;

public class View extends JPanel {
    private final Flower[] flowers;

    public View(Flower[] flowers) {
        this.flowers = flowers;
        setBackground(new Color(34, 139, 34)); // Garden color
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int panelWidth = getWidth();
        int flowerWidth = panelWidth / flowers.length;

        for (int i = 0; i < flowers.length; i++) {
            Flower flower = flowers[i];

            int x = i * flowerWidth + flowerWidth / 2;
            int yBase = getHeight() - 50;
            int bodyHeight = flower.getCurrentHeight();

            g.setColor(new Color(0, 128, 0));
            g.fillRect(x - 5, yBase - bodyHeight, 10, bodyHeight);


            g.setColor(new Color(255, 0, 255));
            g.fillOval(x - 15, yBase - bodyHeight - 30, 30, 30);
        }


        g.setColor(new Color(139, 69, 19)); // Brown color
        g.fillRect(0, getHeight() - 50, getWidth(), 50);
    }
}
