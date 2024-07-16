package org.example;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class App 
{
    /*JDBC DBURL of different database*/
    /*Oracle:
    jdbc:oracle:thin:myuser/mypassword@myhost:1521:myDB

    MySQL
    jdbc:mysql://myhost:3306/myDB?user=myuser&password=mypassword

    MS-SQL
    jdbc:microsoft:sqlserver://myhost:1433;DatabaseName=myDB;user=myuser;password=mypassword
    */


    /*Methods to create jdbc connection
     1)
     String dburl = "jdbc:mysql://localhost:3306/myDB?user=root&password=root";
     Connection con = DriverManager.getConnection(dburl) throws SQLException;

     2)
     String dburl = "jdbc:mysql://localhost:3306/myDB";
     String user = "root";
     String password = "root";
     Connection con = DriverManager.getConnection(dburl, user,password) throws SQLException;
    */


    /*There are 2 different types of JDBC statements
        1. java.sql.Statement
        2. java.sql.PreparedStatement

        1. java.sql.Statement
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from student");
        2. java.sql.PreparedStatement
            String insertSQL = "INSERT INTO Employee (name,age,email) VALUES (? , ?, ?)";
            preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setString(3, email);
            preparedStatement.executeUpdate();
    */

    public static void main( String[] args ) {
        String url = "jdbc:mysql://127.0.0.1:3306/mohan?user=root&password=root";
        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from student");
            while(resultSet.next()) {
                System.out.println("Student name : " + resultSet.getString(2));
                System.out.println("Student password : " + resultSet.getInt(1));
            }
            resultSet.close();
        } catch (SQLException ignored) {

        }
    }
}
