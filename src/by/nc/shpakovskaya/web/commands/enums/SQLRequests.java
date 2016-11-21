package by.nc.shpakovskaya.web.commands.enums;

/**
 * Created by Valeria on 15.11.2016.
 */
public class SQLRequests {
    public static final String SQL_QUERY_ADD_CLIENT = "INSERT INTO clients (name, surname, email, login, password)"+
            " VALUES (?,?,?,?,?)";
    public static final String SQL_QUERY_GET_CLIENTS = "SELECT * FROM clients";
}
