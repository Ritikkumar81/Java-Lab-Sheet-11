import javax.swing.*;
import java.awt.*;

public class Question03 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Student Login Form");
            JTextField username = new JTextField(15);
            JPasswordField password = new JPasswordField(15);
            JButton login = new JButton("Login");
            JButton reset = new JButton("Reset");

            JPanel panel = new JPanel(new GridLayout(3, 2, 8, 8));
            panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
            panel.add(new JLabel("Username:")); panel.add(username);
            panel.add(new JLabel("Password:")); panel.add(password);
            panel.add(login); panel.add(reset);

            login.addActionListener(e -> {
                String user = username.getText().trim();
                String pass = new String(password.getPassword());
                if (user.equals("student") && pass.equals("java123")) {
                    JOptionPane.showMessageDialog(frame, "Login successful!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid username or password.",
                            "Login Failed", JOptionPane.ERROR_MESSAGE);
                }
            });
            reset.addActionListener(e -> {
                username.setText("");
                password.setText("");
            });

            frame.add(panel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
