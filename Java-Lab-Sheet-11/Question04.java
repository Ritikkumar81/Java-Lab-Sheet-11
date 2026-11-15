import javax.swing.*;
import java.awt.*;

public class Question04 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Student Marksheet");
            String[] subjects = {"English", "Mathematics", "Java", "DBMS", "Computer Networks"};
            JTextField[] marks = new JTextField[subjects.length];
            JPanel panel = new JPanel(new GridLayout(subjects.length + 2, 2, 8, 8));
            panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

            for (int i = 0; i < subjects.length; i++) {
                panel.add(new JLabel(subjects[i] + " marks:"));
                marks[i] = new JTextField();
                panel.add(marks[i]);
            }

            JButton calculate = new JButton("Calculate Result");
            JLabel result = new JLabel("Enter marks from 0 to 100.");
            panel.add(calculate);
            panel.add(result);

            calculate.addActionListener(e -> {
                int total = 0;
                try {
                    for (JTextField field : marks) {
                        int value = Integer.parseInt(field.getText().trim());
                        if (value < 0 || value > 100) throw new NumberFormatException();
                        total += value;
                    }
                    double percentage = total / 5.0;
                    boolean passed = true;
                    for (JTextField field : marks) {
                        if (Integer.parseInt(field.getText().trim()) < 33) passed = false;
                    }
                    String grade = percentage >= 90 ? "A+" : percentage >= 80 ? "A"
                            : percentage >= 70 ? "B" : percentage >= 60 ? "C"
                            : percentage >= 50 ? "D" : percentage >= 33 ? "E" : "F";
                    result.setText(String.format("<html>Total: %d/500<br>Percentage: %.2f%%<br>Grade: %s<br>Status: %s</html>",
                            total, percentage, grade, passed ? "Pass" : "Fail"));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Enter valid whole-number marks (0-100) for every subject.");
                }
            });

            frame.add(panel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
