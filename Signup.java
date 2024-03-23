package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Signup extends JFrame implements ActionListener {

    JButton create, back;
    JTextField tfname, tfusername, tfpassword, tfanswer;
    Choice security;
    JLabel lblErrorName, lblErrorUname, lblErrorPassword, lblErrorAns;

    Signup() {
        setBounds(100, 80, 1100, 500);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(0, 0, 102));
        p1.setBounds(0, 0, 550, 500);
        p1.setLayout(null);
        add(p1);

        JLabel lblsignup = new JLabel("SIGNUP");
        lblsignup.setBounds(200, 40, 125, 25);
        lblsignup.setForeground(Color.WHITE);
        lblsignup.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.add(lblsignup);

        // Username field and error label
        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblusername.setForeground(Color.WHITE);
        lblusername.setBounds(60, 100, 125, 25);
        p1.add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(200, 100, 180, 25);
        tfusername.setFont(new Font("Tahoma", Font.PLAIN, 14));
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
        p1.add(tfusername);
        p1.add(tfusername);

        lblErrorUname = new JLabel();
        lblErrorUname.setBounds(200, 120, 550, 30);
        lblErrorUname.setForeground(Color.RED);
        p1.add(lblErrorUname);

        // Name field and error label
        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblname.setForeground(Color.WHITE);
        lblname.setBounds(60, 160, 125, 25);
        p1.add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 160, 180, 25);
        tfname.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tfname.setBorder(BorderFactory.createEmptyBorder());
        tfname.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent ke) {
                // Validate username input
                String username = tfname.getText().trim();
                if (!username.matches("[a-zA-Z\\-]+")) {
                    lblErrorName.setText("* Name should contain only alphabetic characters and hyphens");
                } else {
                    lblErrorName.setText("");
                }
            }
        });
        p1.add(tfname);

        lblErrorName = new JLabel();
        lblErrorName.setBounds(200, 180, 550, 30);
        lblErrorName.setFont(new Font("Tahoma", Font.BOLD, 10));
        lblErrorName.setForeground(Color.RED);
        p1.add(lblErrorName);

        // Password field and error label
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblpassword.setForeground(Color.WHITE);
        lblpassword.setBounds(60, 220, 125, 25);
        p1.add(lblpassword);

        tfpassword = new JTextField();
        tfpassword.setBounds(200, 220, 180, 25);
        tfpassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        tfpassword.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent ke) {
                // Validate password input
                String password = tfpassword.getText();
                if (!password.matches("^(?=.*[a-zA-Z\\d@#$%^&+=]).{8}$")) {
                    lblErrorPassword.setText("* Password should contain alphabets, digits and a special character and be exactly 8 characters long");
                } else {
                    lblErrorPassword.setText("");
                }
            }
        });
        p1.add(tfpassword);

        lblErrorPassword = new JLabel();
        lblErrorPassword.setBounds(200, 240, 750, 30);
        lblErrorPassword.setFont(new Font("Tahoma", Font.BOLD, 6));
        lblErrorPassword.setForeground(Color.RED);
        p1.add(lblErrorPassword);

        // Security question dropdown
        JLabel lblsecurity = new JLabel("Security Question");
        lblsecurity.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblsecurity.setForeground(Color.WHITE);
        lblsecurity.setBounds(60, 280, 125, 25);
        p1.add(lblsecurity);

        security = new Choice();
        security.add("Favourite Player");
        security.add("Favourite Game");
        security.add("Favourite Color");
        security.add("Favourite Movie");
        security.setFont(new Font("Tahoma", Font.PLAIN, 14));
        security.setBounds(200, 280, 180, 25);
        p1.add(security);

        // Answer field and error label
        JLabel lblanswer = new JLabel("Answer");
        lblanswer.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblanswer.setForeground(Color.WHITE);
        lblanswer.setBounds(60, 340, 125, 25);
        p1.add(lblanswer);

        tfanswer = new JTextField();
        tfanswer.setBounds(200, 340, 180, 25);
        tfanswer.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);

        lblErrorAns = new JLabel();
        lblErrorAns.setBounds(200, 360, 150, 30);
        lblErrorAns.setForeground(Color.RED);
        p1.add(lblErrorAns);

        // Create and Back buttons
        create = new JButton("Create");
        create.setBackground(Color.WHITE);
        create.setForeground(new Color(133, 193, 233));
        create.setFont(new Font("Tahoma", Font.BOLD, 14));
        create.setBounds(80, 400, 100, 30);
        create.addActionListener(this);
        p1.add(create);

        back = new JButton("Back");
        back.setBackground(Color.WHITE);
        back.setForeground(new Color(133, 193, 233));
        back.setFont(new Font("Tahoma", Font.BOLD, 14));
        back.setBounds(250, 400, 100, 30);
        back.addActionListener(this);
        p1.add(back);

        // Add image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/add-user.png"));
        Image i2 = i1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(650, 20, 400, 400);
        add(image);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Login();
        } else if (ae.getSource() == create) {
            if (validateFields()) {
                try {
                    // Insert data into the database
                    String username = tfusername.getText();
                    String name = tfname.getText();
                    String password = tfpassword.getText();
                    String question = security.getSelectedItem();
                    String answer = tfanswer.getText();

                    // Execute database query
                    String query = "INSERT INTO account VALUES('" + username + "','" + name + "','" + password + "','" + question + "','" + answer + "')";
                    Conn c = new Conn();
                    c.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Account Created Successfully");

                    setVisible(false);

                    new Login();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private boolean validateFields() {
        String username = tfusername.getText().trim();
        String name = tfname.getText().trim();
        String password = tfpassword.getText();
        String answer = tfanswer.getText().trim();

        // Validate fields
        boolean isValid = true;

        if (username.isEmpty()) {
            lblErrorUname.setText("* Username is Empty");
            isValid = false;
        } else if (!username.matches("[a-zA-Z]+")) {
            lblErrorUname.setText("* Username should contain only alphabetic characters");
            isValid = false;
        } else {
            lblErrorUname.setText("");
        }

        if (name.isEmpty()) {
            lblErrorName.setText("* Name is Empty");
            isValid = false;
        } else if (!name.matches("[a-zA-Z\\-]+")) {
            lblErrorName.setText("* Name should contain only alphabetic characters and hyphens");
            isValid = false;
        } else {
            lblErrorName.setText("");
        }

        if (password.isEmpty()) {
            lblErrorPassword.setText("* Password is Empty");
            isValid = false;
        } else if (!password.matches("^(?=.*[a-zA-Z\\d@#$%^&+=]).{8}$")) {
            lblErrorPassword.setText("* Password should contain alphabets, digits and a special character and be exactly 8 characters long");
            isValid = false;
        } else {
            lblErrorPassword.setText("");
        }

        if (answer.isEmpty()) {
            lblErrorAns.setText("* Answer is Empty");
            isValid = false;
        } else {
            lblErrorAns.setText("");
        }

        return isValid;
    }

    public static void main(String[] args) {
        new Signup();
    }
}

/*
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener {

    JButton create, back;
    JTextField tfname, tfusername, tfpassword, tfanswer;
    Choice security;
    JLabel lblErrorName, lblErrorUname, lblErrorPassword, lblErrorAns;

    Signup() {
        setBounds(100, 80, 1100, 500);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(0, 0, 102));
        p1.setBounds(0, 0, 550, 500);
        p1.setLayout(null);
        add(p1);

        JLabel lblsignup = new JLabel("SIGNUP");
        lblsignup.setBounds(200, 40, 125, 25);
        lblsignup.setForeground(Color.WHITE);
        lblsignup.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.add(lblsignup);

        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblusername.setForeground(Color.WHITE);
        lblusername.setBounds(60, 100, 125, 25);
        p1.add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(200, 100, 180, 25);
        tfusername.setFont(new Font("Tahoma", Font.PLAIN, 14));
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
        p1.add(tfusername);

        lblErrorUname = new JLabel();
        lblErrorUname.setBounds(200, 120, 550, 30);
        lblErrorUname.setForeground(Color.RED);
        p1.add(lblErrorUname);

        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblname.setForeground(Color.WHITE);
        lblname.setBounds(60, 160, 125, 25);
        p1.add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 160, 180, 25);
        tfname.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tfname.setBorder(BorderFactory.createEmptyBorder());
        tfname.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent ke) {
                // Validate username input
                String username = tfname.getText().trim();
                if (!username.matches("[a-zA-Z\\-]+")) {
                    lblErrorName.setText("* Name should contain only alphabetic characters and hyphens");
                } else {
                    lblErrorName.setText("");
                }
            }
        });

        p1.add(tfname);

        lblErrorName = new JLabel();
        lblErrorName.setBounds(200, 180, 550, 30);
        lblErrorName.setFont(new Font("Tahoma", Font.BOLD, 10));
        lblErrorName.setForeground(Color.RED);
        p1.add(lblErrorName);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblpassword.setForeground(Color.WHITE);
        lblpassword.setBounds(60, 220, 125, 25);
        p1.add(lblpassword);

        tfpassword = new JTextField();
        tfpassword.setBounds(200, 220, 180, 25);
        tfpassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        tfpassword.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent ke) {
                // Validate password input
                String password = tfpassword.getText();
                if (!password.matches("^(?=.*[a-zA-Z\\d@#$%^&+=]).{8}$")) {
                    lblErrorPassword.setText("* Password should contain alphabets, digits and a special character and be exactly 8 characters long");
                } else {
                    lblErrorPassword.setText("");
                }
            }
        });

        p1.add(tfpassword);

        lblErrorPassword = new JLabel();
        lblErrorPassword.setBounds(200, 240, 750, 30);
        lblErrorPassword.setFont(new Font("Tahoma", Font.BOLD, 6));
        lblErrorPassword.setForeground(Color.RED);
        p1.add(lblErrorPassword);

        JLabel lblsecurity = new JLabel("Security Question");
        lblsecurity.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblsecurity.setForeground(Color.WHITE);
        lblsecurity.setBounds(60, 280, 125, 25);
        p1.add(lblsecurity);

        security = new Choice();
        security.add("Favourite Player");
        security.add("Favourite Game");
        security.add("Favourite Color");
        security.add("Favourite Movie");
        security.setFont(new Font("Tahoma", Font.PLAIN, 14));
        security.setBounds(200, 280, 180, 25);
        p1.add(security);

        JLabel lblanswer = new JLabel("Answer");
        lblanswer.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblanswer.setForeground(Color.WHITE);
        lblanswer.setBounds(60, 340, 125, 25);
        p1.add(lblanswer);

        tfanswer = new JTextField();
        tfanswer.setBounds(200, 340, 180, 25);
        tfanswer.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        tfanswer.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent ke) {
                lblErrorAns.setText("");
            }
        });
        p1.add(tfanswer);

        lblErrorAns = new JLabel();
        lblErrorAns.setBounds(200, 360, 150, 30);
        lblErrorAns.setForeground(Color.RED);
        p1.add(lblErrorAns);

        create = new JButton("Create");
        create.setBackground(Color.WHITE);
        create.setForeground(new Color(133, 193, 233));
        create.setFont(new Font("Tahoma", Font.BOLD, 14));
        create.setBounds(80, 400, 100, 30);
        create.addActionListener(this);
        p1.add(create);

        back = new JButton("Back");
        back.setBackground(Color.WHITE);
        back.setForeground(new Color(133, 193, 233));
        back.setFont(new Font("Tahoma", Font.BOLD, 14));
        back.setBounds(250, 400, 100, 30);
        back.addActionListener(this);
        p1.add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/add-user.png"));
        Image i2 = i1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(650, 20, 400, 400);
        add(image);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (tfname.getText().trim().isEmpty() && tfusername.getText().trim().isEmpty() && tfpassword.getText().trim().isEmpty() && tfanswer.getText().trim().isEmpty()) {
            lblErrorName.setText("* Name is Empty");
            lblErrorUname.setText("* Username is Empty");
            lblErrorPassword.setText("* Password is Empty");
            lblErrorAns.setText("* Answer is Empty");
        } else if (tfname.getText().trim().isEmpty()) {
            lblErrorName.setText("* Name is Empty");
        } else if (tfusername.getText().trim().isEmpty()) {
            lblErrorUname.setText("* Username is Empty");
        } else if (tfpassword.getText().trim().isEmpty()) {
            lblErrorPassword.setText("* Password is Empty");
        } else if (tfanswer.getText().trim().isEmpty()) {
            lblErrorAns.setText("* Answer is Empty");
        } else {
            //Validate username
            String username = tfusername.getText().trim();
            if (!username.matches("[a-zA-Z]+")) {
                lblErrorUname.setText("* Username should contain only alphabetic characters");
                return; // Stop further processing
            }

            // Validate name
            String name = tfname.getText().trim();
            if (!name.matches("[a-zA-Z\\-]+")) {
                lblErrorName.setText("* Name should contain only alphabetic characters and hyphens");
                return; // Stop further processing
            }

            // Validate password
            String password = tfpassword.getText();
            if (!password.matches("^(?=.*[a-zA-Z\\d@#$%^&+=]).{8}$")) {
                lblErrorPassword.setText("* Password should contain alphabets, digits and a special character and be exactly 8 characters long");
                return; // Stop further processing
            }

            // Validate answer
            String answer = tfanswer.getText().trim();
            if (answer.isEmpty()) {
                lblErrorAns.setText("* Answer is Empty");
                return; // Stop further processing
            }
        }

        if (ae.getSource() == back) {
            setVisible(false);
            new Login();
        } else if (tfname.getText().trim().isEmpty() || tfusername.getText().trim().isEmpty() || tfpassword.getText().trim().isEmpty() || tfanswer.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are necessary", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            if (ae.getSource() == create) {
                try {

                    String username = tfusername.getText();
                    String name = tfname.getText();
                    String password = tfpassword.getText();
                    String question = security.getSelectedItem();
                    String answer = tfanswer.getText();

                    String query = "INSERT INTO account VALUES('" + username + "','" + name + "','" + password + "','" + question + "','" + answer + "')";
                    Conn c = new Conn();
                    c.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Account Created Successfully");

                    setVisible(false);

                    new Login();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}
*/

