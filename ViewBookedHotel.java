package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class ViewBookedHotel extends JFrame implements ActionListener {
    
    JButton back;
    
    ViewBookedHotel(String username) {
        setBounds(292,90,1000,595);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("VIEW BOOKED HOTEL DETAILS");
        text.setFont(new Font("Tahoma",Font.BOLD,40));
        text.setForeground(new Color(0,0,128));
        text.setBounds(60,25,700,35);
        add(text);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(60,100,150,25);
        lblusername.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lblusername);
        
        JLabel labelusername = new JLabel();
        labelusername.setBounds(220,100,150,25);
        labelusername.setFont(new Font("Tahoma",Font.BOLD,20));
        add(labelusername);
        
        JLabel lblpackage = new JLabel("Hotel Name");
        lblpackage.setBounds(60,140,150,25);
        lblpackage.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lblpackage);
        
        JLabel labelpackage = new JLabel();
        labelpackage.setBounds(220,140,350,25);
        labelpackage.setFont(new Font("Tahoma",Font.BOLD,20));
        add(labelpackage);
        
        JLabel lblpersons = new JLabel("Total Persons");
        lblpersons.setBounds(60,180,150,25);
        lblpersons.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lblpersons);
        
        JLabel labelpersons = new JLabel();
        labelpersons.setBounds(220,180,150,25);
        labelpersons.setFont(new Font("Tahoma",Font.BOLD,20));
        add(labelpersons);
        
        JLabel lbldays = new JLabel("Total Days");
        lbldays.setBounds(60,220,150,25);
        lbldays.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lbldays);
        
        JLabel labeldays = new JLabel();
        labeldays.setBounds(220,220,150,25);
        labeldays.setFont(new Font("Tahoma",Font.BOLD,20));
        add(labeldays);
        
        JLabel lblac = new JLabel("AC/Non-AC");
        lblac.setBounds(60,260,150,25);
        lblac.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lblac);
        
        JLabel labelac = new JLabel();
        labelac.setBounds(220,260,150,25);
        labelac.setFont(new Font("Tahoma",Font.BOLD,20));
        add(labelac);
        
        JLabel lblfood = new JLabel("Food Included");
        lblfood.setBounds(60,300,200,25);
        lblfood.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lblfood);
        
        JLabel labelfood = new JLabel();
        labelfood.setBounds(220,300,150,25);
        labelfood.setFont(new Font("Tahoma",Font.BOLD,20));
        add(labelfood);
        
        JLabel lblid = new JLabel("Id");
        lblid.setBounds(60,340,150,25);
        lblid.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lblid);
        
        JLabel labelid = new JLabel();
        labelid.setBounds(220,340,150,25);
        labelid.setFont(new Font("Tahoma",Font.BOLD,20));
        add(labelid);
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(60,380,150,25);
        lblnumber.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lblnumber);
        
        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(220,380,250,25);
        labelnumber.setFont(new Font("Tahoma",Font.BOLD,20));
        add(labelnumber);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(60,420,150,25);
        lblphone.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lblphone);
        
        JLabel labelphone = new JLabel();
        labelphone.setBounds(220,420,150,25);
        labelphone.setFont(new Font("Tahoma",Font.BOLD,20));
        add(labelphone);
        
        JLabel lblprice = new JLabel("Total Cost");
        lblprice.setBounds(60,460,150,25);
        lblprice.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lblprice);
        
        JLabel labelprice = new JLabel();
        labelprice.setBounds(220,460,150,25);
        labelprice.setFont(new Font("Tahoma",Font.BOLD,20));
        add(labelprice);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(140,500,120,35);
        back.setFont(new Font("Tahoma",Font.BOLD,18));
        back.addActionListener(this);
        add(back);
        
        //ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/team.png"));
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/view_booked_package.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,440,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450,90,550,440);
        add(image);
        
        try {
            Conn conn = new Conn();
            String query = "select * from bookhotel where username = '"+username+"'";
            ResultSet rs = conn.s.executeQuery(query);
            
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelpackage.setText(rs.getString("name"));
                labelprice.setText(rs.getString("price"));
                labelphone.setText(rs.getString("phone"));
                labelpersons.setText(rs.getString("persons"));
                labelfood.setText(rs.getString("food"));
                labelac.setText(rs.getString("ac"));
                labeldays.setText(rs.getString("days"));
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
        new ViewBookedHotel("Mohan");
    }
}
