import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  

import javax.swing.*;

public class DataFrame extends JFrame {
    {
        JFrame frame = new JFrame();
        frame.setTitle("DataFrame");
        frame.setSize(500, 100);
        frame.setLayout(new FlowLayout(5, 25, 15));


        JButton button = new JButton("Kattints a datumert");
        button.setBounds(150, 200, 220, 50);
        frame.add(button);

        JLabel label = new JLabel("");
        frame.add(label);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == button) {
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
                    LocalDateTime now = LocalDateTime.now();  
                    label.setText(dtf.format(now));
                }
            }
        });
            

        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setVisible(true);
}
public static void main(String[] args) {
    new DataFrame();
}
}