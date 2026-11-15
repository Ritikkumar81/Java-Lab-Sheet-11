import java.awt.*;
import java.awt.event.*;

public class Question01 extends Frame implements ActionListener {
    private final TextField name = new TextField(20);
    private final TextField roll = new TextField(20);
    private final TextField course = new TextField(20);
    private final Checkbox male = new Checkbox("Male");
    private final Checkbox female = new Checkbox("Female");
    private final CheckboxGroup gender = new CheckboxGroup();
    private final Choice semester = new Choice();
    private final Label message = new Label(" ");

    public Question01() {
        super("Student Registration Form");
        setLayout(new GridLayout(7, 2, 8, 8));
        add(new Label("Student Name:")); add(name);
        add(new Label("Roll Number:")); add(roll);
        add(new Label("Course:")); add(course);

        Panel genderPanel = new Panel(new FlowLayout(FlowLayout.LEFT));
        male.setCheckboxGroup(gender);
        female.setCheckboxGroup(gender);
        genderPanel.add(male);
        genderPanel.add(female);
        add(new Label("Gender:")); add(genderPanel);

        semester.add("Semester 1");
        semester.add("Semester 2");
        semester.add("Semester 3");
        semester.add("Semester 4");
        semester.add("Semester 5");
        semester.add("Semester 6");
        add(new Label("Semester:")); add(semester);

        Button submit = new Button("Submit");
        Button reset = new Button("Reset");
        submit.addActionListener(this);
        reset.addActionListener(this);
        add(submit); add(reset);
        add(new Label("Status:")); add(message);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { dispose(); }
        });
        setSize(430, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Submit")) {
            String selectedGender = gender.getSelectedCheckbox() == null
                    ? "Not selected" : gender.getSelectedCheckbox().getLabel();
            message.setText("Submitted: " + name.getText() + ", " + roll.getText()
                    + ", " + course.getText() + ", " + selectedGender + ", " + semester.getSelectedItem());
        } else {
            name.setText("");
            roll.setText("");
            course.setText("");
            gender.setSelectedCheckbox(null);
            semester.select(0);
            message.setText("Form cleared.");
        }
    }

    public static void main(String[] args) { new Question01(); }
}
