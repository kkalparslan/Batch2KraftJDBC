package com.kraft.test;

import java.sql.*;

public class Jdbc_1 {
    public static void main(String[] args) {

        String dbUrl="jdbc:sqlserver://94.73.150.3:1433;DatabaseName=u0583688_vlk;" +
                "encrypt=true;trustServerCertificate=true;";
        String dbUserName="u0583688_vlk";
        String dbPassword="VolkanAntalya159*";
        String query="SELECT * FROM EmployeesEren";

        try {
            // create connection
            Connection connection= DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
            // create statement object
            Statement statement= connection.createStatement();
            // run query and get the result in resltSet object
            ResultSet resultSet= statement.executeQuery(query);
            System.out.println("connection success");

            /**
             * normalde resultset default olarak sütun satırına işaret etmektedir
             * aşağıya inmek için resultSet().next() methodu kullanılır
             */
            resultSet.next();

            /**
             * move pointer to the first row
             * sütun sayıları 1'den başlar
             * ilgili sütuna index number ile ulaşma
             */
            System.out.println("resultSet.getString(1) = " + resultSet.getString(1));
            System.out.println("resultSet.getString(2) = " + resultSet.getString(2));
            System.out.println("resultSet.getString(3) = " + resultSet.getString(3));
            System.out.println("-----------------------------------");

            //move pointer second row
            resultSet.next();
            System.out.println("resultSet.getString(1) = " + resultSet.getString(1));
            System.out.println("resultSet.getString(2) = " + resultSet.getString(2));
            System.out.println("resultSet.getString(3) = " + resultSet.getString(3));
            System.out.println("-----------------------------------");

            //move pointer third row
            //ilgili sütuna sütun adı ile ulaşma
            resultSet.next();
            System.out.println("resultSet.getString(\"email\") = " + resultSet.getString("email"));

            //close the instance
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
