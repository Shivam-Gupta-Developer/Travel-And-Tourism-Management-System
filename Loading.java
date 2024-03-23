package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable {
    
    Thread t;
    JProgressBar bar;
    String username;
    
    public void run(){
        try{
            for(int i=1;i<=101;i++){
                int max = bar.getMaximum(); // 100
                int value = bar.getValue();
                
                if(value<max){ // 101<100
                    bar.setValue(bar.getValue()+1);
                }else{
                    setVisible(false);
                    // new class object
                    new Dashboard(username);
                }
                Thread.sleep(50);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    Loading(String username){
        this.username = username;
        t = new Thread(this);
        
        setBounds(100,75,1100,550);
        getContentPane().setBackground(Color.WHITE); 
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100,550,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1100,550);
        add(image);
        
        JLabel text = new JLabel("TRAVEL AND TOURISM APPLICATION");
        text.setBounds(90,20,950,60);
        text.setForeground(new Color(0,0,128));
        text.setFont(new Font("Sans-Serif",Font.BOLD,50));
        image.add(text);
        
        JLabel loading = new JLabel("Please Wait.....");
        loading.setBounds(460,185,400,40);
        loading.setForeground(new Color(77,26,0));
        loading.setFont(new Font("Tahoma",Font.BOLD,20));
        image.add(loading);
        
        bar = new JProgressBar();
        bar.setBounds(380,230,300,40);
        bar.setStringPainted(true);
        image.add(bar);
        
        JLabel lblusername = new JLabel("Welcome " +username);
        lblusername.setBounds(720,360,400,50);
        lblusername.setForeground(new Color(102, 0,51));
        lblusername.setFont(new Font("Tahoma",Font.BOLD,35));
        image.add(lblusername);
        
        t.start();
        
        setVisible(true);
    }
    public static void main(String[] args) {
        new Loading("");
    }
}
