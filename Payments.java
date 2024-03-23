package travel.management.system;

import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Payments extends JFrame {
    String username;
    Payments(String user) {
        this.username = user;

        setBounds(292,90,1000,595);
        setLayout(null);
        
        getContentPane().setBackground(new Color(255,255,255));

        JLabel label = new JLabel("Stripe Payment");
        label.setFont(new Font("Raleway", Font.BOLD, 45));
        label.setForeground(Color.BLACK);
        label.setBounds(380, 20, 350, 54);
        add(label);

        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/stripe.png"));
        Image i8 = i7.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel l4 = new JLabel(i9);
        l4.setBounds(235, 80, 600, 300);
        add(l4);

        JLabel labelQR = new JLabel("Scan QR:- ");
        labelQR.setFont(new Font("Raleway", Font.BOLD, 25));
        labelQR.setForeground(new Color(0,0,0));
        labelQR.setBounds(270, 400, 350, 54);
        add(labelQR);
        
        ImageIcon qr = new ImageIcon(ClassLoader.getSystemResource("icons/QR.jpg"));
        Image QR = qr.getImage().getScaledInstance(400, 95, Image.SCALE_DEFAULT);
        ImageIcon i99 = new ImageIcon(QR);
        JLabel l5 = new JLabel(i99);
        l5.setBounds(400, 390, 400, 95);
        add(l5);
        
        JLabel labelor = new JLabel("      Or");
        labelor.setFont(new Font("Raleway", Font.BOLD, 25));
        labelor.setForeground(new Color(0,0,0));
        labelor.setBounds(270, 440, 350, 54);
        add(labelor);
        
        JLabel labelclk = new JLabel("Click on this link:-");
        labelclk.setFont(new Font("Raleway", Font.BOLD, 16));
        labelclk.setForeground(new Color(0,0,0));
        labelclk.setBounds(260, 475, 350, 54);
        add(labelclk);
        
//        JButton pay = new JButton("Pay");
//        pay.setBackground(Color.BLACK);
//        pay.setForeground(Color.WHITE);
//        pay.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                new StripePY(username).setVisible(true);
//            }
//        });
//        pay.setBounds(300, 460, 80, 40);
//        add(pay);

        JButton redirectBtnGP = new JButton("Gold Package");
        redirectBtnGP.setFont(new Font("Raleway", Font.BOLD, 16));
        redirectBtnGP.setForeground(new Color(0,0,102));
        redirectBtnGP.setBackground(Color.WHITE);
        redirectBtnGP.setBorder(new LineBorder(Color.WHITE));
        redirectBtnGP.setBounds(398, 484, 120, 40);
        redirectBtnGP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Specify the URL you want to redirect to
                    URI uri = new URI("https://buy.stripe.com/test_7sI3dicx074WfqUdQS");
                    // Open the URI in the default web browser
                    Desktop.getDesktop().browse(uri);
                } catch (IOException | URISyntaxException ex) {
                    ex.printStackTrace();
                }
            }
        });
        add(redirectBtnGP);
        
        JButton redirectBtnSP = new JButton("Silver Package");
        redirectBtnSP.setFont(new Font("Raleway", Font.BOLD, 16));
        redirectBtnSP.setForeground(new Color(0,0,102));
        redirectBtnSP.setBackground(Color.WHITE);
        //password.setForeground(Color.WHITE);
        redirectBtnSP.setBorder(new LineBorder(Color.WHITE));
        redirectBtnSP.setBounds(540, 484, 120, 40);
        redirectBtnSP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Specify the URL you want to redirect to
                    URI uri = new URI("https://buy.stripe.com/test_00g9BG0Oi3SK1A49AB");
                    // Open the URI in the default web browser
                    Desktop.getDesktop().browse(uri);
                } catch (IOException | URISyntaxException ex) {
                    ex.printStackTrace();
                }
            }
        });
        add(redirectBtnSP);
        
        JButton redirectBtnBP = new JButton("Bronze Package");
        redirectBtnBP.setFont(new Font("Raleway", Font.BOLD, 16));
        redirectBtnBP.setForeground(new Color(0,0,102));
        redirectBtnBP.setBackground(Color.WHITE);
        //password.setForeground(Color.WHITE);
        redirectBtnBP.setBorder(new LineBorder(Color.WHITE));
        redirectBtnBP.setBounds(670, 484, 140, 40);
        redirectBtnBP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Specify the URL you want to redirect to
                    URI uri = new URI("https://buy.stripe.com/test_fZebJOaoS60S3Ic8wz");
                    // Open the URI in the default web browser
                    Desktop.getDesktop().browse(uri);
                } catch (IOException | URISyntaxException ex) {
                    ex.printStackTrace();
                }
            }
        });
        add(redirectBtnBP);

        JButton back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma", Font.BOLD, 24));
        back.setBounds(850, 484, 120, 50);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        add(back);

        setVisible(true);

    }

    public static void main(String[] args) {
        new Payments("").setVisible(true);
    }

}