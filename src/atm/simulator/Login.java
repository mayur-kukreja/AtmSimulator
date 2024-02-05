/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.simulator;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

/**
 *
 * @author Mayur Kukreja
 */
public class Login extends JFrame implements ActionListener {

    JLabel l1, l2, l3;
    JTextField tf1;
    JPasswordField pf1;
    JButton b1, b2, b3;

    Login() {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel j1 = new JLabel(i3);
        j1.setBounds(70, 10, 100, 100);
        add(j1);
        setLayout(null);
        l1 = new JLabel("WELCOME TO  ATM");
        l1.setFont(new Font("Osward", Font.BOLD, 38));
        l1.setBounds(200, 40, 450, 40);
        add(l1);

        l2 = new JLabel("CARD NO");
        l2.setFont(new Font("Raleway", Font.BOLD, 28));
        l2.setBounds(125, 150, 375, 30);
        add(l2);

        tf1 = new JTextField(15);
        tf1.setFont(new Font("Arial", Font.BOLD, 14));
        tf1.setBounds(300, 150, 230, 30);
        add(tf1);

        l3 = new JLabel("PIN");
        l3.setFont(new Font("Arial", Font.BOLD, 28));
        l3.setBounds(125, 220, 375, 30);
        add(l3);

        pf1 = new JPasswordField(15);
        pf1.setFont(new Font("Arial", Font.BOLD, 14));
        pf1.setBounds(300, 220, 230, 30);
        add(pf1);

        b1 = new JButton("SIGN IN");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b2 = new JButton("CLEAR");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        b3 = new JButton("SIGNUP");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);

        b1.setFont(new Font("Arial", Font.BOLD, 14));
        b1.setBounds(300, 300, 100, 30);
        add(b1);

        b2.setFont(new Font("Arial", Font.BOLD, 14));
        b2.setBounds(430, 300, 100, 30);
        add(b2);

        b3.setFont((new Font("Arial", Font.BOLD, 14)));
        b3.setBounds(300, 350, 230, 30);
        add(b3);

        b1.addActionListener(this);

        b2.addActionListener(this);
        b3.addActionListener(this);

        setVisible(true);
        setSize(800, 480);
        setLocation(550, 200);
        setTitle("AUTOMATED TALLER MACHINE");
        getContentPane().setBackground(Color.WHITE);

    }

    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getSource() == b1) {
                conn con = new conn();
                String cardno = tf1.getText();
                String pin = pf1.getText();
                String q = "select * from login where cardno='" + cardno + "'and pin='" + pin + "'";
                ResultSet rs = con.s.executeQuery(q);
                if (rs.next()) {
                    setVisible(false);
                    new Transaction(pin).setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(null, "Incorect cardno or pin");
                }

            } else if (ae.getSource() == b2) {
                tf1.setText("");
                pf1.setText("");
            } else if (ae.getSource() == b3) {
                setVisible(false);
                new SignUp().setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Login();
    }

}
