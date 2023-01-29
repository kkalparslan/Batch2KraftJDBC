package com.kraft.test;

import org.testng.annotations.Test;

import java.sql.*;

public class Jdbc_3 {

    @Test
    public void someMethodForMovingCursor() throws SQLException {
        String dbUrl = "jdbc:sqlserver://94.73.150.3:1433;DatabaseName=u0583688_vlk;" +
                "encrypt=true;trustServerCertificate=true;";
        String dbUserName = "u0583688_vlk";
        String dbPassword = "VolkanAntalya159*";
        String query = "SELECT firstName, lastName FROM EmployeesEren";


        // create connection
        Connection connection = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
        // create statement object
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        // run query and get the result in resltSet object
        ResultSet resultSet = statement.executeQuery(query);
        resultSet.next();
        resultSet.next();

        // hangi satırdayım
        System.out.println("resultSet.getRow() = " + resultSet.getRow());

        // kaç satır olduğunu nasıl öğreneceğim
        resultSet.last();
        System.out.println("resultSet.getRow() = " + resultSet.getRow());

        // bir önceki satıra nasıl gideceğim
        resultSet.previous();
        System.out.println("resultSet.getRow() = " + resultSet.getRow());

        // sütun isimlerinin olduğu satıra gitme (beforeFirst)
        resultSet.beforeFirst();
        System.out.println("resultSet.getRow() = " + resultSet.getRow());

        // istenilen satıra gitme
        resultSet.absolute(10);
        System.out.println("resultSet.getRow() = " + resultSet.getRow());

        //close the instance
        resultSet.close();
        statement.close();
        connection.close();

    }

    @Test
    public void dataBaseMetaDataExampler() throws SQLException {
        String dbUrl = "jdbc:sqlserver://94.73.150.3:1433;DatabaseName=u0583688_vlk;" +
                "encrypt=true;trustServerCertificate=true;";
        String dbUserName = "u0583688_vlk";
        String dbPassword = "VolkanAntalya159*";
        String query = "SELECT firstName, lastName FROM EmployeesEren";


        // create connection
        Connection connection = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
        // create statement object
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        // run query and get the result in resltSet object
        ResultSet resultSet = statement.executeQuery(query);
        resultSet.next();
        resultSet.next();

        // kullandığımız toolun genel bilgileri için çok önemli değil just bilgi
        DatabaseMetaData databaseMetaData = connection.getMetaData();
        System.out.println("databaseMetaData.getUserName() = " + databaseMetaData.getUserName());
        System.out.println("databaseMetaData.getDatabaseProductName() = " + databaseMetaData.getDatabaseProductName());
        System.out.println("databaseMetaData.getDatabaseProductVersion() = " + databaseMetaData.getDatabaseProductVersion());
        System.out.println("databaseMetaData.getDriverName() = " + databaseMetaData.getDriverName());
        System.out.println("databaseMetaData.getDriverMajorVersion() = " + databaseMetaData.getDriverMajorVersion());

        //close the instance
        resultSet.close();
        statement.close();
        connection.close();

    }

    @Test
    public void resultSetMetaData() throws SQLException {
        String dbUrl = "jdbc:sqlserver://94.73.150.3:1433;DatabaseName=u0583688_vlk;" +
                "encrypt=true;trustServerCertificate=true;";
        String dbUserName = "u0583688_vlk";
        String dbPassword = "VolkanAntalya159*";
        String query = "SELECT * FROM EmployeesEren";

        // create connection
        Connection connection = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
        // create statement object
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        // run query and get the result in resltSet object
        ResultSet resultSet = statement.executeQuery(query);

        ResultSetMetaData resultSetMetaData=resultSet.getMetaData();

        // kaç sütun var
        int columnCount = resultSetMetaData.getColumnCount();
        System.out.println("columnCount = " + columnCount);

        // sütun isimleri
        String columnName = resultSetMetaData.getColumnName(5);
        System.out.println("columnName = " + columnName);

        // bütün sütun isimlerini dinamik olarak getir
        for (int i = 1; i <=columnCount ; i++) {
            System.out.println(i+ ": "+resultSetMetaData.getColumnName(i));
        }

        //close the instance
        resultSet.close();
        statement.close();
        connection.close();
    }
}
