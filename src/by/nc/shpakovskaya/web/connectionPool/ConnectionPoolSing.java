package by.nc.shpakovskaya.web.connectionPool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;

/**
 * Created by Valeria on 25.11.2016.
 */
public class ConnectionPoolSing {

    private static String url;
    private static Vector<Connection> availableConns = new Vector<Connection>();
    private static Vector<Connection> usedConns = new Vector<Connection>();

    private static JDBC jdbc = new JDBC();

    private static Connection getConnection() {
        return jdbc.getConnection();
    }

    public static synchronized Connection retrieve() throws SQLException {

        Connection newConn = null;
        if (availableConns.size() == 0) {
            newConn = getConnection();
        } else {
            newConn = (Connection) availableConns.lastElement();
            availableConns.removeElement(newConn);
        }
        usedConns.addElement(newConn);
        return newConn;
    }

    public static synchronized void putBack(Connection c) throws NullPointerException {
        if (c != null) {
            if (usedConns.removeElement(c)) {
                availableConns.addElement(c);
            } else {
                throw new NullPointerException("Error connection");
            }
        }
    }

    public int getAvailableConnsCnt() {
        return availableConns.size();
    }
}