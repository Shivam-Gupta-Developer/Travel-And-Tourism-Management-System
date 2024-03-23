package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Review extends JFrame implements ActionListener {

    JRadioButton r1, r2, r3, r4, r5;
    JTextArea area;
    JButton submit, back;
    int star = 0;

    Review() {
        setBounds(292, 90, 1000, 595);
        setLayout(null);

        JLabel l2 = new JLabel("Please Rate Us !");
        l2.setForeground(new Color(0, 0, 102));
        l2.setBounds(220, 20, 450, 65);
        l2.setFont(new Font("Tahoma", Font.BOLD, 28));
        add(l2);

        r1 = new JRadioButton("1 Star");
        r1.setFont(new Font("Tahoma", Font.BOLD, 24));
        r1.setBackground(Color.WHITE);
        r1.setBounds(40, 100, 100, 30);
        add(r1);

        r2 = new JRadioButton("2 Star");
        r2.setFont(new Font("Tahoma", Font.BOLD, 24));
        r2.setBackground(Color.WHITE);
        r2.setBounds(160, 100, 100, 30);
        add(r2);

        r3 = new JRadioButton("3 Star");
        r3.setFont(new Font("Tahoma", Font.BOLD, 24));
        r3.setBackground(Color.WHITE);
        r3.setBounds(280, 100, 100, 30);
        add(r3);

        r4 = new JRadioButton("4 Star");
        r4.setFont(new Font("Tahoma", Font.BOLD, 24));
        r4.setBackground(Color.WHITE);
        r4.setBounds(400, 100, 100, 30);
        add(r4);

        r5 = new JRadioButton("5 Star");
        r5.setFont(new Font("Tahoma", Font.BOLD, 24));
        r5.setBackground(Color.WHITE);
        r5.setBounds(520, 100, 100, 30);
        add(r5);

        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);
        bg.add(r4);
        bg.add(r5);

        JLabel l1 = new JLabel("Please Write your review here");
        l1.setForeground(new Color(0, 0, 102));
        l1.setBounds(40, 150, 480, 50);
        l1.setFont(new Font("Tahoma", Font.BOLD, 22));
        add(l1);

        area = new JTextArea();
        area.setBackground(Color.BLACK);
        area.setForeground(Color.WHITE);
        area.setBounds(40, 205, 580, 205);
        area.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(area);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/rate.png"));
        Image i3 = i1.getImage().getScaledInstance(350, 460, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l3 = new JLabel(i2);
        l3.setBounds(600, 40, 420, 480);
        add(l3);

        submit = new JButton("Submit");
        submit.setBounds(175, 460, 100, 45);
        submit.setBackground(Color.BLACK);
        submit.setFont(new Font("Tahoma", Font.BOLD, 18));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma", Font.BOLD, 18));
        back.setBounds(375, 460, 100, 45);
        back.addActionListener(this);
        add(back);

        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
        } else {
            if (ae.getSource() == submit) {
                if (r1.isSelected()) {
                    star = 1;
                } else if (r2.isSelected()) {
                    star = 2;
                } else if (r3.isSelected()) {
                    star = 3;
                } else if (r4.isSelected()) {
                    star = 4;
                } else if (r5.isSelected()) {
                    star = 5;
                }
                String review = area.getText();
                String query = "insert into review values('" + star + "','" + review + "')";
                try {
                    Conn c = new Conn();
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Review Submitted ! Thanks for your feedback", "Success",
                            JOptionPane.INFORMATION_MESSAGE);
//                ConfirmationEmail emailSender = new ConfirmationEmail();
                    setVisible(false);

                } catch (Exception e) {
                    System.out.print(e.getMessage());
                }

            }
        }
    }

    public static void main(String[] args) {
        new Review();
    }
}
