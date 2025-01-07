import java.awt.*;
import java.awt.event.*;

public class TextFilterFrame extends Frame {
    private TextField filterField;
    private Button filterButton;
    private TextArea textArea;

    public TextFilterFrame() {
        setBounds(100, 100, 400, 300);
        setLayout(new FlowLayout());
        setTitle("Text Filter");

        filterField = new TextField(20);
        filterButton = new Button("Filter");
        textArea = new TextArea(10, 40);

        add(filterField);
        add(filterButton);
        add(textArea);

        filterButton.addActionListener(e -> {
            String selectedText = textArea.getSelectedText();
            if (selectedText != null && !selectedText.isEmpty()) {
                String filterWord = filterField.getText();
                String filteredText = selectedText.replace(filterWord, "");
                textArea.replaceRange(filteredText, textArea.getSelectionStart(), textArea.getSelectionEnd());
            }
        });


        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new TextFilterFrame();
    }
}
