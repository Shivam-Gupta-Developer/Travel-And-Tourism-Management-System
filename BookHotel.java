package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookHotel extends JFrame implements ActionListener {
    
    Choice chotel,cac,cfood;
    JTextField tfpersons,tfdays;
    JLabel labelusername,labelid,labelnumber,labelphone,labelprice;
    JButton checkprice,bookpackage,back;
    String username;
    
    BookHotel(String username){
        this.username=username;
        
        setBounds(292,90,1000,595);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("BOOK HOTEL");
        text.setBounds(60,20,400,40);
        text.setFont(new Font("Tahoma",Font.BOLD,40));
        text.setForeground(new Color(0,0,102));
        add(text);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("Tahoma",Font.BOLD,16));
        lblusername.setBounds(60,100,100,20);
        add(lblusername);
        
        labelusername = new JLabel();
        labelusername.setFont(new Font("Tahoma",Font.PLAIN,16));
        labelusername.setBounds(250,100,200,20);
        add(labelusername);
        
        JLabel lblpackage = new JLabel("Select Hotel");
        lblpackage.setFont(new Font("Tahoma",Font.BOLD,16));
        lblpackage.setBounds(60,140,150,20);
        add(lblpackage);
        
        chotel = new Choice();
        chotel.setBounds(250,140,200,20);
        chotel.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(chotel);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel");
            
            while(rs.next()){
                chotel.add(rs.getString("name"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel lblpersons = new JLabel("Total Persons");
        lblpersons.setFont(new Font("Tahoma",Font.BOLD,16));
        lblpersons.setBounds(60,180,150,25);
        add(lblpersons);
        
        tfpersons = new JTextField("1");
        tfpersons.setBounds(250,180,200,25);
        tfpersons.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(tfpersons);
        
        JLabel lbldays = new JLabel("No. of Days");
        lbldays.setFont(new Font("Tahoma",Font.BOLD,16));
        lbldays.setBounds(60,220,150,25);
        add(lbldays);
        
        tfdays = new JTextField("1");
        tfdays.setBounds(250,220,200,25);
        tfdays.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(tfdays);
        
        JLabel lblac = new JLabel("AC/Non-AC");
        lblac.setFont(new Font("Tahoma",Font.BOLD,16));
        lblac.setBounds(60,260,150,25);
        add(lblac);
        
        cac = new Choice();
        cac.add("AC");
        cac.add("Non-AC");
        cac.setBounds(250,260,200,20);
        cac.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(cac);
        
        JLabel lblfood = new JLabel("Food Included");
        lblfood.setFont(new Font("Tahoma",Font.BOLD,16));
        lblfood.setBounds(60,300,150,25);
        add(lblfood);
        
        cfood = new Choice();
        cfood.add("Yes");
        cfood.add("No");
        cfood.setBounds(250,300,200,20);
        cfood.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(cfood);
        
        JLabel lblid = new JLabel("Id");
        lblid.setFont(new Font("Tahoma",Font.BOLD,16));
        lblid.setBounds(60,340,150,20);
        add(lblid);
        
        labelid = new JLabel();
        labelid.setBounds(250,340,200,25);
        labelid.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelid);
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setFont(new Font("Tahoma",Font.BOLD,16));
        lblnumber.setBounds(60,380,150,25);
        add(lblnumber);
        
        labelnumber = new JLabel();
        labelnumber.setBounds(250,380,150,25);
        labelnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelnumber);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setFont(new Font("Tahoma",Font.BOLD,16));
        lblphone.setBounds(60,420,150,20);
        add(lblphone);
        
        labelphone = new JLabel();
        labelphone.setBounds(250,420,200,25);
        labelphone.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelphone);
        
        JLabel lbltotal = new JLabel("Total Price");
        lbltotal.setFont(new Font("Tahoma",Font.BOLD,16));
        lbltotal.setBounds(60,460,150,25);
        add(lbltotal);
        
        labelprice = new JLabel();
        labelprice.setBounds(250,460,150,25);
        labelprice.setForeground(Color.RED);
        labelprice.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelprice);
        
        try {
            Conn conn = new Conn();
            String query = "select * from customer where username = '"+username+"'";
            ResultSet rs = conn.s.executeQuery(query);
            
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        checkprice = new JButton("Check Price");
        checkprice.setBackground(Color.RED);
        checkprice.setForeground(Color.WHITE);
        checkprice.setBounds(60,510,130,30);
        checkprice.setFont(new Font("Tahoma",Font.BOLD,14));
        checkprice.addActionListener(this);
        add(checkprice);
        
        bookpackage = new JButton("Book Hotel");
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBounds(200,510,130,30);
        bookpackage.setFont(new Font("Tahoma",Font.BOLD,14));
        bookpackage.addActionListener(this);
        add(bookpackage);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(340,510,120,30);
        back.setFont(new Font("Tahoma",Font.BOLD,14));
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/5_stars_hotel.png"));
        Image i2 = i1.getImage().getScaledInstance(470, 495, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l12 = new JLabel(i3);
        l12.setBounds(470,10,550,495);
        add(l12);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==checkprice){
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from hotel where name = '"+chotel.getSelectedItem()+"'");

                while(rs.next()){
                    int cost = Integer.parseInt(rs.getString("costperperson"));
                    int food = Integer.parseInt(rs.getString("foodincluded"));
                    int ac = Integer.parseInt(rs.getString("acroom"));
                    
                    int persons = Integer.parseInt(tfpersons.getText());
                    int days = Integer.parseInt(tfdays.getText());
                    
                    String acselected = cac.getSelectedItem();
                    String foodselected = cfood.getSelectedItem();
                    
                    if(persons * days > 0) {
                        int total = 0;
                        total += acselected.equals("AC") ? ac : 0;
                        total += foodselected.equals("Yes") ? food : 0;
                        total += cost;
                        total = total * persons * days;
                        labelprice.setText("Rs. "+total);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Please enter a valid number");
                    }
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==bookpackage){
            try{
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookhotel values('"+labelusername.getText()+"', '"+chotel.getSelectedItem()+"', '"+tfpersons.getText()+"', '"+tfdays.getText()+"', '"+cac.getSelectedItem()+"', '"+cfood.getSelectedItem()+"','"+labelid.getText()+"', '"+labelnumber.getText()+"', '"+labelphone.getText()+"', '"+labelprice.getText()+"')");
                
                JOptionPane.showMessageDialog(null,"Hotel Booked Successfully");
                
                setVisible(false);
                
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new BookHotel("Mohan");
    }
}
