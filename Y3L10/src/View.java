import javax.swing.*;
import java.awt.*;

public class View extends JPanel {
    private Flower flower;
    private int nums;
    public View(Flower flower, int nums) {
        this.flower=flower;
        this.nums=nums;
        setPreferredSize(new Dimension(getWidth()/nums,getHeight()));
        setVisible(true);
        setBackground(new Color(nums*20,200,200));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int body= flower.getCurH();

        g.setColor(new Color(0,100,0));
        g.fillRect((getWidth())/2-15,getHeight()-body-50, 10,body-0);

        g.setColor(new Color(100,10,100));
        g.fillOval((getWidth())/2-20,getHeight()-body-28-50,20,30);

        g.setColor(new Color(85, 67, 28));
        g.fillRect(0,getHeight()-50, getWidth()-0, 50);

    }
}
