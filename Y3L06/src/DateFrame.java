import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.concurrent.Flow;

public class DateFrame extends JFrame {
    public DateFrame() throws HeadlessException {

        JFrame frame = new JFrame("DateFrame");
        JLabel alap = new JLabel("Kattints a gombra a mai datum kiiratasahoz!");
        JButton kiir = new JButton("Click");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        JLabel datum = new JLabel("~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        JPanel r1 = new JPanel(new FlowLayout());
        JPanel r2 = new JPanel(new FlowLayout());
        JPanel r3 = new JPanel(new FlowLayout());

        kiir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == kiir) {
                    LocalDateTime date = LocalDateTime.now();
                    datum.setText(dtf.format(date));
                }
            }
        });

//        frame.add(alap);
//        frame.add(kiir);
//        frame.add(datum);
        frame.add(r1);
        r1.add(alap);
        frame.add(r2);
        r2.add(kiir);
        frame.add(r3);
        r3.add(datum);
        frame.setLayout(new GridLayout(3,1));
        frame.setSize(300,200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
