import java.awt.*;
import java.awt.event.*;

public class Question02 extends Frame implements ActionListener {
    private final TextField first = new TextField(12);
    private final TextField second = new TextField(12);
    private final Label result = new Label("Result: ");

    public Question02() {
        super("Simple AWT Calculator");
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 12));
        add(new Label("First number:")); add(first);
        add(new Label("Second number:")); add(second);
        String[] operations = {"+", "-", "*", "/"};
        for (String operation : operations) {
            Button button = new Button(operation);
            button.addActionListener(this);
            add(button);
        }
        add(result);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { dispose(); }
        });
        setSize(350, 180);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double a = Double.parseDouble(first.getText().trim());
            double b = Double.parseDouble(second.getText().trim());
            double answer;
            switch (e.getActionCommand()) {
                case "+": answer = a + b; break;
                case "-": answer = a - b; break;
                case "*": answer = a * b; break;
                case "/":
                    if (b == 0) { result.setText("Cannot divide by zero."); return; }
                    answer = a / b; break;
                default: return;
            }
            result.setText("Result: " + answer);
        } catch (NumberFormatException ex) {
            result.setText("Enter valid numbers.");
        }
    }

    public static void main(String[] args) { new Question02(); }
}
