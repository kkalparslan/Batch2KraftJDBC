package com.kraft.test;

import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Jdbc_5_DynamicList {

    String dbUrl="jdbc:sqlserver://94.73.150.3:1433;DatabaseName=u0583688_vlk;" +
            "encrypt=true;trustServerCertificate=true;";
    String dbUserName="u0583688_vlk";
    String dbPassword="VolkanAntalya159*";
    String query="SELECT * FROM EmployeesEren";

    @Test
    public void dynamicList() throws SQLException {

        //create connection
        Connection connection= DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
        Statement statement=connection.createStatement();
        ResultSet resultSet= statement.executeQuery(query);

        //reach number of column and name of columns
        ResultSetMetaData resultSetMetaData=resultSet.getMetaData();

        // create a list
        List<Map<String, Object>> list=new ArrayList<>();

        while (resultSet.next()){
            // some code here
            Map<String, Object>map=new HashMap<>();
            for (int i = 1; i <resultSetMetaData.getColumnCount()+1 ; i++) {
                map.put(resultSetMetaData.getColumnName(i), resultSet.getString(i));
            }
            list.add(map);
        }
        System.out.println("list = " + list);



         //close the connection
        resultSet.close();
        statement.close();
        connection.close();

    }
}
