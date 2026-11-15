import javax.swing.*;
import java.awt.*;

public class Question05 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Course Selection Form");
            JTextField name = new JTextField(18);
            JComboBox<String> course = new JComboBox<>(new String[]{"BCA", "BBA", "B.Com", "BA", "B.Sc"});
            JRadioButton male = new JRadioButton("Male");
            JRadioButton female = new JRadioButton("Female");
            ButtonGroup gender = new ButtonGroup();
            gender.add(male); gender.add(female);

            JCheckBox java = new JCheckBox("Java");
            JCheckBox dbms = new JCheckBox("DBMS");
            JCheckBox networking = new JCheckBox("Computer Networks");
            JButton submit = new JButton("Submit");
            JButton reset = new JButton("Reset");

            JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            genderPanel.add(male); genderPanel.add(female);
            JPanel subjectsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            subjectsPanel.add(java); subjectsPanel.add(dbms); subjectsPanel.add(networking);
            JPanel panel = new JPanel(new GridLayout(6, 2, 8, 8));
            panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
            panel.add(new JLabel("Student Name:")); panel.add(name);
            panel.add(new JLabel("Course:")); panel.add(course);
            panel.add(new JLabel("Gender:")); panel.add(genderPanel);
            panel.add(new JLabel("Subjects:")); panel.add(subjectsPanel);
            panel.add(submit); panel.add(reset);

            submit.addActionListener(e -> {
                String selectedGender = male.isSelected() ? "Male" : female.isSelected() ? "Female" : "Not selected";
                String selectedSubjects = "";
                if (java.isSelected()) selectedSubjects += "Java ";
                if (dbms.isSelected()) selectedSubjects += "DBMS ";
                if (networking.isSelected()) selectedSubjects += "Computer Networks ";
                JOptionPane.showMessageDialog(frame, "Name: " + name.getText()
                        + "\nCourse: " + course.getSelectedItem()
                        + "\nGender: " + selectedGender
                        + "\nSubjects: " + (selectedSubjects.isEmpty() ? "None" : selectedSubjects));
            });
            reset.addActionListener(e -> {
                name.setText("");
                course.setSelectedIndex(0);
                gender.clearSelection();
                java.setSelected(false); dbms.setSelected(false); networking.setSelected(false);
            });

            frame.add(panel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
