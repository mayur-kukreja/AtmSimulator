/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.simulator;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Mayur Kukreja
 */
public class MiniStatement extends JFrame implements ActionListener {

    JButton b1, b2;
    JLabel l1, l2, l3, l4;

    MiniStatement(String pin) {
        super("MINI STATEMENT");
        getContentPane().setBackground(Color.WHITE);
        setSize(400, 600);
        setLocation(20, 20);

        l1 = new JLabel();
        add(l1);

        l2 = new JLabel("INDIAN BANK");
        l2.setBounds(150, 20, 100, 20);
        add(l2);

        l3 = new JLabel();
        l3.setBounds(20, 80, 300, 20);
        add(l3);

        l4 = new JLabel();
        l4.setBounds(20, 400, 300, 20);
        add(l4);

        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin='" + pin + "'");
            while (rs.next()) {
                l3.setText("CARD NUMBER: " + rs.getString("cardno").substring(0, 4) + "XXXXXXXX" + rs.getString("cardno").substring(12));

            }

        } catch (Exception e) {
        }

        try {
            int balance = 0;
            conn c1 = new conn();
            ResultSet rs = c1.s.executeQuery("select * from bank where pin='" + pin + "'");
            while (rs.next()) {
                l1.setText(l1.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if (rs.getString("type").equals("DEPOSIT")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }

            }
            l4.setText("YOUR TOTAL BALANCE IS RS" + balance);

        } catch (Exception e) {

        }
        setLayout(null);
        b1 = new JButton("EXIT");
        add(b1);
        l1.setBounds(20, 140, 400, 200);
        b1.setBounds(20, 500, 100, 25);

        b1.addActionListener(this);

    }

    public void actionPerformed(ActionEvent Ae) {
        this.setVisible(false);
    }

    public static void main(String[] args) {

    }
}
