import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MoveCircleFrame extends JFrame {
    public MoveCircleFrame() throws HeadlessException {
        JFrame frame = new JFrame("MoveCircleFrame");
        frame.setLayout(new BorderLayout());
        MovePanel center = new MovePanel();

        JButton balra = new JButton("WEST");
        balra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if(center.getPosx()-10 >-10) {
                   center.setPosx(center.getPosx() - 10);
                   center.repaint();
               }
            }
        });
        JButton jobbra = new JButton("EAST");
        jobbra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(center.getPosx()+10<310) {
                    center.setPosx(center.getPosx() + 10);
                    center.repaint();
                }
            }
        });
        JButton fel = new JButton("NORTH");
        fel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(center.getPosy()-10 >-10) {
                    center.setPosy(center.getPosy() - 10);
                    center.repaint();
                }
            }
        });
        JButton le = new JButton("SOUTH");
        le.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (center.getPosy()+10<370){
                    center.setPosy(center.getPosy() + 10);
                    center.repaint();
                }
            }
        });



        frame.add(center, BorderLayout.CENTER);
        frame.add(balra, BorderLayout.WEST);
        frame.add(jobbra, BorderLayout.EAST);
        frame.add(fel, BorderLayout.NORTH);
        frame.add(le, BorderLayout.SOUTH);


        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
