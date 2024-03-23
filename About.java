package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame implements ActionListener {
    About(){
        setBounds(292,90,1000,595);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel l1 = new JLabel("Travel and Tourism Management System");
        l1.setBounds(220,10,900,40);
        l1.setForeground(Color.RED);
        l1.setFont(new Font("Tahoma",Font.BOLD,30));
        add(l1);
        
        String s = "\n                                                                                     About this Project :-          \n  "
                + "\nThe objective of the Travel and Tourism Management System "
                + "project is to develop a system that automates the processes "
                + "and activities of a travel and the purpose is to design a "
                + "system using which one can perform all operations related to "
                + "travelling.\n\n"
                + "This application will help in accessing the information related "
                + "to the travel to the particular destination with great ease. "
                + "The users can track the information related to their tours with "
                + "great ease through this application. The travel agency information "
                + "can also be obtained through this application.\n\n"
                + "Advantages of Project :-"
                + "\nGives accurate information"
                + "\nSimplifies the manual work"
                + "\nIt minimizes the documentation related work"
                + "\nProvides up-to-date information"
                + "\nFriendly environment by providing warning messages."
                + "\nTravellers details can be provided"
                + "\nBooking confirmation notification"
                ;
        
        TextArea area = new TextArea(s,20,80,Scrollbar.VERTICAL);
        area.setEditable(false);
        area.setBounds(20,60,950,400);
        area.setFont(new Font("Tahoma",Font.BOLD,16));
        add(area);
        
        JButton back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(420,500,100,30);
        back.setFont(new Font("Tahoma",Font.BOLD,18));
        back.addActionListener(this);
        add(back);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
    
    public static void main(String[] args) {
        new About();
    }
}
