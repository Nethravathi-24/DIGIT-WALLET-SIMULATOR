package Digitalwalletsimulator;

import javax.swing.*;
import java.sql.*;

public class SendMoney extends JFrame {

    JTextField s, r, amt;

    public SendMoney() {

        setTitle("Send Money");
        setSize(300,300);
        setLayout(null);

        JLabel l1 = new JLabel("Sender ID:");
        l1.setBounds(30,30,100,25);
        add(l1);

        s = new JTextField();
        s.setBounds(130,30,120,25);
        add(s);

        JLabel l2 = new JLabel("Receiver ID:");
        l2.setBounds(30,70,100,25);
        add(l2);

        r = new JTextField();
        r.setBounds(130,70,120,25);
        add(r);

        JLabel l3 = new JLabel("Amount:");
        l3.setBounds(30,110,100,25);
        add(l3);

        amt = new JTextField();
        amt.setBounds(130,110,120,25);
        add(amt);

        JButton btn = new JButton("Send");
        btn.setBounds(80,170,120,30);
        add(btn);

        btn.addActionListener(e -> send());

        setVisible(true);
    }

    void send() {
        try (Connection con = DBConnection.getConnection()) {

            con.setAutoCommit(false);

            int sender = Integer.parseInt(s.getText());
            int receiver = Integer.parseInt(r.getText());
            double amount = Double.parseDouble(amt.getText());

            PreparedStatement p1 = con.prepareStatement(
                "UPDATE users SET balance=balance-? WHERE id=?"
            );
            p1.setDouble(1, amount);
            p1.setInt(2, sender);

            PreparedStatement p2 = con.prepareStatement(
                "UPDATE users SET balance=balance+? WHERE id=?"
            );
            p2.setDouble(1, amount);
            p2.setInt(2, receiver);

            PreparedStatement p3 = con.prepareStatement(
                "INSERT INTO transactions(sender_id,receiver_id,amount) VALUES (?,?,?)"
            );
            p3.setInt(1, sender);
            p3.setInt(2, receiver);
            p3.setDouble(3, amount);

            p1.executeUpdate();
            p2.executeUpdate();
            p3.executeUpdate();

            con.commit();

            JOptionPane.showMessageDialog(this,"Transaction Successful");
            amt.setText("");
            s.setText("");
            r.setText("");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}