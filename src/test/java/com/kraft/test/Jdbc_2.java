package com.kraft.test;

import java.sql.*;

public class Jdbc_2 {
    public static void main(String[] args) throws SQLException {

        String dbUrl = "jdbc:sqlserver://94.73.150.3:1433;DatabaseName=u0583688_vlk;" +
                "encrypt=true;trustServerCertificate=true;";
        String dbUserName = "u0583688_vlk";
        String dbPassword = "VolkanAntalya159*";
        String query = "SELECT firstName, lastName FROM EmployeesEren";


        // create connection
        Connection connection = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
        // create statement object
        Statement statement = connection.createStatement();
        // run query and get the result in resltSet object
        ResultSet resultSet = statement.executeQuery(query);

        // move first row
        resultSet.next();
        System.out.println(resultSet.getString(1));
        System.out.println(resultSet.getString("lastName"));
        System.out.println("---------------------------");

        /**
         * create a new query // yukarıdaki query ye bağımlı değiliz. birbirinden farklı olarak
         * tanımlanmış resultSet ler ile farklı query oluşturabiliyoruz.
         */
        ResultSet resultSet1=statement.executeQuery("select email from EmployeesEren");
        resultSet1.next();
        System.out.println(resultSet1.getString(1));

        // close instance
        resultSet.close();
        statement.close();
        connection.close();


    }
}
