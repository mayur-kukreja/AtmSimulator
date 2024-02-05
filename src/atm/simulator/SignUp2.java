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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Mayur Kukreja
 */
public class SignUp2 extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13;
    JButton b;
    JRadioButton r1, r2, r3, r4;
    JComboBox c1, c2, c3, c4, c5;
    JTextField t1, t2;
    String formno;

    SignUp2(String formnoe) {

        this.formno = formnoe;
        setTitle("NEW ACCOUNT APPLICATION FORM PAGE 2");

        l1 = new JLabel("ADDITIONAL DETAILS");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));

        l2 = new JLabel("RELIGION");
        l2.setFont(new Font("Raleway", Font.BOLD, 18));

        l3 = new JLabel("CATEGORY");
        l3.setFont(new Font("Raleway", Font.BOLD, 18));

        l4 = new JLabel("INCOME");
        l4.setFont(new Font("Raleway", Font.BOLD, 18));

        l5 = new JLabel("EDUCATIONAL");
        l5.setFont(new Font("Raleway", Font.BOLD, 18));

        l11 = new JLabel("QUALIFICATION");
        l11.setFont(new Font("Raleway", Font.BOLD, 18));

        l6 = new JLabel("OCCUPATION");
        l6.setFont(new Font("Raleway", Font.BOLD, 18));

        l7 = new JLabel("PAN NUMBER");
        l7.setFont(new Font("Raleway", Font.BOLD, 18));

        l8 = new JLabel("ADHAAR NUMBER");
        l8.setFont(new Font("Raleway", Font.BOLD, 18));

        l9 = new JLabel("SENIOR CITIZEN");
        l9.setFont(new Font("Raleway", Font.BOLD, 18));

        l10 = new JLabel("EXISTING ACCOUNT");
        l10.setFont(new Font("Raleway", Font.BOLD, 18));

        l12 = new JLabel("Form No:");
        l12.setFont(new Font("Raleway", Font.BOLD, 13));

        l13 = new JLabel(formno);
        l13.setFont(new Font("Raleway", Font.BOLD, 13));

        b = new JButton("Next");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);

        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 14));

        t2 = new JTextField();
        t2.setFont(new Font("Raleway", Font.BOLD, 14));

        r1 = new JRadioButton("YES");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(Color.WHITE);

        r2 = new JRadioButton("NO");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(Color.WHITE);

        r3 = new JRadioButton("Yes");
        r3.setFont(new Font("Raleway", Font.BOLD, 14));
        r3.setBackground(Color.WHITE);

        r4 = new JRadioButton("NO");
        r4.setFont(new Font("Raleway", Font.BOLD, 14));
        r4.setBackground(Color.WHITE);

        ButtonGroup SeniorCitizen = new ButtonGroup();
        SeniorCitizen.add(r1);
        SeniorCitizen.add(r2);

        ButtonGroup ExistingAccount = new ButtonGroup();
        ExistingAccount.add(r3);
        ExistingAccount.add(r4);

        String[] religion = {" ", "HINDU", "MUSLIM", "SIKH", "CHRISTIAN", "OTHERS"};
        c1 = new JComboBox(religion);
        c1.setFont(new Font("Raleway", Font.BOLD, 14));
        c1.setBackground(Color.WHITE);

        String[] category = {" ", "GENERAL", "OBC", "ST", "SC", "OTHERS"};

        c2 = new JComboBox(category);
        c2.setFont(new Font("Raleway", Font.BOLD, 14));
        c2.setBackground(Color.WHITE);

        String income[] = {" ", "<1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000", "Above 10,00,000"};
        c3 = new JComboBox(income);
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 14));

        String education[] = {"", "NON GRADUATE", "GRADUATE", "POST GRADUATE", "DOCTORATE", "OTHERS"};
        c4 = new JComboBox(education);
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 14));

        String occupation[] = {" ", "EMPLOYED", "UNEMPLOYED", "BUSINESSMAN", "RETIERD", "OTHERS"};
        c5 = new JComboBox(occupation);
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 14));

        setSize(850, 750);
        setLocation(500, 120);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        l12.setBounds(700, 10, 60, 30);
        add(l12);

        l13.setBounds(760, 10, 60, 30);
        add(l13);

        l1.setBounds(280, 30, 600, 40);
        add(l1);

        l2.setBounds(100, 120, 100, 30);
        add(l2);

        c1.setBounds(350, 120, 320, 30);
        add(c1);

        l3.setBounds(100, 180, 100, 30);
        add(l3);

        c2.setBounds(350, 170, 320, 30);
        add(c2);

        l4.setBounds(100, 220, 100, 30);
        add(l4);

        c3.setBounds(350, 220, 320, 30);
        add(c3);

        l5.setBounds(100, 270, 150, 30);
        add(l5);

        c4.setBounds(350, 270, 320, 30);
        add(c4);
        l11.setBounds(100, 290, 150, 30);
        add(l11);
        l6.setBounds(100, 340, 150, 30);
        add(l6);

        c5.setBounds(350, 340, 320, 30);
        add(c5);
        l7.setBounds(100, 390, 150, 30);
        add(l7);

        t1.setBounds(350, 390, 320, 30);
        add(t1);

        l8.setBounds(100, 440, 180, 30);
        add(l8);

        t2.setBounds(350, 440, 320, 30);
        add(t2);

        l9.setBounds(100, 490, 150, 30);
        add(l9);

        r1.setBounds(350, 490, 100, 30);
        add(r1);

        r2.setBounds(460, 490, 100, 30);
        add(r2);

        l10.setBounds(100, 540, 180, 30);
        add(l10);

        r3.setBounds(350, 540, 100, 30);
        add(r3);

        r4.setBounds(460, 540, 100, 30);
        add(r4);

        b.setBounds(570, 640, 100, 30);
        add(b);

        b.addActionListener(this);

    }

    public void actionPerformed(ActionEvent ae) {
        String religion = (String) c1.getSelectedItem();
        String category = (String) c2.getSelectedItem();
        String income = (String) c3.getSelectedItem();
        String education = (String) c4.getSelectedItem();
        String occupation = (String) c5.getSelectedItem();

        String pan = t1.getText();
        String aadhar = t2.getText();

        String scitizen = "";
        if (r1.isSelected()) {
            scitizen = "Yes";
        } else if (r2.isSelected()) {
            scitizen = "No";
        }

        String eaccount = "";
        if (r3.isSelected()) {
            eaccount = "Yes";
        } else if (r4.isSelected()) {
            eaccount = "No";
        }

        try {
            if (t2.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            } else {
                conn c1 = new conn();
                String q1 = "insert into signup2 values('" + formno + "','" + religion + "','" + category + "','" + income + "','" + education + "','" + occupation + "','" + pan + "','" + aadhar + "','" + scitizen + "','" + eaccount + "')";
                c1.s.executeUpdate(q1);

                new SignUp3(formno).setVisible(true);
                setVisible(false);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }

}
