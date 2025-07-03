# 🧑‍💼 Java JDBC – Employee Database App
A console-based CRUD application built using **Java and JDBC** to manage employee records stored in a **MySQL database**. This project demonstrates database connectivity, object-oriented programming, and command-line user interaction.

## 🚀 Features
✅ Add new employees  
✅ View employee by ID  
✅ View all employees  
✅ Update employee details  
✅ Delete employee from database  
✅ Builder pattern used for object creation  
✅ Clean modular architecture (DB, Service, Model)

## 🧰 Technologies Used
- **Java 17**
- **JDBC (Java Database Connectivity)**
- **MySQL 8+**
- **MySQL JDBC Driver (`mysql-connector-j-8.0.33.jar`)**
- **VS Code**


## 📂 Project Structure
```bash
java-jdbc-employee-db-app/
├── db/
│   ├── DBConnectionInterface.java     # Interface for DB operations
│   └── saveToMysql.java               # JDBC implementation
├── model/
│   └── Employe.java                   # Employee POJO using Builder pattern
├── service/
│   └── EmpService.java                # User-facing logic (menu, inputs)
├── lib/
│   └── mysql-connector-java-8.0.33.jar  # JDBC Driver (not required in repo)
├── Main.java                          # Entry point
├── README.md                          # This file

```

## 🗃️ Database Setup
Ensure MySQL is installed and running.

🛠️ Step 1: Create database and table
```
CREATE DATABASE employee_db;

USE employee_db;

CREATE TABLE employees (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100),
  designation VARCHAR(100),
  salary DOUBLE
);
```

## 🖥️ How to Run
✅ Step 1: Download MySQL JDBC Driver
Download mysql-connector-java-8.0.33.jar from:
🔗 https://dev.mysql.com/downloads/connector/j/

Place it inside a lib/ folder in your project root.

✅ Step 2: Compile the Code
```
javac -cp ".;lib/mysql-connector-java-8.0.33.jar" db/*.java model/*.java service/*.java Main.java
```
✅ Step 3: Run the App
```
java -cp ".;lib/mysql-connector-java-8.0.33.jar" Main
```

## 🧑 Sample Console Menu
Employee Database Application

Press '1':ADD  
      '2':SEARCH EMPLOYE  
      '3':UPDATE  
      '4':DELETE  
      '5':'VIEW ALL EMPLOYES'  
      '0':Exit
