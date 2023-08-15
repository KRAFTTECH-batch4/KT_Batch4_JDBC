package com.kraftech.tests.jdbc_tests.day2;

import org.testng.annotations.Test;

import java.sql.*;

public class Jdbc1_MovingCursorOnTheTable {

    String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
    String dbUsername = "postgres";
    String dbPassword = "1234";

    @Test
    public void test1() throws SQLException {
        Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("select * from employees");

        //how to find how many rows we have
        resultSet.last();
        int rowCount = resultSet.getRow();
        System.out.println("rowCount = " + rowCount);

        System.out.println("");

        //how to go to first line
        resultSet.first();
        System.out.println("resultSet.getRow() = " + resultSet.getRow());

        System.out.println("");

        //how to get "Ahmet" firstname directly?
        resultSet.absolute(7);
        String firstNameOf7thRow = resultSet.getString("firstName");
        System.out.println("firstNameOf7thRow = " + firstNameOf7thRow);

        System.out.println("");

        //how to go 6th row
        resultSet.previous();
        System.out.println("resultSet.getRow() = " + resultSet.getRow());


        resultSet.close();
        statement.close();
        connection.close();
    }
}
