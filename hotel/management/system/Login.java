package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JTextField username;
    JPasswordField password;
    JButton login, cancel;

    Login() {
        // Window Background
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Username Label & Field
        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(40, 20, 100, 30);
        add(userLabel);

        username = new JTextField();
        username.setBounds(150, 20, 150, 30);
        add(username);

        // Password Label & Field
        JLabel passLabel = new JLabel("Password");
        passLabel.setBounds(40, 70, 100, 30);
        add(passLabel);

        password = new JPasswordField();
        password.setBounds(150, 70, 150, 30);
        add(password);

        // Login Button
        login = new JButton("Login");
        login.setBounds(40, 150, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        // Cancel Button
        cancel = new JButton("Cancel");
        cancel.setBounds(180, 150, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        // Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 10, 200, 200);
        add(image);

        // Frame Settings
        setBounds(500, 200, 600, 300);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            String user = username.getText();
            String pass = password.getText();

            try {
                Conn c = new Conn();

                // Correct SQL Query
                String query = "SELECT * FROM login WHERE username = '" + user + "' AND password = '" + pass + "'";
                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    setVisible(false);
                    new Dashboard(); // Show Dashboard on successful login
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == cancel) {
            setVisible(false); // Close the login window
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
