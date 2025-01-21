import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Frame extends JFrame {
    public Frame(Eskuvo eskuvo) throws HeadlessException {
        JFrame frame = new JFrame("Eskuvoszervezo alkalmazas");
        frame.setSize(600,600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        frame.setLayout(new GridLayout(4,1));
        JPanel header = new JPanel();
        JLabel koszonto = new JLabel("Udv " + eskuvo.getPar() + " eskuvojen!");
        header.add(koszonto);
        frame.add(header);

        JPanel midUp = new JPanel();
        int[] x = {eskuvo.getAsztal() * eskuvo.getKapacitas()};
        JLabel vendegek = new JLabel("Hatralevo vendegek: " + x[0]);
        midUp.add(vendegek);
        frame.add(midUp);

        JPanel midBot = new JPanel();
        JTextField but = new JTextField(50);
        midBot.add(but);
        frame.add(midBot);

        JPanel bottom = new JPanel();
        JButton feliratkoz = new JButton("Feliratkozas");

        Map<String, Integer> nevek = new HashMap<>();
        final int[] seat = {0};
        int[] tnum ={0};

        feliratkoz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nev=but.getText();
                if (!nev.isEmpty()){
                    tnum[0] = (seat[0]/eskuvo.getKapacitas())+1;

                    nevek.put(nev, tnum[0]);
                    x[0] -=1;
                    vendegek.setText("Hatrelevo vendegek: " +x[0]);
                    but.setText("");
                    seat[0]++;
                } else {
                    System.out.println("Nem adtal meg nevet!");
                }

                if(x[0]==0){
                    ArrayList<String> sor = new ArrayList<>();
                    for (Map.Entry<String,Integer> entry : nevek.entrySet()){
                        sor.add(entry.getKey()+" - " + entry.getValue());
                    }
                    sor.sort(String::compareTo);
                    StringBuilder message = new StringBuilder();
                    for (String entry : sor){
                        message.append(entry).append('\n');
                    }
                        JOptionPane.showMessageDialog(null, message.toString());
                        frame.dispose();
                    }

                    };
        });
        bottom.add(feliratkoz);
        frame.add(bottom);



        frame.setVisible(true);
    }
}
