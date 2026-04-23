package Digitalwalletsimulator;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {

    public MainMenu() {

        setTitle("Digital Wallet");
        setSize(400, 400);
        setLayout(new GridLayout(6,1));

        JButton b1 = new JButton("Create Account");
        JButton b2 = new JButton("Add Money");
        JButton b3 = new JButton("Send Money");
        JButton b4 = new JButton("Check Balance");
        JButton b5 = new JButton("View Transactions");

        add(b1); add(b2); add(b3); add(b4); add(b5);

        b1.addActionListener(e -> new CreateAccount());
        b2.addActionListener(e -> new AddMoney());
        b3.addActionListener(e -> new SendMoney());
        b4.addActionListener(e -> new CheckBalance());
        b5.addActionListener(e -> new ViewTransactions());

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainMenu();
    }
}