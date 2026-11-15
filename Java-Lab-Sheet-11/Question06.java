import java.awt.*;
import java.awt.event.*;

public class Question06 extends Frame implements ActionListener {
    private final TextField id = new TextField(18);
    private final TextField name = new TextField(18);
    private final TextField designation = new TextField(18);
    private final TextField salary = new TextField(18);
    private final Choice department = new Choice();
    private final CheckboxGroup gender = new CheckboxGroup();
    private final Checkbox male = new Checkbox("Male", gender, false);
    private final Checkbox female = new Checkbox("Female", gender, false);
    private final TextArea output = new TextArea(6, 35);

    public Question06() {
        super("Employee Registration Form");
        setLayout(new BorderLayout(8, 8));
        Panel form = new Panel(new GridLayout(7, 2, 6, 6));
        form.add(new Label("Employee ID:")); form.add(id);
        form.add(new Label("Name:")); form.add(name);
        form.add(new Label("Department:"));
        department.add("HR"); department.add("IT"); department.add("Finance");
        department.add("Sales"); department.add("Operations");
        form.add(department);
        form.add(new Label("Designation:")); form.add(designation);
        form.add(new Label("Salary:")); form.add(salary);
        Panel genderPanel = new Panel(new FlowLayout(FlowLayout.LEFT));
        genderPanel.add(male); genderPanel.add(female);
        form.add(new Label("Gender:")); form.add(genderPanel);

        Button submit = new Button("Submit");
        Button clear = new Button("Clear");
        submit.addActionListener(this); clear.addActionListener(this);
        form.add(submit); form.add(clear);
        add(form, BorderLayout.NORTH);
        output.setEditable(false);
        add(output, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { dispose(); }
        });
        setSize(470, 420);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Submit")) {
            String selectedGender = gender.getSelectedCheckbox() == null
                    ? "Not selected" : gender.getSelectedCheckbox().getLabel();
            output.setText("Employee ID: " + id.getText()
                    + "\nName: " + name.getText()
                    + "\nDepartment: " + department.getSelectedItem()
                    + "\nDesignation: " + designation.getText()
                    + "\nSalary: " + salary.getText()
                    + "\nGender: " + selectedGender);
        } else {
            id.setText(""); name.setText(""); designation.setText(""); salary.setText("");
            department.select(0); gender.setSelectedCheckbox(null); output.setText("");
        }
    }

    public static void main(String[] args) { new Question06(); }
}
