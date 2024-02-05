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
public class Fastcash extends JFrame implements ActionListener {

    JLabel l1, l2;
    JButton b1, b2, b3, b4, b5, b6, b7, b8;
    JTextField t1;
    String pin;

    Fastcash(String pin) {
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 960, 1080);
        add(l3);

        l1 = new JLabel("SELECT WITHDRAWL AMOUNT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        b1 = new JButton("RS 100");
        b2 = new JButton("RS 500");
        b3 = new JButton("RS 1000");
        b4 = new JButton("RS 2000");
        b5 = new JButton("RS 5000");
        b6 = new JButton("RS 10000");
        b7 = new JButton("EXIT");
        setLayout(null);
        l1.setBounds(235, 400, 700, 35);
        l3.add(l1);

        b1.setBounds(170, 499, 150, 35);
        l3.add(b1);

        b2.setBounds(390, 499, 150, 35);
        l3.add(b2);

        b3.setBounds(170, 543, 150, 35);
        l3.add(b3);

        b4.setBounds(390, 543, 150, 35);
        l3.add(b4);

        b5.setBounds(170, 588, 150, 35);
        l3.add(b5);

        b6.setBounds(390, 588, 150, 35);
        l3.add(b6);

        b7.setBounds(390, 633, 150, 35);
        l3.add(b7);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);

        setSize(960, 1080);
        setLocation(500, 0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        try {
            String amount = ((JButton) ae.getSource()).getText().substring(3);
            conn con = new conn();
            ResultSet rs = con.s.executeQuery("select * from bank where pin='" + pin + "'");
            int balance = 0;
            while (rs.next()) {
                if (rs.getString("type").equals("DEPOSIT")) {
                    balance += Integer.parseInt(rs.getString("amount"));

                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }

            }
            if (ae.getSource() != b7 && balance < Integer.parseInt(amount)) {
                JOptionPane.showMessageDialog(null, "INSUFFICIENT BALANCE");
                return;

            }
            if (ae.getSource() == b7) {
                this.setVisible(false);
                new Transaction(pin).setVisible(true);
            } else {
                Date d = new Date();
                con.s.executeUpdate("insert into bank values('" + pin + "','" + d + "','WITHDRAW','" + amount + "')");
                JOptionPane.showMessageDialog(null, "Rs  " + amount + " DEBITED SUCESSFULLY");

                setVisible(false);
                new Transaction(pin).setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }

}
