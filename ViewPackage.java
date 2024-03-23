package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class ViewPackage extends JFrame implements ActionListener {
    
    JButton back;
    
    ViewPackage(String username) {
        
        setBounds(292,90,1000,595);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("VIEW PACKAGE DETAILS");
        text.setFont(new Font("Tahoma",Font.BOLD,28));
        text.setBounds(50,20,400,40);
        add(text);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(50,100,150,25);
        lblusername.setFont(new Font("Tahoma",Font.BOLD,18));
        add(lblusername);
        
        JLabel labelusername = new JLabel();
        labelusername.setBounds(220,100,150,25);
        labelusername.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelusername);
        
        JLabel lblpackage = new JLabel("Package");
        lblpackage.setBounds(50,140,150,25);
        lblpackage.setFont(new Font("Tahoma",Font.BOLD,18));
        add(lblpackage);
        
        JLabel labelpackage = new JLabel();
        labelpackage.setBounds(220,140,150,25);
        labelpackage.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelpackage);
        
        JLabel lblpersons = new JLabel("Total Persons");
        lblpersons.setBounds(50,180,150,25);
        lblpersons.setFont(new Font("Tahoma",Font.BOLD,18));
        add(lblpersons);
        
        JLabel labelpersons = new JLabel();
        labelpersons.setBounds(220,180,150,25);
        labelpersons.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelpersons);
        
        JLabel lblid = new JLabel("Id");
        lblid.setBounds(50,220,150,25);
        lblid.setFont(new Font("Tahoma",Font.BOLD,18));
        add(lblid);
        
        JLabel labelid = new JLabel();
        labelid.setBounds(220,220,150,25);
        labelid.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelid);
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(50,260,150,25);
        lblnumber.setFont(new Font("Tahoma",Font.BOLD,18));
        add(lblnumber);
        
        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(220,260,150,25);
        labelnumber.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelnumber);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(50,300,150,25);
        lblphone.setFont(new Font("Tahoma",Font.BOLD,18));
        add(lblphone);
        
        JLabel labelphone = new JLabel();
        labelphone.setBounds(220,300,150,25);
        labelphone.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelphone);
        
        JLabel lblprice = new JLabel("Price");
        lblprice.setBounds(50,340,150,25);
        lblprice.setFont(new Font("Tahoma",Font.BOLD,18));
        add(lblprice);
        
        JLabel labelprice = new JLabel();
        labelprice.setBounds(220,340,150,25);
        labelprice.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelprice);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(130,420,150,40);
        back.setFont(new Font("Tahoma",Font.BOLD,20));
        back.addActionListener(this);
        add(back);
        
        //ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/team.png"));
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/view_package.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,460,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450,60,500,460);
        add(image);
        
        try {
            Conn conn = new Conn();
            String query = "select * from bookpackage where username = '"+username+"'";
            ResultSet rs = conn.s.executeQuery(query);
            
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelpackage.setText(rs.getString("package"));
                labelprice.setText(rs.getString("price"));
                labelphone.setText(rs.getString("phone"));
                labelpersons.setText(rs.getString("persons"));

            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
    
    public static void main(String[] args) {
        new ViewPackage("Mohan");
    }
}
