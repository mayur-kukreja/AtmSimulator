/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.simulator;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *
 * @author Mayur Kukreja
 */
public class SignUp3 extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12;
    JRadioButton r1, r2, r3, r4;
    JButton b1, b2;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    String formno;

    SignUp3(String formno) {

        this.formno = formno;

        l1 = new JLabel("PAGE 3 ACCOUNTS DETAILS");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));

        l2 = new JLabel("ACCOUNT TYPE");
        l2.setFont(new Font("Raleway", Font.BOLD, 18));

        l3 = new JLabel("CARD NUMBER");
        l3.setFont(new Font("Raleway", Font.BOLD, 18));

        l4 = new JLabel("XXXX-XXXX-XXXX-XXXX");
        l4.setFont(new Font("Raleway", Font.BOLD, 18));

        l5 = new JLabel("YOUR 16 DIGIT CARD NUMBER");
        l5.setFont(new Font("Raleway", Font.BOLD, 12));

        l6 = new JLabel("IT WOULD APPEAR ON ATM CARD/CHEQUE BOOK/STATEMENTS");
        l6.setFont(new Font("Raleway", Font.BOLD, 12));

        l7 = new JLabel("PIN");
        l7.setFont(new Font("Raleway", Font.BOLD, 18));

        l8 = new JLabel("XXXX");
        l8.setFont(new Font("Raleway", Font.BOLD, 18));

        l9 = new JLabel("4 DIGIT PASSWORD");
        l9.setFont(new Font("Raleway", Font.BOLD, 12));

        l10 = new JLabel("SERVICE REQUIRED");
        l10.setFont(new Font("Raleway", Font.BOLD, 18));

        l11 = new JLabel("FORM NO");
        l11.setFont(new Font("Raleway", Font.BOLD, 14));

        l12 = new JLabel(formno);
        l12.setFont(new Font("Raleway", Font.BOLD, 14));

        b1 = new JButton("SUBMIT");
        b1.setFont(new Font("Raleway", Font.BOLD, 14));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b2 = new JButton("CANCEL");
        b2.setFont(new Font("Raleway", Font.BOLD, 14));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        c1 = new JCheckBox("ATM CARD");
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBackground(Color.WHITE);

        c2 = new JCheckBox("INTERNET BANKING");
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBackground(Color.WHITE);

        c3 = new JCheckBox("MOBILE BANKING");
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBackground(Color.WHITE);

        c4 = new JCheckBox("EMAIL ALERTS");
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBackground(Color.WHITE);

        c5 = new JCheckBox("CHEQUE BOOK");
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBackground(Color.WHITE);

        c6 = new JCheckBox("E STATEMENTS");
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBackground(Color.WHITE);

        c7 = new JCheckBox("I HERBY DECLARES THAT THE ABOVE ENTERED DETAILS CORRECT TO THE BEST OF MY KNOWLEDGE", true);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBackground(Color.WHITE);

        r1 = new JRadioButton("SAVING ACCOUNT");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(Color.WHITE);

        r2 = new JRadioButton("FIXED DEPOSIT ACCOUNT");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.WHITE);

        r3 = new JRadioButton("CURRENT ACCOUNT");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.WHITE);

        r4 = new JRadioButton("RECURRING DEPOSIT ACCOUNT");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.WHITE);

        ButtonGroup groupgender = new ButtonGroup();
        groupgender.add(r1);
        groupgender.add(r2);
        groupgender.add(r3);
        groupgender.add(r4);

        setSize(850, 850);
        setLocation(500, 120);
        setVisible(true);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        l11.setBounds(700, 10, 70, 30);
        add(l11);

        l12.setBounds(770, 10, 40, 30);
        add(l12);

        l1.setBounds(280, 40, 400, 40);
        add(l1);

        l2.setBounds(100, 140, 200, 30);
        add(l2);

        r1.setBounds(100, 180, 150, 30);
        add(r1);

        r2.setBounds(350, 180, 300, 30);
        add(r2);

        r3.setBounds(100, 220, 250, 30);
        add(r3);

        r4.setBounds(350, 220, 250, 30);
        add(r4);

        l3.setBounds(100, 300, 200, 30);
        add(l3);

        l4.setBounds(330, 300, 250, 30);
        add(l4);

        l5.setBounds(100, 330, 200, 20);
        add(l5);

        l6.setBounds(330, 330, 500, 20);
        add(l6);

        l7.setBounds(100, 370, 200, 30);
        add(l7);

        l8.setBounds(330, 370, 200, 30);
        add(l8);

        l9.setBounds(100, 400, 200, 20);
        add(l9);

        l10.setBounds(100, 450, 200, 30);
        add(l10);

        c1.setBounds(100, 500, 200, 30);
        add(c1);

        c2.setBounds(350, 500, 200, 30);
        add(c2);

        c3.setBounds(100, 550, 200, 30);
        add(c3);

        c4.setBounds(350, 550, 200, 30);
        add(c4);

        c5.setBounds(100, 600, 200, 30);
        add(c5);

        c6.setBounds(350, 600, 200, 30);
        add(c6);

        c7.setBounds(100, 680, 600, 20);
        add(c7);

        b1.setBounds(250, 720, 100, 30);
        add(b1);

        b2.setBounds(420, 720, 100, 30);
        add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        String atype = null;
        if (r1.isSelected()) {
            atype = "Saving Account";
        } else if (r2.isSelected()) {
            atype = "Fixed Deposit Account";
        } else if (r3.isSelected()) {
            atype = "Current Account";
        } else if (r4.isSelected()) {
            atype = "Recurring Deposit Account";
        }

        Random ran = new Random();
        long first7 = (ran.nextLong() % 90000000L) + 5040936000000000L;
        String cardno = "" + Math.abs(first7);

        long first3 = (ran.nextLong() % 9000L) + 1000L;
        String pin = "" + Math.abs(first3);

        String facility = "";
        if (c1.isSelected()) {
            facility = facility + " ATM Card";
        }
        if (c2.isSelected()) {
            facility = facility + " Internet Banking";
        }
        if (c3.isSelected()) {
            facility = facility + " Mobile Banking";
        }
        if (c4.isSelected()) {
            facility = facility + " EMAIL Alerts";
        }
        if (c5.isSelected()) {
            facility = facility + " Cheque Book";
        }
        if (c6.isSelected()) {
            facility = facility + " E-Statement";
        }

        try {
            if (ae.getSource() == b1) {

                if (atype.equals("")) {
                    JOptionPane.showMessageDialog(null, "Fill all the required fields");
                } else {
                    conn c1 = new conn();
                    String q1 = "insert into signup3 values('" + formno + "','" + atype + "','" + cardno + "','" + pin + "','" + facility + "')";
                    String q2 = "insert into login values('" + formno + "','" + cardno + "','" + pin + "')";
                    c1.s.executeUpdate(q1);
                    c1.s.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardno + "\n Pin:" + pin);

                    new Deposit(pin).setVisible(true);
                    setVisible(false);
                }

            } else if (ae.getSource() == b2) {
                System.exit(0);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {

    }

}
