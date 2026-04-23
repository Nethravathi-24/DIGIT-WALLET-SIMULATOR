package Digitalwalletsimulator;

import javax.swing.*;
import java.sql.*;

public class AddMoney extends JFrame {

    JTextField id, amt;

    public AddMoney() {

        setTitle("Add Money");
        setSize(300,250);
        setLayout(null);

        JLabel l1 = new JLabel("User ID:");
        l1.setBounds(30,30,80,25);
        add(l1);

        id = new JTextField();
        id.setBounds(100,30,120,25);
        add(id);

        JLabel l2 = new JLabel("Amount:");
        l2.setBounds(30,70,80,25);
        add(l2);

        amt = new JTextField();
        amt.setBounds(100,70,120,25);
        add(amt);

        JButton btn = new JButton("Add");
        btn.setBounds(80,120,120,30);
        add(btn);

        btn.addActionListener(e -> addMoney());

        setVisible(true);
    }

    void addMoney() {
        try (Connection con = DBConnection.getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                "UPDATE users SET balance=balance+? WHERE id=?"
            );
            ps.setDouble(1, Double.parseDouble(amt.getText()));
            ps.setInt(2, Integer.parseInt(id.getText()));
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this,"Money Added");
            
            id.setText("");
            amt.setText("");
            
            
            

       } catch(Exception e) {
            e.printStackTrace();
        }
    }
}