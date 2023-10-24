package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
    private static String USER_NAME = "root";
    private static String USER_PASSWORD = "08112003";
    private static String URL = "jdbc:mysql://localhost:3306/magazine_shop?useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false";
    public static Connection openConnection() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        return DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD);
    }
}
