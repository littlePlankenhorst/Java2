import java.awt.*;
import java.awt.event.*;

public class TextFilterFrame {
    public TextFilterFrame() {
        Frame frame = new Frame("TextFilterFrame");
        Label szo = new Label("Ird be a szot: ");
        TextField filter = new TextField("");
        TextArea area = new TextArea();
        Button gomb = new Button("filter");

        frame.add(szo);
        frame.add(filter);
        frame.add(gomb);
        frame.add(area);

        gomb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                area.replaceRange(area.getSelectedText().replace(filter.getText(),""),area.getSelectionStart(),area.getSelectionEnd());
            }
        });

        frame.setVisible(true);
        frame.setSize(550,300);
        frame.setLayout(new FlowLayout());
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
