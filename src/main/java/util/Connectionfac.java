package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectionfac {
 private static Connection con=null;
public static Connection getConnection() {
    try {
        Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e)
    {
        e.printStackTrace();
    }

    if (con == null) {
        String url = "jdbc:mysql://localhost:3306/Reimburse";
        String username = "root";
        String password = System.getenv("MYVAR");
        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("CONNECTION NOT ESTABLISHED");
        }

    }

    return con;
}
}
