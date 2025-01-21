import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.util.random.*;

public class PushFrame extends JFrame {
    public PushFrame() throws HeadlessException {

        JFrame frame = new JFrame("PushFrame");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(500,500);
        frame.setMinimumSize(new Dimension(500,500));
        frame.setResizable(false);
        JPanel panel = new JPanel();
        panel.setSize(frame.getSize());
        frame.add(panel);

        Random random = new Random();

        Button catchMe = new Button("Click me!");
        int cX=30;
        int cY=30;
        catchMe.setBounds(cX,cY,100,30);
        panel.add(catchMe);
        catchMe.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                panel.remove(catchMe);
                int rX = random.nextInt(panel.getWidth()-100);
                int rY = random.nextInt(panel.getHeight()-100);
                catchMe.setBounds(rX, rY, 100, 30);

                while (catchMe.getX()==e.getX()){
                    rX = random.nextInt(panel.getWidth()-100);
                    catchMe.setBounds(rX, rY, 100, 30);}
                while (catchMe.getY()==e.getY()){
                    rY = random.nextInt(panel.getHeight()-100);
                    catchMe.setBounds(rX, rY, 100, 30);}

                panel.add(catchMe);
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });





    }
}
