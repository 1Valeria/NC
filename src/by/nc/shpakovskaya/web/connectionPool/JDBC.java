package by.nc.shpakovskaya.web.connectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Valeria on 02.12.2016.
 */
public class JDBC {

//    private static final Logger log = Logger.getLogger(JDBC.class);

    private static final String driver = "com.mysql.jdbc.Driver";
    public Connection connection = null;
    private static final String url = "jdbc:mysql://localhost:3306/cracker?useEncoding=yes&amp;characterEncoding=UTF-8";
    private static final String name = "root";
    private static final String password = "1234";

    public JDBC() {
        try {
            Class.forName(driver);
        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            log.error(e.getMessage());
        }
    }

    public Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, name, password);
            } catch (SQLException e) {
//                log.error(e.getMessage());
            }
        }
        return connection;
    }
}
