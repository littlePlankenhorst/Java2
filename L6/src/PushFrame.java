import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.*;

public class PushFrame extends JFrame {
    private JButton button;
    private Random random;

    public PushFrame() {
        random = new Random();

        setTitle("Push Frame");
        setSize(400, 400);
        setMinimumSize(new Dimension(300, 300)); 
        setLayout(null); 

        button = new JButton("Push me!");
        button.setBounds(150, 150, 100, 50);

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                moveButton(e);
            }
        });

        add(button);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void moveButton(MouseEvent e) {
        int newX, newY;
        do {
            newX = random.nextInt(getWidth() - button.getWidth());
            newY = random.nextInt(getHeight() - button.getHeight());
        } while (isUnderMouse(newX, newY, e));

        button.setBounds(newX, newY, button.getWidth(), button.getHeight());
    }

    private boolean isUnderMouse(int x, int y, MouseEvent e) {
        return (x < e.getX() && x + button.getWidth() > e.getX() &&
                y < e.getY() && y + button.getHeight() > e.getY());
    }

    public static void main(String[] args) {
        new PushFrame(); 
    }
}
