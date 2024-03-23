package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class ChatBot extends JFrame implements ActionListener {

    private JTextArea chatArea = new JTextArea();
    private JTextField chatBox = new JTextField();
    JButton sendButton;

    ChatBot(String username) {

        setBounds(292, 90, 1000, 595);

        chatArea.append("*********************** Hello " + username + "***************************\n");

        getContentPane().setBackground(new Color(255, 255, 255));
//        setResizable(false);
        setLayout(null);
        setTitle("Chat Bot");

        add(chatBox);

        // textArea
        chatArea.setBounds(40, 40, 610, 420);
        chatArea.setBackground(Color.BLACK);
        chatArea.setForeground(Color.WHITE);
        chatArea.setFont(new Font("Tahoma", Font.PLAIN, 20));
        // JScrollPane scroll = new JScrollPane(chatArea);
        // scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        add(chatArea);
        // chatBox
        chatBox.setBounds(70, 490, 400, 30);
        chatBox.setFont(new Font("Tahoma", Font.PLAIN, 20));

        // button send
        sendButton = new JButton("Send");
        sendButton.addActionListener(this);
        sendButton.setBounds(500, 490, 125, 33);
        sendButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        sendButton.setBackground(Color.BLACK);
        sendButton.setForeground(Color.WHITE);
        add(sendButton);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bot.png"));
        Image i3 = i1.getImage().getScaledInstance(300, 350, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l3 = new JLabel(i2);
        l3.setBounds(660, 60, 300, 350);
        add(l3);

        chatBox.addActionListener(this);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == chatBox || ae.getSource() == sendButton) {
            String text = chatBox.getText().toLowerCase();
            chatArea.append("You->  " + text + "\n");
            chatBox.setText("");
            // Check if the user input is "clear"
            if (text.equals("clear")) {
                // Clear the chat area
                chatArea.setText("");
                return; // Exit the method to avoid further processing for "clear" command
            } else if (text.contains("hello") || text.contains("hi")) {
                bot("Hello! Welcome to Travel Company! How can I assist you ?");
            } else if (text.contains("who are you ?")) {
                bot("I am simply a ChatBot!");
            } else if (text.contains("who developed you ?")) {
                bot("I am developed by Shivam Gupta.");
            } else if (text.contains("who is he ?")) {
                bot("He is my Master!");
            } else if (text.contains("i have a query")) {
                bot("Please feel free to ask your query.");
            } else if (text.contains("query")) {
                bot("Please elaborate more on your query !");
            } else if (text.contains("what is your working hour ?")) {
                bot("We work 24/7 for you!");
            } else if (text.contains("toll-free number ?")) {
                bot("You can call us at 1800 3200 4545. It's free.");
            } else if (text.contains("list of hotels")) {
                bot("(i) JW Marriott Hotel (ii) Madarin Oriental Hotel \n           (iii) Four Seasons Hotel (iv) Raddisson Blue Hotel \n           (v) Classic Hotel (vi) The Bay Club Hotel \n           (vii) Breeze Blow Hotel (viii) Luxury Hotel \n           (ix) Happy Morning Hotel (x) River View Hotel \n           (xi) 5 Star Hotel (xii) Diamond Hotel");
            } else if (text.contains("price list of jw marriott hotel")) {
                bot("Yes Sure , the price list of JW Marriott Hotel are :- \n           Cost Per Person : Rs.5000/- \n           AC Room : Rs.1000/-\n           Food Included : Rs.2200/-");
            } else if (text.contains("price list of madarin oriental hotel")) {
                bot("Yes Sure , the price list of Madarin Oriental Hotel are :- \n           Cost Per Person : Rs.4000/- \n           AC Room : Rs.1200/-\n           Food Included : Rs.1800/-");
            } else if (text.contains("price list of four seasons hotel")) {
                bot("Yes Sure , the price list of Four Seasons Hotel are :- \n           Cost Per Person : Rs.3000/- \n           AC Room : Rs.1000/-\n           Food Included : Rs.2000/-");
            } else if (text.contains("price list of raddisson blue hotel")) {
                bot("Yes Sure , the price list of Raddisson Blue Hotel are :- \n           Cost Per Person : Rs.3400/- \n           AC Room : Rs.1000/-\n           Food Included : Rs.1700/-");
            } else if (text.contains("price list of classic hotel")) {
                bot("Yes Sure , the price list of Classic Hotel are :- \n           Cost Per Person : Rs.3500/- \n           AC Room : Rs.800/-\n           Food Included : Rs.800/-");
            } else if (text.contains("price list of the bay club hotel")) {
                bot("Yes Sure , the price list of The Bay Club Hotel are :- \n           Cost Per Person : Rs.2500/- \n           AC Room : Rs.1200/-\n           Food Included : Rs.1600/-");
            } else if (text.contains("price list of breeze blow hotel")) {
                bot("Yes Sure , the price list of Breeze Blow Hotel are :- \n           Cost Per Person : Rs.2000/- \n           AC Room : Rs.1000/-\n           Food Included : Rs.1000/-");
            } else if (text.contains("price list of luxury hotel")) {
                bot("Yes Sure , the price list of Luxury Hotel are :- \n           Cost Per Person : Rs.2500/- \n           AC Room : Rs.800/-\n           Food Included : Rs.1000/-");
            } else if (text.contains("price list of happy morning hotel")) {
                bot("Yes Sure , the price list of Happy Morning Hotel are :- \n           Cost Per Person : Rs.2400/- \n           AC Room : Rs.1000/-\n           Food Included : Rs.800/-");
            } else if (text.contains("price list of river view hotel")) {
                bot("Yes Sure , the price list of River View Hotel are :- \n           Cost Per Person : Rs.2000/- \n           AC Room : Rs.1000/-\n           Food Included : Rs.800/-");
            } else if (text.contains("price list of 5 star hotel")) {
                bot("Yes Sure , the price list of 5 Star Hotel are :- \n           Cost Per Person : Rs.5000/- \n           AC Room : Rs.1000/-\n           Food Included : Rs.2200/-");
            } else if (text.contains("price list of diamond hotel")) {
                bot("Yes Sure , the price list of Diamond Hotel are :- \n           Cost Per Person : Rs.4800/- \n           AC Room : Rs.1200/-\n           Food Included : Rs.2000/-");
            } else if (text.contains("package details")) {
                bot("We provide three Package : -\n(i) Gold Package (ii) Silver Package (iii) Bronze Package");
            } else if (text.contains("facilities in gold package")) {
                bot("GOLD PACKAGE :-\n6 Days and 7 Nights, Airport Assistance, Half Day City Tour, \nDaily Buffet, Hard Drinks Free, Full Day 3 Island Cruise, \nEnglish Speaking Guide and many more.");
            } else if (text.contains("gold package price")) {
                bot("Rs 12000/- Only!");
            } else if (text.contains("facilities in silver package")) {
                bot("SILVER PACKAGE :-\n5 Days and 6 Nights, Toll Free, Free Entry Tickets, Greet at Airport, \nWelcome Drinks on Arrival, Cruise with Dinner and many more.");
            } else if (text.contains("silver package price")) {
                bot("Rs 15000/- Only!");
            } else if (text.contains("facilities in bronze package")) {
                bot("BRONZE PACKAGE :-\n4 Days and 5 Nights, Return Airfare, Free Games, River Rafting, \nSoft Drinks Free, Daily Buffet, Dinner and many more.");
            } else if (text.contains("bronze package price")) {
                bot("Rs 22000/- Only!");
            } else if (text.contains("bye")) {
                bot("Bye! Have a Nice Day.");
            } else if (text.contains("thank you") || text.contains("thanks")) {
                bot("Thank you! Have a fantastic trip !");
            } else {
                bot("I don't understand!");
            }
        }
    }

    private void bot(String string) {
        chatArea.append("BOT-> " + string + "\n");
    }

    public static void main(String[] args) {
        new ChatBot("");
    }
}
