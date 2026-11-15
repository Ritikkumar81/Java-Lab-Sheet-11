import javax.swing.*;
import java.awt.*;

public class Question07 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Temperature Converter");
            JTextField temperature = new JTextField(12);
            JRadioButton cToF = new JRadioButton("Celsius to Fahrenheit", true);
            JRadioButton fToC = new JRadioButton("Fahrenheit to Celsius");
            ButtonGroup group = new ButtonGroup();
            group.add(cToF); group.add(fToC);
            JButton convert = new JButton("Convert");
            JButton clear = new JButton("Clear");
            JLabel result = new JLabel("Result: ");

            JPanel choices = new JPanel(new GridLayout(2, 1));
            choices.add(cToF); choices.add(fToC);
            JPanel panel = new JPanel(new GridLayout(5, 2, 8, 8));
            panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
            panel.add(new JLabel("Temperature:")); panel.add(temperature);
            panel.add(new JLabel("Conversion:")); panel.add(choices);
            panel.add(convert); panel.add(clear);
            panel.add(new JLabel("Output:")); panel.add(result);

            convert.addActionListener(e -> {
                try {
                    double value = Double.parseDouble(temperature.getText().trim());
                    double converted = cToF.isSelected() ? (value * 9 / 5) + 32 : (value - 32) * 5 / 9;
                    result.setText(String.format("%.2f %s", converted,
                            cToF.isSelected() ? "°F" : "°C"));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid temperature.",
                            "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            });
            clear.addActionListener(e -> {
                temperature.setText("");
                result.setText("Result: ");
                cToF.setSelected(true);
            });

            frame.add(panel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
