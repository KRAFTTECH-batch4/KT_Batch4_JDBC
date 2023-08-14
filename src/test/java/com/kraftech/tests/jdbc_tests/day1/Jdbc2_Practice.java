package com.kraftech.tests.jdbc_tests.day1;

import java.sql.*;

public class Jdbc2_Practice {

    public static void main(String[] args) throws SQLException {
        String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
        String dbUsername = "postgres";
        String dbPassword = "1234";

        Connection connection = DriverManager.getConnection(dbUrl, dbUsername,dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet= statement.executeQuery("select * from locations");

        //get the locationId, streetAddress and postcode of first row
        resultSet.next();
        String locationIdOfFirstRow = resultSet.getString("locationId");
        String streetAddressOfFirstRow = resultSet.getString("streetAddress");
        String postCodeOfFirstRow = resultSet.getString(3);
        System.out.println("locationIdOfFirstRow = " + locationIdOfFirstRow);
        System.out.println("streetAddressOfFirstRow = " + streetAddressOfFirstRow);
        System.out.println("postCodeOfFirstRow = " + postCodeOfFirstRow);

        System.out.println("");

        //get the locationId, streetAddress, city and region of second row
        resultSet.next();
        String locationIdOfSecondRow = resultSet.getString(1);
        String streetAddressOfSecondRow = resultSet.getString(2);
        String cityOfSecondRow = resultSet.getString(4);
        String regionOfSecondRow = resultSet.getString(5);
        System.out.println("locationIdOfSecondRow = " + locationIdOfSecondRow);
        System.out.println("streetAddressOfSecondRow = " + streetAddressOfSecondRow);
        System.out.println("cityOfSecondRow = " + cityOfSecondRow);
        System.out.println("regionOfSecondRow = " + regionOfSecondRow);

        System.out.println("");

        //get all information of 5th row
        resultSet.next();
        resultSet.next();
        resultSet.next();
        for(int i = 1; i <= 6; i++){
            System.out.println(i + " - " + resultSet.getString(i));
        }

        System.out.println("");

        //get the region of last row
        resultSet.next();
        resultSet.next();
        resultSet.next();
        System.out.println("resultSet.getString(\"region\") = " + resultSet.getString("region"));


        resultSet.close();
        statement.close();
        connection.close();
    }
}
