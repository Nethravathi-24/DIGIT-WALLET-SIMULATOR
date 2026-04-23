package Digitalwalletsimulator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class ViewTransactions extends JFrame {

    JTable table;
    DefaultTableModel model;

    public ViewTransactions() {

        setTitle("View Transactions");
        setSize(600, 400);

        // Column Names
        String[] columns = {"ID", "Sender ID", "Receiver ID", "Amount", "Date"};

        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);

        JScrollPane scroll = new JScrollPane(table);
        add(scroll);

        loadData();

        setVisible(true);
    }

    void loadData() {
        try (Connection con = DBConnection.getConnection()) {

            String query = "SELECT * FROM transactions";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            // Clear old data
            model.setRowCount(0);

            while (rs.next()) {
                Object[] row = {
                        rs.getInt("id"),
                        rs.getInt("sender_id"),
                        rs.getInt("receiver_id"),
                        rs.getDouble("amount"),
                        rs.getTimestamp("date")
                };

                model.addRow(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}