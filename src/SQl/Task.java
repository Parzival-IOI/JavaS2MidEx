package SQl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Task {
    public Connection connection;
    public Task() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Parzival","root", "1234");
        System.out.println("connection established");
    }

    public void createTable() throws SQLException {
        String query = "Create table Product(id int primary key, name varchar(50), price_per_unit double, active_for_sell boolean)";

        Statement statement = connection.createStatement();
        statement.execute(query);
        System.out.println("successfully create database!");
    }

    public void Insert() throws SQLException {
        String query = "select * from Product";
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

        ResultSet resultSet = statement.executeQuery(query);

        this.InsertResultSet(resultSet, 1, "coke", 2.00, true);
        this.InsertResultSet(resultSet, 2, "pepsi", 2.00, true);
        this.InsertResultSet(resultSet, 3, "kizz", 1.50, true);
        this.InsertResultSet(resultSet, 4, "Redbull", 2.00, false);

        System.out.println("successfully");
    }

    private void InsertResultSet(ResultSet resultSet, int id , String name, double pricePerUnit, boolean activeForSell) throws SQLException {
        resultSet.moveToInsertRow();
        resultSet.updateInt("id", id);
        resultSet.updateString("name", name);
        resultSet.updateDouble("price_per_unit", pricePerUnit);
        resultSet.updateBoolean("active_for_sell", activeForSell);
        resultSet.insertRow();
    }

    public void select() throws SQLException {
        String query = "select * from Product";
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            System.out.println("Id : " + resultSet.getInt("id"));
            System.out.println("Name : " + resultSet.getString("name"));
            System.out.println("Price Per Unit : " + resultSet.getDouble("price_per_unit"));
            System.out.println("Active For Sell : " + resultSet.getBoolean("active_for_sell"));
        }
    }
}
