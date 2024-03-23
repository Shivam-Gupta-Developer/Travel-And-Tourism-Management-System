package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddCustomer extends JFrame implements ActionListener {

    JLabel labelusername, labelname;
    JComboBox comboid,cmbcountry;
    JTextField tfnumber, tfaddress, tfphone, tfemail;
    JRadioButton rmale, rfemale;
    JButton add, back;
    JLabel lblErrorNumber, lblErrorAddress, lblErrorPhone, lblErrorEmail;

    AddCustomer(String username) {
        setBounds(292, 90, 1000, 595);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("ADD PERSONAL DETAILS");
        text.setBounds(50, 20, 950, 60);
        text.setForeground(new Color(0, 0, 128));
        text.setFont(new Font("Sans-Serif", Font.BOLD, 50));
        add(text);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(50, 100, 150, 25);
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(220, 100, 150, 25);
        labelusername.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(labelusername);

        JLabel lblid = new JLabel("Id");
        lblid.setBounds(50, 140, 150, 25);
        lblid.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblid);

        comboid = new JComboBox(new String[]{"Passport", "Aadhar Card", "Pan Card", "Ration Card"});
        comboid.setBounds(220, 140, 150, 28);
        comboid.setFont(new Font("Tahoma", Font.BOLD, 16));
        comboid.setBackground(Color.WHITE);
        add(comboid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(50, 180, 150, 25);
        lblnumber.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblnumber);

        tfnumber = new JTextField();
        tfnumber.setBounds(220, 180, 200, 25);
        tfnumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
        tfnumber.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent ke) {
                lblErrorNumber.setText("");
            }
        });
        add(tfnumber);

        lblErrorNumber = new JLabel();
        lblErrorNumber.setBounds(425, 180, 150, 30);
        lblErrorNumber.setForeground(Color.RED);
        add(lblErrorNumber);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 220, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblname);

        labelname = new JLabel();
        labelname.setBounds(220, 220, 150, 25);
        labelname.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(labelname);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(50, 260, 150, 25);
        lblgender.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblgender);

        rmale = new JRadioButton("Male");
        rmale.setBounds(220, 260, 70, 25);
        rmale.setFont(new Font("Tahoma", Font.BOLD, 16));
        rmale.setBackground(Color.WHITE);
        add(rmale);

        rfemale = new JRadioButton("Female");
        rfemale.setBounds(300, 260, 100, 25);
        rfemale.setFont(new Font("Tahoma", Font.BOLD, 16));
        rfemale.setBackground(Color.WHITE);
        add(rfemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);

        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(50, 300, 150, 25);
        lblcountry.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblcountry);

        cmbcountry = new JComboBox(new String[]{"Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua and Barbuda", "Argentina", "Armenia", "Australia",
            "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin",
            "Bhutan", "Bolivia", "Bosnia and Herzegovina", "Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina Faso", "Burundi",
            "Cabo Verde", "Cambodia", "Cameroon", "Canada", "Central African Republic", "Chad", "Chile", "China", "Colombia",
            "Comoros", "Congo (Congo-Brazzaville)", "Costa Rica", "Croatia", "Cuba", "Cyprus", "Czechia (Czech Republic)",
            "Democratic Republic of the Congo", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "Ecuador", "Egypt",
            "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Eswatini", "Ethiopia", "Fiji", "Finland",
            "France", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Greece", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau",
            "Guyana", "Haiti", "Holy See", "Honduras", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland",
            "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Kuwait", "Kyrgyzstan", "Laos",
            "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Madagascar", "Malawi",
            "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius", "Mexico", "Micronesia",
            "Moldova", "Monaco", "Mongolia", "Montenegro", "Morocco", "Mozambique", "Myanmar (formerly Burma)", "Namibia", "Nauru",
            "Nepal", "Netherlands", "New Zealand", "Nicaragua", "Niger", "Nigeria", "North Korea", "North Macedonia (formerly Macedonia)",
            "Norway", "Oman", "Pakistan", "Palau", "Palestine State", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines",
            "Poland", "Portugal", "Qatar", "Romania", "Russia", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines",
            "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore",
            "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Korea", "South Sudan", "Spain", "Sri Lanka",
            "Sudan", "Suriname", "Sweden", "Switzerland", "Syria", "Tajikistan", "Tanzania", "Thailand", "Timor-Leste", "Togo",
            "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates",
            "United Kingdom", "United States of America", "Uruguay", "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "Yemen",
            "Zambia", "Zimbabwe"});
        cmbcountry.setSelectedItem("India");
        cmbcountry.setBounds(220, 300, 200, 25);
        cmbcountry.setFont(new Font("Tahoma", Font.BOLD, 16));
        cmbcountry.setBackground(Color.WHITE);
        add(cmbcountry);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50, 340, 150, 25);
        lbladdress.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(220, 340, 200, 25);
        tfaddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
        tfaddress.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent ke) {
                lblErrorAddress.setText("");
            }
        });
        add(tfaddress);

        lblErrorAddress = new JLabel();
        lblErrorAddress.setBounds(425, 340, 200, 25);
        lblErrorAddress.setForeground(Color.RED);
        add(lblErrorAddress);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(50, 380, 150, 25);
        lblphone.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(220, 380, 200, 25);
        tfphone.setFont(new Font("Tahoma", Font.PLAIN, 20));
        tfphone.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent ke) {
                lblErrorPhone.setText("");
            }
        });
        add(tfphone);

        // Register tfphoneKeyPressed as a key listener for tfphone
        tfphone.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                tfphoneKeyPressed(evt);
            }
        });

        lblErrorPhone = new JLabel();
        lblErrorPhone.setBounds(425, 380, 200, 25);
        lblErrorPhone.setForeground(Color.RED);
        add(lblErrorPhone);

        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(50, 420, 150, 25);
        lblemail.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(220, 420, 200, 25);
        tfemail.setFont(new Font("Tahoma", Font.PLAIN, 20));
        tfemail.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent ke) {
                lblErrorEmail.setText("");
            }
        });
        add(tfemail);

        lblErrorEmail = new JLabel();
        lblErrorEmail.setBounds(425, 420, 200, 25);
        lblErrorEmail.setForeground(Color.RED);
        add(lblErrorEmail);

        add = new JButton("Add");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setFont(new Font("Tahoma", Font.BOLD, 16));
        add.setBounds(120, 480, 100, 30);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma", Font.BOLD, 16));
        back.setBounds(280, 480, 100, 30);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/man.png"));
        Image i2 = i1.getImage().getScaledInstance(400, 360, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(520, 100, 400, 360);
        add(image);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from account where username = '" + username + "'");

            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    public void tfphoneKeyPressed(KeyEvent evt) {
        // action when key is press
        // get tfphone string
        String phoneNumber = tfphone.getText();
        // get length of string
        int length = phoneNumber.length();

        char c = evt.getKeyChar();

        // check for number 0 to 9
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            // check for length not more than 10 digit
            if (length < 10) {
                // editable true
                tfphone.setEditable(true);
            } else {
                // not editable if length more than 10 digit
                tfphone.setEditable(false);
            }
        } else {
            // now allow keys 'backspace' and 'delete' for edit
            if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                // then allow editable
                tfphone.setEditable(true);
            } else {
                tfphone.setEditable(false);
            }
        }
    }

    public static boolean isValidEmail(String email) {
        String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern pattern = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public void actionPerformed(ActionEvent ae) {
        String phoneNumber = tfphone.getText().trim();
        if (tfnumber.getText().trim().isEmpty() && tfaddress.getText().trim().isEmpty() && tfphone.getText().trim().isEmpty() && tfemail.getText().trim().isEmpty()) {
            lblErrorNumber.setText("* Please fill out this field");
            lblErrorAddress.setText("* Please fill out this field");
            lblErrorPhone.setText("* Please fill out this field");
            lblErrorEmail.setText("* Please fill out this field");
        } else if (tfnumber.getText().trim().isEmpty()) {
            lblErrorNumber.setText("* Please fill out this field");
        } else if (tfaddress.getText().trim().isEmpty()) {
            lblErrorAddress.setText("* Please fill out this field");
        } else if (tfphone.getText().trim().isEmpty()) {
            lblErrorPhone.setText("* Please fill out this field");
        } else if (!phoneNumber.matches("\\d{10}")) {
            // If the phone number does not match the format (10 digits), show error message
            JOptionPane.showMessageDialog(null, "Invalid phone number format. Please enter a 10-digit number.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Stop further processing
        } else if (tfemail.getText().trim().isEmpty()) {
            lblErrorEmail.setText("* Please fill out this field");
        } else if (!isValidEmail(tfemail.getText())) {
            JOptionPane.showMessageDialog(this, "Invalid Email Format", "ERROR", JOptionPane.ERROR_MESSAGE);
            return; // Exit the method if email is invalid
        }
        if (ae.getSource() == back) {
            setVisible(false);
        } else if (tfnumber.getText().trim().isEmpty() || tfaddress.getText().trim().isEmpty() || tfphone.getText().trim().isEmpty() || tfemail.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are necessary", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            if (ae.getSource() == add) {
                try {
                    String username = labelusername.getText();
                    String id = (String) comboid.getSelectedItem();
                    String number = tfnumber.getText();
                    String name = labelname.getText();
                    String gender = null;
                    if (rmale.isSelected()) {
                        gender = "Male";
                    } else {
                        gender = "Female";
                    }
                    String country = (String) cmbcountry.getSelectedItem();
                    String address = tfaddress.getText();
                    String phone = tfphone.getText();
                    String email = tfemail.getText();
                    Conn c = new Conn();
                    String query = "insert into customer values('" + username + "', '" + id + "', '" + number + "', '" + name + "', '" + gender + "', '" + country + "', '" + address + "', '" + phone + "', '" + email + "')";
                    c.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");

                    setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new AddCustomer("Mohan");
    }
}
