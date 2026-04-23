package Digitalwalletsimulator;

import javax.swing.*;
import java.sql.*;

public class CreateAccount extends JFrame {

    JTextField name;

    public CreateAccount() {

        setTitle("Create Account");
        setSize(300,200);
        setLayout(null);

        JLabel l1 = new JLabel("Name:");
        l1.setBounds(30,30,80,25);
        add(l1);

        name = new JTextField();
        name.setBounds(100,30,120,25);
        add(name);

        JButton btn = new JButton("Create");
        btn.setBounds(80,80,120,30);
        add(btn);

        btn.addActionListener(e -> create());

        setVisible(true);
    }

    void create() {
        try (Connection con = DBConnection.getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO users(name,balance) VALUES (?,0)"
            );
            ps.setString(1, name.getText());
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this,"Account Created");
            name.setText("");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}