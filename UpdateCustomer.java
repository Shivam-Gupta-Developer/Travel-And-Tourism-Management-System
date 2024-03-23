package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateCustomer extends JFrame implements ActionListener {

    JLabel labelusername, labelname;
    JComboBox comboid,cmbcountry;
    JTextField tfnumber, tfcountry, tfaddress, tfphone, tfemail, tfid, tfgender;
    JRadioButton rmale, rfemale;
    JButton add, back;
    JLabel lblErrorNumber, lblErrorCountry, lblErrorAddress, lblErrorPhone, lblErrorEmail;

    UpdateCustomer(String username) {
        setBounds(292, 90, 1000, 595);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("UPDATE CUSTOMER DETAILS");
        text.setBounds(50, 20, 950, 35);
        text.setFont(new Font("Sans-Serif", Font.BOLD, 40));
        add(text);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(50, 100, 150, 25);
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(220, 100, 200, 25);
        add(labelusername);

        JLabel lblid = new JLabel("Id");
        lblid.setBounds(50, 140, 150, 25);
        lblid.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblid);

        comboid = new JComboBox(new String[]{"Passport", "Aadhar Card", "Pan Card", "Ration Card"});
        comboid.setBounds(220, 140, 150, 25);
        comboid.setBackground(Color.WHITE);
        add(comboid);
        
        tfid = new JTextField();
        tfid.setBounds(220, 140, 150, 25);
        add(tfid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(50, 180, 150, 25);
        lblnumber.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblnumber);

        tfnumber = new JTextField();
        tfnumber.setBounds(220, 180, 200, 25);
        add(tfnumber);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 220, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblname);

        labelname = new JLabel();
        labelname.setBounds(220, 220, 200, 25);
        add(labelname);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(50, 260, 150, 25);
        lblgender.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblgender);

        tfgender = new JTextField();
        tfgender.setBounds(220, 260, 200, 25);
        add(tfgender);

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
        cmbcountry.setBackground(Color.WHITE);
        add(cmbcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(220, 300, 200, 25);
        add(tfcountry);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50, 340, 150, 25);
        lbladdress.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(220, 340, 200, 25);
        add(tfaddress);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(50, 380, 150, 25);
        lblphone.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(220, 380, 200, 25);
        add(tfphone);

        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(50, 420, 150, 25);
        lblemail.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(220, 420, 200, 25);
        add(tfemail);

        add = new JButton("Update");
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

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update-customer.png"));
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(520, 20, 450, 500);
        add(image);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where username = '" + username + "'");

            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
                tfid.setText(rs.getString("id"));
                tfnumber.setText(rs.getString("number"));
                tfgender.setText(rs.getString("gender"));
                tfcountry.setText(rs.getString("country"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (tfnumber.getText().trim().isEmpty() && tfaddress.getText().trim().isEmpty() && tfphone.getText().trim().isEmpty() && tfemail.getText().trim().isEmpty()) {
            lblErrorNumber.setText("* Please fill out this field");
//            lblErrorCountry.setText("* Please fill out this field");
            lblErrorAddress.setText("* Please fill out this field");
            lblErrorPhone.setText("* Please fill out this field");
            lblErrorEmail.setText("* Please fill out this field");
        } else if (tfnumber.getText().trim().isEmpty()) {
            lblErrorNumber.setText("* Please fill out this field");
        } else if (tfaddress.getText().trim().isEmpty()) {
            lblErrorAddress.setText("* Please fill out this field");
        } else if (tfphone.getText().trim().isEmpty()) {
            lblErrorPhone.setText("* Please fill out this field");
        } else if (tfemail.getText().trim().isEmpty()) {
            lblErrorEmail.setText("* Please fill out this field");
        }
        if (ae.getSource() == back) {
            setVisible(false);
        } else if (tfnumber.getText().trim().isEmpty() || tfaddress.getText().trim().isEmpty() || tfphone.getText().trim().isEmpty() || tfemail.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are necessary", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            if (ae.getSource() == add) {
                String username = labelusername.getText();
                String id = comboid.getSelectedItem().toString();
                String number = tfnumber.getText();
                String name = labelname.getText();
                String gender = tfgender.getText();
                String country = cmbcountry.getSelectedItem().toString();
                String address = tfaddress.getText();
                String phone = tfphone.getText();
                String email = tfemail.getText();

                try {
                    Conn c = new Conn();
                    //String query = "update customer set username = '" + username + "', id = '" + id + "', number = '" + number + "', name = '" + name + "', gender = '" + gender + "', country = '" + country + "', address = '" + address + "', phone = '" + phone + "', email = '" + email + "'";
                    String query = "update customer set id = '" + id + "', number = '" + number + "', name = '" + name + "', gender = '" + gender + "', country = '" + country + "', address = '" + address + "', phone = '" + phone + "', email = '" + email + "' where username = '" + username + "'";
                    c.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Customer Details Updated Successfully");

                    setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new UpdateCustomer("Mohan");
    }
}
