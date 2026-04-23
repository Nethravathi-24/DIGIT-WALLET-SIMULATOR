# 💳 Digital Wallet Simulator

A Java-based desktop application that simulates basic digital wallet operations using **Swing**, **JDBC**, and **MySQL**. This project provides a simple GUI to manage user accounts, perform transactions, and view transaction history.

---

## 🚀 Features

* 👤 Create Wallet Account
* 💰 Add Money to Wallet
* 🔁 Send Money Between Users
* 📊 Check Account Balance
* 📜 View Transaction History (Table Format using JTable)

---

## 🛠️ Technologies Used

* Java (Swing for GUI)
* JDBC (Database Connectivity)
* MySQL (Database)
* Eclipse IDE
* Git & GitHub

---

## 🗄️ Database Setup

Run the following SQL queries in MySQL:

```sql
CREATE DATABASE wallet_db;

USE wallet_db;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    balance DOUBLE
);

CREATE TABLE transactions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    sender_id INT,
    receiver_id INT,
    amount DOUBLE,
    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

---

## ⚙️ Project Setup (Eclipse)

1. Open Eclipse → Create New Java Project
2. Create a package (e.g., `Digitalwalletsimulator`)
3. Add all Java files to the package
4. Download MySQL Connector JAR
5. Add JAR:

   * Right-click project → Build Path → Configure Build Path
   * Libraries → Add External JARs → Select connector

---

## 🔌 Database Connection

Update your database credentials in `DBConnection.java`:

```java
return DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/wallet_db?useSSL=false&allowPublicKeyRetrieval=true",
    "root",
    "your_password"
);
```

---

## ▶️ How to Run

* Run `MainMenu.java`
* Use buttons to perform wallet operations

---

## 📂 Project Structure

```
DigitalWallet/
│
├── DBConnection.java
├── MainMenu.java
├── CreateAccount.java
├── AddMoney.java
├── SendMoney.java
├── CheckBalance.java
├── ViewTransactions.java
```

---

## 🎯 Purpose

This project demonstrates:

* Java GUI development using Swing
* Database connectivity using JDBC
* Basic financial transaction logic

It is suitable for **academic mini-projects** and learning purposes.

---

## 📸 Future Enhancements

* 🔐 Login System
* 📊 Dashboard UI
* 🔍 Search & Filter Transactions
* 💳 ATM-style Interface
* 📈 Reports & Analytics

---
