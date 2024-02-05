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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Mayur Kukreja
 */
public class Transaction extends JFrame implements ActionListener {

    JButton b1, b2, b3, b4, b5, b6, b7;
    JLabel l1, l2;
    String pin;

    Transaction(String pin) {
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l2 = new JLabel(i3);
        l2.setBounds(0, 0, 960, 1080);
        add(l2);

        l1 = new JLabel("PLEASE SELECT YOUR TRANSACTION");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 18));

        b1 = new JButton("DEPOSIT");
        b2 = new JButton("CASH WITHDWARL");
        b3 = new JButton("FAST CASH");
        b4 = new JButton("MINI STATEMENT");
        b5 = new JButton("PIN CHANGE");
        b6 = new JButton("BALANCE ENQUIRY");
        b7 = new JButton("EXIT");

        setSize(960, 1080);
        setLocation(500, 0);
        setLayout(null);
        setUndecorated(true);
        setVisible(true);

        l1.setBounds(190, 400, 700, 35);
        l2.add(l1);

        b1.setBounds(170, 499, 150, 35);
        l2.add(b1);

        b2.setBounds(390, 499, 150, 35);
        l2.add(b2);

        b3.setBounds(170, 543, 150, 35);
        l2.add(b3);

        b4.setBounds(390, 543, 150, 35);
        l2.add(b4);

        b5.setBounds(170, 588, 150, 35);
        l2.add(b5);

        b6.setBounds(390, 588, 150, 35);
        l2.add(b6);

        b7.setBounds(390, 633, 150, 35);
        l2.add(b7);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            setVisible(false);
            new Deposit(pin).setVisible(true);
        } else if (ae.getSource() == b2) {
            setVisible(false);
            new Withdrawl(pin).setVisible(true);
        } else if (ae.getSource() == b3) {
            setVisible(false);
            new Fastcash(pin).setVisible(true);
        } else if (ae.getSource() == b5) {
            setVisible(false);
            new Pin(pin).setVisible(true);
        } else if (ae.getSource() == b6) {

            setVisible(false);
            new Balance(pin).setVisible(true);
        } else if (ae.getSource() == b4) {
            new MiniStatement(pin).setVisible(true);

        } else if (ae.getSource() == b7) {
            System.exit(0);
        }

    }

    public static void main(String[] args) {

    }

}
