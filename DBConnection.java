package Digitalwalletsimulator;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/wallet_db",
                "root",
                "1234"   // change if needed
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}