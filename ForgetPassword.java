package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ForgetPassword extends JFrame implements ActionListener{
    JTextField tfusername,tfname,tfquestion,tfanswer,tfpassword;
    JButton search,retrieve,back;
    ForgetPassword(){
        setBounds(100,80,1100,500);
        getContentPane().setBackground(Color.WHITE); 
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgot-password.png"));
        Image i2 = i1.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(620,20,400,400);
        add(image);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(0,0,102));
        p1.setBounds(0,0,550,500);
        p1.setLayout(null);
        add(p1);
        
        JLabel lblsignup = new JLabel("FORGET PASSWORD");
        lblsignup.setBounds(120,40,400,25);
        lblsignup.setForeground(Color.WHITE);
        lblsignup.setFont(new Font("Tahoma",Font.BOLD,30));
        p1.add(lblsignup);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40,100,100,25);
        lblusername.setForeground(Color.WHITE);
        lblusername.setFont(new Font("Tahoma",Font.BOLD,15));
        p1.add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(220,100,150,25);
        tfusername.setFont(new Font("Tahoma",Font.PLAIN,15));
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);
        
        search = new JButton("Search");
        search.setBackground(Color.GRAY);
        search.setForeground(Color.WHITE);
        search.setBounds(380,100,100,25);
        search.setForeground(Color.WHITE);
        search.addActionListener(this);
        p1.add(search);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(40,150,100,25);
        lblname.setFont(new Font("Tahoma",Font.BOLD,15));
        lblname.setForeground(Color.WHITE);
        p1.add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(220,150,150,25);
        tfname.setFont(new Font("Tahoma",Font.PLAIN,15));
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);
        
        JLabel lblquestion = new JLabel("Your Security Question");
        lblquestion.setBounds(40,200,190,25);
        lblquestion.setFont(new Font("Tahoma",Font.BOLD,14));
        lblquestion.setForeground(Color.WHITE);
        p1.add(lblquestion);
        
        tfquestion = new JTextField();
        tfquestion.setBounds(220,200,150,25);
        tfquestion.setFont(new Font("Tahoma",Font.PLAIN,15));
        tfquestion.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfquestion);
        
        JLabel lblanswer = new JLabel("Answer");
        lblanswer.setBounds(40,250,150,25);
        lblanswer.setFont(new Font("Tahoma",Font.BOLD,15));
        lblanswer.setForeground(Color.WHITE);
        p1.add(lblanswer);
        
        tfanswer = new JTextField();
        tfanswer.setBounds(220,250,150,25);
        tfanswer.setFont(new Font("Tahoma",Font.PLAIN,15));
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);
        
        retrieve = new JButton("Retrieve");
        retrieve.setBackground(Color.GRAY);
        retrieve.setForeground(Color.WHITE);
        retrieve.setBounds(380,250,100,25);
        retrieve.addActionListener(this);
        p1.add(retrieve);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40,300,150,25);
        lblpassword.setFont(new Font("Tahoma",Font.BOLD,15));
        lblpassword.setForeground(Color.WHITE);
        p1.add(lblpassword);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(220,300,150,25);
        tfpassword.setFont(new Font("Tahoma",Font.PLAIN,15));
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);
        
        back = new JButton("Back");
        back.setBackground(Color.GRAY);
        back.setForeground(Color.WHITE);
        back.setBounds(200,380,100,25);
        back.addActionListener(this);
        p1.add(back);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            try{
                String query = "select * from account where username = '"+tfusername.getText()+"'";
                Conn c = new Conn();
                
                ResultSet rs = c.s.executeQuery(query);
                
                while(rs.next()){
                    tfname.setText(rs.getString("name"));
                    tfquestion.setText(rs.getString("security"));
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==retrieve){
            try{
                String query = "select * from account where answer = '"+tfanswer.getText()+"' AND username = '"+tfusername.getText()+"'";
                Conn c = new Conn();
                
                ResultSet rs = c.s.executeQuery(query);
                
                while(rs.next()){
                    tfpassword.setText(rs.getString("password"));
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new Login();
        }
    }
    
    public static void main(String[] args) {
        new ForgetPassword();
    }
}
