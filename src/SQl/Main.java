package SQl;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            Task task = new Task();
            task.createTable();
            task.Insert();
            task.select();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
