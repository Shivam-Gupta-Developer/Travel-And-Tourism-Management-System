package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class DeleteDetails extends JFrame implements ActionListener {

    JButton back, delete;
    String username;

    DeleteDetails(String username) {
        this.username = username;

        setBounds(292, 90, 1000, 595);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("DELETE ALL THE DETAILS");
        text.setBounds(50, 20, 950, 35);
        text.setForeground(new Color(0, 0, 128));
        text.setFont(new Font("Sans-Serif", Font.BOLD, 40));
        add(text);

        JLabel lblusername = new JLabel("Username :-");
        lblusername.setBounds(50, 100, 150, 25);
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblusername);

        JLabel labelusername = new JLabel();
        labelusername.setBounds(220, 100, 150, 25);
        labelusername.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(labelusername);

        JLabel lblid = new JLabel("Id :-");
        lblid.setBounds(50, 150, 150, 25);
        lblid.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblid);

        JLabel labelid = new JLabel();
        labelid.setBounds(220, 150, 150, 25);
        labelid.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(labelid);

        JLabel lblnumber = new JLabel("Number :-");
        lblnumber.setBounds(50, 200, 150, 25);
        lblnumber.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblnumber);

        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(220, 200, 150, 25);
        labelnumber.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(labelnumber);

        JLabel lblname = new JLabel("Name :-");
        lblname.setBounds(50, 250, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblname);

        JLabel labelname = new JLabel();
        labelname.setBounds(220, 250, 150, 25);
        labelname.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(labelname);

        JLabel lblgender = new JLabel("Gender :-");
        lblgender.setBounds(50, 300, 150, 25);
        lblgender.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblgender);

        JLabel labelgender = new JLabel();
        labelgender.setBounds(220, 300, 150, 25);
        labelgender.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(labelgender);
        
        JLabel text1 = new JLabel("* This will delete all the details regarding Customer Details, Package and Booked Hotel details.");
        text1.setBounds(50, 360, 950, 35);
        text1.setForeground(Color.RED);
        text1.setFont(new Font("Sans-Serif", Font.BOLD, 18));
        add(text1);

        JLabel lblcountry = new JLabel("Country :-");
        lblcountry.setBounds(500, 100, 150, 25);
        lblcountry.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblcountry);

        JLabel labelcountry = new JLabel();
        labelcountry.setBounds(690, 100, 150, 25);
        labelcountry.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(labelcountry);

        JLabel lbladdress = new JLabel("Address :-");
        lbladdress.setBounds(500, 150, 150, 25);
        lbladdress.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lbladdress);

        JLabel labeladdress = new JLabel();
        labeladdress.setBounds(690, 150, 150, 25);
        labeladdress.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(labeladdress);

        JLabel lblphone = new JLabel("Phone :-");
        lblphone.setBounds(500, 200, 150, 25);
        lblphone.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblphone);

        JLabel labelphone = new JLabel();
        labelphone.setBounds(690, 200, 150, 25);
        labelphone.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(labelphone);

        JLabel lblemail = new JLabel("Email :-");
        lblemail.setBounds(500, 250, 150, 25);
        lblemail.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblemail);

        JLabel labelemail = new JLabel();
        labelemail.setBounds(690, 250, 450, 25);
        labelemail.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(labelemail);

        delete = new JButton("Delete");
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.setFont(new Font("Tahoma", Font.BOLD, 25));
        delete.setBounds(220, 440, 180, 50);

        delete.addActionListener(this);
        add(delete);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma", Font.BOLD, 25));
        back.setBounds(480, 440, 180, 50);

        back.addActionListener(this);
        add(back);

        try {
            Conn conn = new Conn();
            String query = "select * from customer where username = '" + username + "'";
            ResultSet rs = conn.s.executeQuery(query);

            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelname.setText(rs.getString("name"));
                labelgender.setText(rs.getString("gender"));
                labelcountry.setText(rs.getString("country"));
                labeladdress.setText(rs.getString("address"));
                labelphone.setText(rs.getString("phone"));
                labelemail.setText(rs.getString("email"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
        } else {
            try {
                Conn c = new Conn();
                c.s.executeUpdate("delete from account where username = '" + username + "'");
                c.s.executeUpdate("delete from customer where username = '" + username + "'");
                c.s.executeUpdate("delete from bookpackage where username = '" + username + "'");
                c.s.executeUpdate("delete from bookhotel where username = '" + username + "'");

                JOptionPane.showMessageDialog(null, "Data Deleted Successfully");

                System.exit(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new DeleteDetails("Mohan");
    }
}
