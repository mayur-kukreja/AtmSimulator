/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.simulator;

import java.awt.Color;
import java.awt.Font;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Mayur Kukreja
 */
public class Withdrawl extends JFrame implements ActionListener {

    JButton b1, b2, b3;
    JLabel l1, l2, l3, l4;
    JTextField t1, t2;
    String pin;

    Withdrawl(String pin) {
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 960, 1080);
        add(l3);

        l1 = new JLabel("MAXIMUM AMOUNT OF WITHDWARL IS 10000");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        l2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System", Font.BOLD, 16));

        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 25));

        b1 = new JButton("WITHDRAW");
        b2 = new JButton("BACK");

        setLayout(null);
        setSize(960, 1080);
        setLocation(500, 0);
        setUndecorated(true);
        setVisible(true);

        l1.setBounds(190, 350, 400, 20);
        l3.add(l1);

        l2.setBounds(190, 400, 400, 20);
        l3.add(l2);

        t1.setBounds(190, 450, 330, 30);
        l3.add(t1);

        b1.setBounds(390, 588, 150, 35);
        l3.add(b1);

        b2.setBounds(390, 633, 150, 35);
        l3.add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String amount = t1.getText();
            Date date = new Date();
            if (ae.getSource() == b1) {
                if (amount.equals("")) {
                    JOptionPane.showMessageDialog(null, "PLEASE ENTER THE AMOUNT YOU WANT TO WITHDRAW");

                } else {
                    conn conn = new conn();
                    ResultSet rs = conn.s.executeQuery("select * from bank where pin='" + pin + "'");
                    int balance = 0;
                    while (rs.next()) {
                        if (rs.getString("type").equals("DEPOSIT")) {
                            balance += Integer.parseInt(rs.getString("amount"));

                        } else {
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }

                    }
                    if (balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "INSUFFICENT BALANCE");
                        return;
                    }

                    conn.s.executeUpdate("insert into bank values('" + pin + "','" + date + "','WITHDRAW','" + amount + "')");
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully");
                    setVisible(false);
                    new Transaction(pin).setVisible(true);

                }

            }
            if (ae.getSource() == b2) {
                setVisible(false);
                new Transaction(pin).setVisible(true);

            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error: " + e);
        }

    }

    public static void main(String[] args) {

    }

}
