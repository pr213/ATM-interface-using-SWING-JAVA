import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ATMGUI extends JFrame implements ActionListener {
    private int balance = 100000;
    private JLabel balanceLabel;
    private JButton withdrawButton, depositButton, checkBalanceButton, exitButton;
    
    private final String correctPIN = "1234";  // Set the correct PIN here

    public ATMGUI() {
        if (!verifyPIN()) {
            System.exit(0); // Exit if PIN is incorrect
        }
        createUI();
    }

    // Method to verify the PIN
    private boolean verifyPIN() {
        String inputPIN = JOptionPane.showInputDialog(this, "Enter PIN:");
        if (inputPIN == null || !inputPIN.equals(correctPIN)) {
            JOptionPane.showMessageDialog(this, "Incorrect PIN! Exiting...", "Error", JOptionPane.ERROR_MESSAGE);
            return false; // Incorrect PIN
        }
        return true; // Correct PIN
    }

    private void createUI() {
        setTitle("Automated Teller Machine");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        balanceLabel = new JLabel("Current Balance: ₹" + balance, SwingConstants.CENTER);
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        mainPanel.add(balanceLabel, gbc);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        withdrawButton = createStyledButton("Withdraw");
        depositButton = createStyledButton("Deposit");
        checkBalanceButton = createStyledButton("Check Balance");
        exitButton = createStyledButton("Exit");

        buttonPanel.add(withdrawButton);
        buttonPanel.add(depositButton);
        buttonPanel.add(checkBalanceButton);
        buttonPanel.add(exitButton);

        gbc.gridy = 1;
        gbc.gridwidth = 1;
        mainPanel.add(buttonPanel, gbc);

        add(mainPanel);
        setVisible(true);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, 14));
        button.setBackground(new Color(70, 130, 180));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.addActionListener(this);
        return button;
    }

    private int getAmountInput(String message) {
        String input = JOptionPane.showInputDialog(this, message);
        if (input == null) return -1; // Cancel button pressed
        
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input! Please enter numbers only.", 
                "Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }

    private void updateBalanceDisplay() {
        balanceLabel.setText("Current Balance: ₹" + balance);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == withdrawButton) {
            handleWithdrawal();
        } else if (e.getSource() == depositButton) {
            handleDeposit();
        } else if (e.getSource() == checkBalanceButton) {
            JOptionPane.showMessageDialog(this, "Current Balance: ₹" + balance, 
                "Account Balance", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }

    private void handleWithdrawal() {
        int amount = getAmountInput("Enter withdrawal amount:");
        if (amount == -1) return;

        if (!validateInputAmount(amount)) {
            JOptionPane.showMessageDialog(this, "Please enter amount greater than zero!", 
                "Invalid Amount", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (balance >= amount) {
            balance -= amount;
            updateBalanceDisplay();
            JOptionPane.showMessageDialog(this, "Please collect your money.\nNew Balance: ₹" + balance, 
                "Transaction Successful", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Insufficient Balance!", 
                "Transaction Failed", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void handleDeposit() {
        int amount = getAmountInput("Enter deposit amount:");
        if (amount == -1) return;

        if (!validateInputAmount(amount)) {
            JOptionPane.showMessageDialog(this, "Please enter amount greater than zero!", 
                "Invalid Amount", JOptionPane.WARNING_MESSAGE);
            return;
        }

        balance += amount;
        updateBalanceDisplay();
        JOptionPane.showMessageDialog(this, "Deposit successful!\nNew Balance: ₹" + balance, 
            "Transaction Successful", JOptionPane.INFORMATION_MESSAGE);
    }

    private boolean validateInputAmount(int amount) {
        return amount > 0;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ATMGUI());
    }
}
