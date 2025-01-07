import java.awt.*;
import javax.swing.*;

public class MovePanel extends JPanel {
    private int posX = 40; 
    private int posY = 20; 

    public MovePanel() {

        setPreferredSize(new Dimension(500, 400));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        g.setColor(Color.BLUE); 
        g.fillOval(posX, posY, 50, 50); 
    }

    public void moveCircle(int deltaX, int deltaY) {
        
        int newX = posX + deltaX;
        int newY = posY + deltaY;

        
        if (newX >= 0 && newX <= getWidth() - 50) { 
            posX = newX;
        }
        if (newY >= 0 && newY <= getHeight() - 50) { 
            posY = newY;
        }

        repaint(); }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MoveCircleFrame");
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false); 

        MovePanel panel = new MovePanel();
        frame.add(panel, BorderLayout.CENTER);

        JButton fel = new JButton("↑");
        JButton le = new JButton("↓");
        JButton bal = new JButton("←");
        JButton jobb = new JButton("→");

        fel.addActionListener(e -> panel.moveCircle(0, -10));
        le.addActionListener(e -> panel.moveCircle(0, 10));
        bal.addActionListener(e -> panel.moveCircle(-10, 0));
        jobb.addActionListener(e -> panel.moveCircle(10, 0));

        frame.add(fel, BorderLayout.NORTH);
        frame.add(le, BorderLayout.SOUTH);
        frame.add(bal, BorderLayout.WEST);
        frame.add(jobb, BorderLayout.EAST);

        frame.setVisible(true);
    }
}