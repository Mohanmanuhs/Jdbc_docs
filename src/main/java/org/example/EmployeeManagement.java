package org.example;

import java.sql.*;

public class EmployeeManagement {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mohan";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "root";
    private static Connection connection;
    private static PreparedStatement preparedStatement;

    public static void main(String[] args) {
        try {
            connection = DriverManager.getConnection(JDBC_URL, USER_NAME, PASSWORD);
            createEmployeeManagementTable();
            insertDataIntoDb("mohan",20,"mohanmanuhs");
            insertDataIntoDb("rohan",10,"rohanmanuhs");
            getData();
        }catch (SQLException ignored){

        }

    }

    private static void getData() throws SQLException {
        String getEmployee = "SELECT * FROM Employee";
        preparedStatement=connection.prepareStatement(getEmployee);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println("name: " + resultSet.getString(2));
            System.out.println("age: " + resultSet.getInt(3));
            System.out.println("email: "+ resultSet.getString(4));
        }
    }
    private static void insertDataIntoDb(String name, int age, String email)
            throws SQLException {
        String insertSQL = "INSERT INTO Employee (name,age,email) VALUES (? , ?, ?)";
        preparedStatement = connection.prepareStatement(insertSQL);
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, age);
        preparedStatement.setString(3, email);
        preparedStatement.executeUpdate();

        System.out.println("Data Inserted ....");

    }
    public static void createEmployeeManagementTable() throws SQLException {
        String createTable="CREATE TABLE IF NOT EXISTS Employee ( id INT AUTO_INCREMENT PRIMARY KEY," +
        " name VARCHAR(100) ,"
                +"age INT ,"
                +"email VARCHAR(100)"
                +")";

        preparedStatement = connection.prepareStatement(createTable);
        preparedStatement.execute();
        System.out.println("Table created ....");
    }
}
