# JDBC (Java database connectivity)

* It is an Api helps to initialize connection between java program and database.

* It is independent of any RDBMS means we can use it on any RDBMS
---

## Necessary Steps to work with JDBC
    1. Load the Driver 
    2. Get the DB connection via Driver 
    3. Issue SL queries via Connection 
    4. Process the results returned by SQL Queries 
    5. Close all the JDBC objects
---
## Driver
* Driver is used to interact with RDBMS application.

## Dependecies of some Drivers :-
    1. for Oracle driver
    <dependency>
      <groupId>com.oracle.database.jdbc</groupId>
      <artifactId>ojdbc8</artifactId>
      <version>23.4.0.24.05</version>
    </dependency>

    2. for postgresql driver
    <dependency>
      <groupId>org.postgresql</groupId>
      <artifactId>postgresql</artifactId>
      <version>42.7.3</version>
    </dependency>

    3. for SQL Server driver
    <dependency>
      <groupId>com.microsoft.sqlserver</groupId>
      <artifactId>mssql-jdbc</artifactId>
      <version>12.6.3</version>
    </dependency>
---

## DataBase URL :-
* Structure of URL :-
        <protocol>:<sub-protocol>:<sub-name> 

    * protocal = jdbc
    * sub-protocol = which db?
    * sub-name = consists of host name,port,pass,username
---
## JDBC DBURL of different database
    Oracle: jdbc:oracle:thin:myuser/mypassword@myhost:1521:myDB 
    MySQL: jdbc:mysql://myhost:3306/myDB?user=myuser&password=mypassword 
    MS-SQL: jdbc:microsoft:sqlserver://myhost:1433;DatabaseName=myDB;user=myuser;password=mypassword

---
## Screenshots

![Screenshot (2519)](https://github.com/user-attachments/assets/070debb7-1f76-4f66-9d73-4de5fbcbbce5)

---

## JDBC statements
* 2 types
    ##### 1. createStatement() 
    ##### 2. prepareStatement()

    ## 1. createStatement()
        Example :-  
        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from table_name");
    ---
    
    ## 2. prepareStatement()
        Example :-  
        Connection connection = DriverManager.getConnection(url);
        String insertSQL = "INSERT INTO Employee (name,age,email) VALUES (? , ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, age);
        preparedStatement.setString(3, email);
        preparedStatement.executeUpdate();
    ---

## Using ResultSet :-

        while(resultSet.next()) {
            System.out.println("Student name : " + resultSet.getString(column_no or name));
            System.out.println("Student password : " + resultSet.getInt(column_no or name);
        }

## Final step :-
* close the connection in finally block.

        connection.close(); 


## 🔗 Links
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/mohan-h-s-6511a0254/)
[![twitter](https://img.shields.io/badge/twitter-1DA1F2?style=for-the-badge&logo=twitter&logoColor=white)](https://x.com/Mohan97743799)


## Feedback

If you have any feedback, please reach out to us at mohanmanuhs9@gmail.com

