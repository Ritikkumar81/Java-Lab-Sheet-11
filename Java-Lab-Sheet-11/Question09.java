import javax.swing.*;
import java.awt.*;

public class Question09 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Student Feedback Form");
            JTextField name = new JTextField(18);
            JTextField roll = new JTextField(18);
            JTextField course = new JTextField(18);

            String[] ratings = {"Excellent", "Very Good", "Good", "Average", "Poor"};
            JRadioButton[] ratingButtons = new JRadioButton[ratings.length];
            ButtonGroup ratingGroup = new ButtonGroup();
            JPanel ratingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            for (int i = 0; i < ratings.length; i++) {
                ratingButtons[i] = new JRadioButton(ratings[i]);
                ratingGroup.add(ratingButtons[i]);
                ratingPanel.add(ratingButtons[i]);
            }

            JCheckBox teaching = new JCheckBox("Teaching");
            JCheckBox laboratory = new JCheckBox("Laboratory");
            JCheckBox material = new JCheckBox("Course Material");
            JCheckBox assignments = new JCheckBox("Assignments");
            JPanel feedbackPanel = new JPanel(new GridLayout(2, 2));
            feedbackPanel.add(teaching); feedbackPanel.add(laboratory);
            feedbackPanel.add(material); feedbackPanel.add(assignments);

            JTextArea comments = new JTextArea(4, 20);
            JButton submit = new JButton("Submit");
            JButton reset = new JButton("Reset");

            JPanel panel = new JPanel(new GridLayout(8, 2, 6, 6));
            panel.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
            panel.add(new JLabel("Student Name:")); panel.add(name);
            panel.add(new JLabel("Roll Number:")); panel.add(roll);
            panel.add(new JLabel("Course:")); panel.add(course);
            panel.add(new JLabel("Rating:")); panel.add(ratingPanel);
            panel.add(new JLabel("Feedback Areas:")); panel.add(feedbackPanel);
            panel.add(new JLabel("Comments:")); panel.add(new JScrollPane(comments));
            panel.add(submit); panel.add(reset);

            submit.addActionListener(e -> {
                String selectedRating = "Not selected";
                for (JRadioButton button : ratingButtons) {
                    if (button.isSelected()) selectedRating = button.getText();
                }
                String areas = "";
                if (teaching.isSelected()) areas += "Teaching, ";
                if (laboratory.isSelected()) areas += "Laboratory, ";
                if (material.isSelected()) areas += "Course Material, ";
                if (assignments.isSelected()) areas += "Assignments, ";
                if (!areas.isEmpty()) areas = areas.substring(0, areas.length() - 2);
                JOptionPane.showMessageDialog(frame, "Name: " + name.getText()
                        + "\nRoll Number: " + roll.getText()
                        + "\nCourse: " + course.getText()
                        + "\nRating: " + selectedRating
                        + "\nFeedback: " + (areas.isEmpty() ? "None" : areas)
                        + "\nComments: " + comments.getText());
            });
            reset.addActionListener(e -> {
                name.setText(""); roll.setText(""); course.setText("");
                ratingGroup.clearSelection();
                teaching.setSelected(false); laboratory.setSelected(false);
                material.setSelected(false); assignments.setSelected(false);
                comments.setText("");
            });

            frame.add(panel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
