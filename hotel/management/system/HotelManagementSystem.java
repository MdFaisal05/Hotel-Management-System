/*package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class HotelManagementSystem extends JFrame implements ActionListener {

    HotelManagementSystem() {
        setBounds(100, 100, 1366, 565);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1366, 565); // x, y, width, height
        add(image);

        JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(20, 430, 1000, 90);
        text.setForeground(Color.WHITE);
       text.setFont(new Font("serif", Font.PLAIN, 50));
        image.add(text);

        JButton next = new JButton("Next");
        next.setBounds(1150, 450, 150, 50);
        next.setBackground(Color.BLUE);
        next.setForeground(Color.WHITE);
        text.setFont(new Font("serif", Font.PLAIN, 50));
        next.addActionListener(this);
        image.add(next);

        setVisible(true);
        
        while(true) {
            text.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace ();
            }
               text.setVisible(true);
               
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace ();
            }
        }
    }
    
   public void actionPerformed(ActionEvent ae) {
       setVisible(false);
       new Login();
    // Code to handle the action event
}


    public static void main(String[] args) {
        new HotelManagementSystem();
    }
}*/


package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

public class HotelManagementSystem extends JFrame implements ActionListener {

    JLabel text;

    HotelManagementSystem() {
        setBounds(100, 100, 1366, 565);
        setLayout(null);

        // Background Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1366, 565);
        add(image);

        // Blinking Text
        text = new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(20, 430, 1000, 90);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif", Font.PLAIN, 50));
        image.add(text);

        // Next Button
        JButton next = new JButton("Next");
        next.setBounds(1150, 450, 150, 50);
        next.setBackground(Color.BLUE);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("serif", Font.PLAIN, 20));
        next.addActionListener(this);
        image.add(next);

        setVisible(true);

        // Timer for blinking + changing text
        String[] messages = {"HOTEL MANAGEMENT SYSTEM", "WELCOME TO OUR HOTEL"};
        final int[] index = {0};

        Timer timer = new Timer(500, new ActionListener() {
            boolean visible = true;

            public void actionPerformed(ActionEvent e) {
                text.setVisible(visible);
                if (visible) {
                    text.setText(messages[index[0]]);
                    index[0] = (index[0] + 1) % messages.length;
                }
                visible = !visible;
            }
        });
        timer.start();
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();  // Login class aapko banani hogi
    }

    public static void main(String[] args) {
        new HotelManagementSystem();
    }
}
