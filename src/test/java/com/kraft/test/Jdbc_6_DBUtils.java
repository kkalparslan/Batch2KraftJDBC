package com.kraft.test;

import com.kraft.utilities.DBUtils;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class Jdbc_6_DBUtils {

    @Test
    public void test1(){

        DBUtils.createConnection();
        List<Map<String, Object>>queryResultMap= DBUtils.getQueryResultMap("SELECT * FROM EmployeesEren");
        System.out.println("queryResultMap = " + queryResultMap);

        DBUtils.destroy();

    }

    @Test
    public void test2(){
        DBUtils.createConnection();

        List<List<Object>> queryResultList = DBUtils.getQueryResultList("SELECT * FROM EmployeesEren");
        System.out.println("queryResultList = " + queryResultList);

        DBUtils.destroy();
    }


}
