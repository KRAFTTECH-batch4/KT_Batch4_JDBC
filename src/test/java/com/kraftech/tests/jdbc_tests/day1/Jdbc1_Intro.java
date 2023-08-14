package com.kraftech.tests.jdbc_tests.day1;

import java.sql.*;

public class Jdbc1_Intro {

    public static void main(String[] args) throws SQLException {
        String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
        String dbUsername = "postgres";
        String dbPassword = "1234";

        //create connection
        Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        //create a statement object
        Statement statement = connection.createStatement();
        //run query and get the result in result set object
        ResultSet resultSet = statement.executeQuery("select * from employees");

        //move pointer to the next row
        resultSet.next();
        //getting the information by column name
        System.out.println("resultSet.getString(\"employeeId\") = " + resultSet.getString("employeeId"));
        System.out.println("resultSet.getString(\"firstName\") = " + resultSet.getString("firstName"));

        //getting the information by index number
        System.out.println("resultSet.getString(3) = " + resultSet.getString(3));
        System.out.println("resultSet.getString(4) = " + resultSet.getString(4));

        System.out.println("");

        //move pointer to the 2nd row
        resultSet.next();
        //get the phonenumber by column name
        System.out.println("resultSet.getString(\"phonenumber\") = " + resultSet.getString("phonenumber"));
        //get the phonenumber by index number
        System.out.println("resultSet.getString(5) = " + resultSet.getString(5));

        System.out.println("");

        //get all employeeId, firstname and lastname in one shot (starting with 3rd row)
        while (resultSet.next()){
            System.out.println(
                    resultSet.getString("employeeId")
                    + " - "
                    + resultSet.getString("firstName")
                    + " - "
                    + resultSet.getString("lastName")
            );
        }


        resultSet.close();
        statement.close();
        connection.close();
    }

}
