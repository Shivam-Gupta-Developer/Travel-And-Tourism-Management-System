package travel.management.system;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login, signup, password;
    JTextField tfusername;
    JPasswordField tfpassword;
    JLabel lblErrorUname, lblErrorPass;

    Login() {
        setSize(1100, 550);
        setLocation(100, 75);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(255, 255, 255));
        p1.setBounds(0, 0, 550, 550);
        p1.setLayout(null);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/permission.png"));
        Image i2 = i1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(80, 60, 400, 400);
        p1.add(image);

        JPanel p2 = new JPanel();
        p2.setBackground(new Color(0, 0, 102));
        p2.setLayout(null);
        p2.setBounds(550, 30, 535, 482);
        add(p2);
        
        JLabel lbllogin = new JLabel("LOGIN");
        lbllogin.setBounds(230, 30, 150, 35);
        lbllogin.setForeground(Color.WHITE);
        lbllogin.setFont(new Font("Tahoma", Font.BOLD, 30));
        p2.add(lbllogin);
        
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/user.png"));
        Image i22 = i11.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel image1 = new JLabel(i33);
        image1.setBounds(45, 80, 20, 28);
        p2.add(image1);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(70, 80, 100, 25);
        lblusername.setForeground(Color.WHITE);
        lblusername.setFont(new Font("Tahoma", Font.PLAIN, 22));
        p2.add(lblusername);
        
//        tfusername = new JTextField();
//        tfusername.setBounds(70, 115, 330, 30);
//        tfusername.setFont(new Font("Tahoma", Font.PLAIN, 20));
//        tfusername.setBorder(BorderFactory.createEmptyBorder());
//        tfusername.addKeyListener(new KeyAdapter() {
//            public void keyReleased(KeyEvent ke) {
//                lblErrorUname.setText("");
//            }
//        });
//        p2.add(tfusername);

        tfusername = new JTextField();
        tfusername.setBounds(70, 115, 330, 30);
        tfusername.setFont(new Font("Tahoma", Font.PLAIN, 20));
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        tfusername.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent ke) {
                // Validate username input
                String username = tfusername.getText().trim();
                if (!username.matches("[a-zA-Z]+")) {
                    lblErrorUname.setText("* Username should contain only alphabetic characters");
                } else {
                    lblErrorUname.setText("");
                }
            }
        });
        p2.add(tfusername);

        lblErrorUname = new JLabel();
        lblErrorUname.setBounds(70, 138, 550, 30);
        lblErrorUname.setForeground(Color.RED);
        p2.add(lblErrorUname);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(70, 185, 100, 25);
        lblpassword.setForeground(Color.WHITE);
        lblpassword.setFont(new Font("Tahoma", Font.PLAIN, 22));
        p2.add(lblpassword);
        
        ImageIcon i111 = new ImageIcon(ClassLoader.getSystemResource("icons/eye_closed.png"));
        Image i222 = i111.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i333 = new ImageIcon(i222);
        JLabel image11 = new JLabel(i333);
        image11.setBounds(45, 185, 20, 28);
        p2.add(image11);

//        tfpassword = new JPasswordField();
//        tfpassword.setBounds(70, 220, 330, 30);
//        tfpassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
//        tfpassword.setBorder(BorderFactory.createEmptyBorder());
//        tfpassword.addKeyListener(new KeyAdapter() {
//            public void keyReleased(KeyEvent ke) {
//                lblErrorPass.setText("");
//            }
//        });
//        p2.add(tfpassword);

        tfpassword = new JPasswordField();
        tfpassword.setBounds(70, 220, 330, 30);
        tfpassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        tfpassword.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent ke) {
                // Validate password input
                String password = String.valueOf(tfpassword.getPassword());
                if (!password.matches("^(?=.*[a-zA-Z\\d@#$%^&+=]).{8}$")) {
                    lblErrorPass.setText("* Password should contain alphabets, digits and a special character and be exactly 8 characters long");
                } else {
                    lblErrorPass.setText("");
                }
            }
        });
        
        p2.add(tfpassword);
     
        lblErrorPass = new JLabel();
        lblErrorPass.setBounds(70, 245, 750, 30);
        lblErrorPass.setFont(new Font("Tahoma",Font.PLAIN,9));
        lblErrorPass.setForeground(Color.RED);
        p2.add(lblErrorPass);

        password = new JButton("Forget Password?");
        password.setBounds(275, 265, 140, 30);
        password.setBackground(new Color(0, 0, 102));
        password.setForeground(Color.WHITE);
        password.setBorder(new LineBorder(new Color(0, 0, 102)));
        password.addActionListener(this);
        p2.add(password);

        login = new JButton("LOGIN");
        login.setBounds(70, 320, 320, 40);
        login.setBackground(new Color(0, 0, 102));
        login.setForeground(Color.WHITE);
        login.setBorder(new LineBorder(new Color(133, 193, 233)));
        lbllogin.setFont(new Font("Tahoma", Font.BOLD, 40));
        login.addActionListener(this);
        p2.add(login);

        JLabel text = new JLabel("Don't have an account?");
        text.setBounds(120, 400, 150, 40);
        text.setForeground(Color.RED);
        p2.add(text);

        signup = new JButton("Signup");
        signup.setBounds(260, 405, 90, 30);
        signup.setBackground(new Color(0, 0, 102));
        signup.setForeground(Color.WHITE);
        signup.setBorder(new LineBorder(new Color(133, 193, 233)));
        signup.addActionListener(this);
        p2.add(signup);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (tfusername.getText().trim().isEmpty() && tfpassword.getText().trim().isEmpty()) {
            lblErrorUname.setText("* Username is Empty");
            lblErrorPass.setText("* Password is Empty");
        } else if (tfusername.getText().trim().isEmpty()) {
            lblErrorUname.setText("* Username is Empty");
        } else if (tfpassword.getText().trim().isEmpty()) {
            lblErrorPass.setText("* Password is Empty");
        }

        if (ae.getSource() == login) {
            try {
                String username = tfusername.getText();
                String pass = tfpassword.getText();

                String query = "select * from account where username = '" + username + "' AND password = '" + pass + "'";
                Conn c = new Conn();

                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    setVisible(false);
                    new Loading(username);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Username Or Password", "ERROR", JOptionPane.ERROR_MESSAGE);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == signup) {
            setVisible(false);
            new Signup();
        } else {
            setVisible(false);
            new ForgetPassword();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
