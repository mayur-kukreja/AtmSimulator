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
public class Deposit extends JFrame implements ActionListener {

    JTextField t1, t2;
    JButton b1, b2;
    JLabel l1, l2, l3;
    String pin;

    Deposit(String pin) {
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l3 = new JLabel(i3);
        l3.setBounds(0, 0, 960, 1080);
        add(l3);

        l1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));

        b1 = new JButton("DEPOSIT");
        b2 = new JButton("BACK");

        l1.setBounds(190, 350, 400, 35);
        l3.add(l1);

        t1.setBounds(190, 420, 320, 25);
        l3.add(t1);

        b1.setBounds(390, 588, 150, 35);
        l3.add(b1);

        b2.setBounds(390, 633, 150, 35);
        l3.add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        setSize(960, 1080);
        setLocation(500, 0);
        setLayout(null);

        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String amount = t1.getText();
            Date date = new Date();
            if (ae.getSource() == b1) {
                if (amount.equals("")) {
                    JOptionPane.showMessageDialog(null, "PLEASE ENTER THE AMOUNT YOU WANT TO DEPOSIT");

                } else {
                    conn con = new conn();
                    con.s.executeUpdate("insert into bank values('" + pin + "','" + date + "','DEPOSIT','" + amount + "')");
                    JOptionPane.showMessageDialog(null, "Rs " + amount + " DEPOSITED SUCESSFULLY");
                    setVisible(false);
                    new Transaction(pin).setVisible(true);
                }

            } else if (ae.getSource() == b2) {
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
