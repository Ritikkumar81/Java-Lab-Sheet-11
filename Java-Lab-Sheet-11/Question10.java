import javax.swing.*;
import java.awt.*;

public class Question10 {
    private static double balance = 0.0;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Mini Banking Application");
            JTextField accountNumber = new JTextField(15);
            JTextField customerName = new JTextField(15);
            JTextField amount = new JTextField(15);
            JLabel balanceLabel = new JLabel("Current Balance: ₹0.00");

            JButton deposit = new JButton("Deposit");
            JButton withdraw = new JButton("Withdraw");
            JButton check = new JButton("Check Balance");
            JButton clear = new JButton("Clear");

            JPanel panel = new JPanel(new GridLayout(6, 2, 8, 8));
            panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
            panel.add(new JLabel("Account Number:")); panel.add(accountNumber);
            panel.add(new JLabel("Customer Name:")); panel.add(customerName);
            panel.add(new JLabel("Amount:")); panel.add(amount);
            panel.add(deposit); panel.add(withdraw);
            panel.add(check); panel.add(clear);
            panel.add(new JLabel("Balance:")); panel.add(balanceLabel);

            deposit.addActionListener(e -> {
                try {
                    double value = Double.parseDouble(amount.getText().trim());
                    if (value <= 0) throw new NumberFormatException();
                    balance += value;
                    balanceLabel.setText(String.format("Current Balance: ₹%.2f", balance));
                    JOptionPane.showMessageDialog(frame, "Amount deposited successfully.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Enter a valid amount greater than zero.");
                }
            });

            withdraw.addActionListener(e -> {
                try {
                    double value = Double.parseDouble(amount.getText().trim());
                    if (value <= 0) throw new NumberFormatException();
                    if (value > balance) {
                        JOptionPane.showMessageDialog(frame, "Insufficient balance.");
                    } else {
                        balance -= value;
                        balanceLabel.setText(String.format("Current Balance: ₹%.2f", balance));
                        JOptionPane.showMessageDialog(frame, "Amount withdrawn successfully.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Enter a valid amount greater than zero.");
                }
            });

            check.addActionListener(e -> JOptionPane.showMessageDialog(frame,
                    String.format("Account: %s\nCustomer: %s\nCurrent Balance: ₹%.2f",
                            accountNumber.getText(), customerName.getText(), balance)));
            clear.addActionListener(e -> {
                accountNumber.setText("");
                customerName.setText("");
                amount.setText("");
            });

            frame.add(panel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
