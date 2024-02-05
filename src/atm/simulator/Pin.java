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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

/**
 *
 * @author Mayur Kukreja
 */
public class Pin extends JFrame implements ActionListener {

    JPasswordField t1, t2;
    JButton b1, b2;
    JLabel l1, l2, l3;
    String pin;

    Pin(String pin) {
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l4 = new JLabel(i3);
        l4.setBounds(0, 0, 960, 1000);
        add(l4);

        l1 = new JLabel("CHANGE YOUR PIN");
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setForeground(Color.WHITE);

        l2 = new JLabel("NEW PIN");
        l2.setFont(new Font("System", Font.BOLD, 16));
        l2.setForeground(Color.WHITE);

        l3 = new JLabel("RE ENTER NEW PIN");
        l3.setFont(new Font("System", Font.BOLD, 16));
        l3.setForeground(Color.WHITE);

        t1 = new JPasswordField();
        t1.setFont(new Font("System", Font.BOLD, 25));

        t2 = new JPasswordField();
        t2.setFont(new Font("System", Font.BOLD, 25));

        b1 = new JButton("CHANGE");
        b2 = new JButton("BACK");

        b1.addActionListener(this);
        b2.addActionListener(this);

        setLayout(null);

        setSize(960, 1000);
        setLocation(500, 0);
        setUndecorated(true);
        setVisible(true);

        l1.setBounds(280, 330, 800, 35);
        l4.add(l1);

        l2.setBounds(180, 390, 150, 35);
        l4.add(l2);

        l3.setBounds(180, 440, 200, 35);
        l4.add(l3);

        t1.setBounds(350, 390, 180, 25);
        l4.add(t1);

        t2.setBounds(350, 440, 180, 25);
        l4.add(t2);

        b1.setBounds(390, 500, 150, 35);
        l4.add(b1);

        b2.setBounds(390, 550, 150, 35);
        l4.add(b2);

    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String npin = t1.getText();
            String rpin = t2.getText();

            if (!npin.equals(rpin)) {
                JOptionPane.showMessageDialog(null, "ENTERED PIN DOES NOT MATCH");
                return;
            }
            if (ae.getSource() == b1) {
                if (t1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "ENTER NEW PIN");

                }
                if (t2.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "RE ENTER NEW PIN");

                }

                conn con = new conn();
                String q1 = "Update bank set pin='" + rpin + "' where pin='" + pin + "'";
                String q2 = "update login set pin='" + rpin + "'where pin='" + pin + "' ";
                String q3 = "update signup3 set pin='" + rpin + "' where pin ='" + pin + "'";

                con.s.executeUpdate(q1);
                con.s.executeUpdate(q2);
                con.s.executeUpdate(q3);

                JOptionPane.showMessageDialog(null, "PIN UPDATED SUCCESFULLY");
                setVisible(false);
                new Transaction(rpin).setVisible(true);

            } else if (ae.getSource() == b2) {
                new Transaction(pin).setVisible(true);
                setVisible(false);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

    }

}
