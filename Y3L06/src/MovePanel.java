import javax.swing.*;
import java.awt.*;

public class MovePanel extends JPanel {
    private int posx=100;
    private int posy=150;
    private int rad=50;
    public MovePanel() {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(300,300));
    }

    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

    public int getRad() {
        return rad;
    }

    public void setRad(int rad) {
        this.rad = rad;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.fillOval(posx, posy, rad, rad);
    }
}
