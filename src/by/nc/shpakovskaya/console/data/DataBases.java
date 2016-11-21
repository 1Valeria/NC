package by.nc.shpakovskaya.console.data;


import java.sql.*;
import java.util.*;

/**
 * Created by Valeria on 04.11.2016.
 */
public class DataBases {

    public static Map<String, String> adminData = new HashMap<>();
    public static Map<String, String> doctorsData = new HashMap<>();
    public static Map<String, String> nursesData = new HashMap<>();
    public static Map<String, String> patientsData = new HashMap<>();

//    private static List<Admin> adminList = new ArrayList<>();
  //  public static List<DoctorRole> doctorList = new ArrayList<>();
//    private static List<Admin> adminList = new ArrayList<>();
//    private static List<Admin> adminList = new ArrayList<>();

    // JDBC URL, username and password of MySQL server
    private static final String url = "jdbc:mysql://localhost:3306/myhospital";
    private static final String user = "root";
    private static final String password = "1234";

    // JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public static void initialize(){

//        adminList.add(new Admin("Real Name", "admin", "admin123"));
//
//        for (int i = 0; i < adminList.size(); i++){
//            adminData.put(adminList.get(i).getLogin(), adminList.get(i).getPassword());
//        }
//
//        doctorList.add(new DoctorRole("Derek Shepherd", "derek123", "password"));
//
//        for (int i = 0; i < doctorList.size(); i++){
//            doctorsData.put(doctorList.get(i).getLogin(), doctorList.get(i).getPassword());
//        }

    }

    public static void base() {

        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            rs = stmt.executeQuery("SELECT id, name  from hospital");

/* THIS BLOCK ARE WORKING

            int count = 0;
            while (rs.next()) {
                count = rs.getInt(1);
            }

            System.out.println("Enter the name of a new Hospital: ");
            stmt.executeUpdate("INSERT INTO myhospital.hospital (id, name) \n" +
                    " VALUES (" + (count + 1) + ", '" + new Scanner(System.in).nextLine() + "');");

            System.out.println("count: " + count);
            System.out.println("Hospitals from database: ");

            rs = stmt.executeQuery("SELECT id, name  from hospital");
            while (rs.next()) {
                System.out.println("id: " + rs.getInt(1) + " name: " + rs.getString(2));
            }
*/

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try {
                con.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                rs.close();
            } catch (SQLException se) { /*can't do anything */ }
        }
    }
}

