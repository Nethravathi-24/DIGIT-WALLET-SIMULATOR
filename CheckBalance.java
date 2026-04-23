package Digitalwalletsimulator;

import javax.swing.*;
import java.sql.*;

public class CheckBalance extends JFrame {

    JTextField id;

    public CheckBalance() {

        setTitle("Check Balance");
        setSize(300,200);
        setLayout(null);

        JLabel l1 = new JLabel("User ID:");
        l1.setBounds(30,30,80,25);
        add(l1);

        id = new JTextField();
        id.setBounds(100,30,120,25);
        add(id);

        JButton btn = new JButton("Check");
        btn.setBounds(80,80,120,30);
        add(btn);

        btn.addActionListener(e -> check());

        setVisible(true);
    }

    void check() {
        try (Connection con = DBConnection.getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                "SELECT balance FROM users WHERE id=?"
            );
            ps.setInt(1, Integer.parseInt(id.getText()));

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(this,
                        "Balance: " + rs.getDouble("balance"));
                id.setText("");
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}