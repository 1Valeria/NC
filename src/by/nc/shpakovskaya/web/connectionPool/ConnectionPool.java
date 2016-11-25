//package by.nc.shpakovskaya.web.connectionPool;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.Vector;
//
//class ConnectionPool {
//    private Vector<Connection> availableConns = new Vector<Connection>();
//    private Vector<Connection> usedConns = new Vector<Connection>();
//    private String url;
//
//    public ConnectionPool(String url, String driver, int initConnCnt) {
//        try {
//            Class.forName(driver);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        this.url = url;
//        for (int i = 0; i < initConnCnt; i++) {
//            availableConns.addElement(getConnection());
//        }
//    }
//
//    private Connection getConnection() {
//        Connection conn = null;
//        try {
//            conn = DriverManager.getConnection(url);
//        } catch (Exception e) {
//            System.out.print(e.getMessage());
//        }
//        return conn;
//    }
//
//    public synchronized Connection retrieve() throws SQLException {
//        Connection newConn = null;
//        if (availableConns.size() == 0) {
//            newConn = getConnection();
//        } else {
//            newConn = (Connection) availableConns.lastElement();
//            availableConns.removeElement(newConn);
//        }
//        usedConns.addElement(newConn);
//        return newConn;
//    }
//
//    public synchronized void putback(Connection c) throws NullPointerException {
//        if (c != null) {
//            if (usedConns.removeElement(c)) {
//                availableConns.addElement(c);
//            } else {
//                throw new NullPointerException("Connection not in the usedConns array");
//            }
//        }
//    }
//
//    public int getAvailableConnsCnt() {
//        return availableConns.size();
//    }
//}