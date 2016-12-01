package by.nc.shpakovskaya.dao.client;

import by.nc.shpakovskaya.beans.roles.users.client.Client;
import by.nc.shpakovskaya.dao.CommonDAO;
import by.nc.shpakovskaya.web.connectionPool.ConnectionPoolSing;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valeria on 14.11.2016.
 */
public class ClientDAO implements CommonDAO<Client> {
    static final String SQL_QUERY_ADD_CLIENT = "INSERT INTO clients (name, surname, email, login, password, admit)"+
            " VALUES (?,?,?,?,?,?)";
    static final String SQL_QUERY_GET_CLIENTS = "SELECT * FROM clients";
    static final String SQL_QUERY_UPDATE_CLIENTS_YES = "UPDATE clients SET admit='yes' WHERE id=";
    static final String SQL_QUERY_UPDATE_CLIENTS_NO = "UPDATE clients SET admit='no' WHERE id=";

    public void add(Client client) {
        Connection connection = null;
        PreparedStatement preparedStatement;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = ConnectionPoolSing.retrieve();
            preparedStatement = connection.prepareStatement(SQL_QUERY_ADD_CLIENT);
            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getSurname());
            preparedStatement.setString(3, client.getEmail());
            preparedStatement.setString(4, client.getLogin());
            preparedStatement.setString(5, client.getPassword());
            preparedStatement.setString(6, client.getAdmit());
            preparedStatement.executeUpdate();

        } catch (ClassNotFoundException e) {
            System.out.println("Class driver not found");
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQL exception occurred during add client");
            System.out.println(e.getMessage());
        } finally {
            ConnectionPoolSing.putBack(connection);
        }
    }

    @Override
    public List<Client> get() {
        Connection connection = null;
        Statement statement;
        ResultSet resultSet;
        List<Client> clients = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = ConnectionPoolSing.retrieve();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_QUERY_GET_CLIENTS);
            clients = init(resultSet);

        } catch (ClassNotFoundException e) {
            System.out.println("Class driver not found");

        } catch (SQLException e) {
            System.out.println("SQL exception occurred during add client");
            System.out.println(e.getMessage());

        } finally {
            ConnectionPoolSing.putBack(connection);
        }
        return clients;
    }

    @Override
    public List<Client> init(ResultSet resultSet) throws SQLException {
        List<Client> clients = new ArrayList<>();
        while (resultSet.next()) {
            Client client = new Client();
            client.setId(resultSet.getInt(1));
            client.setName(resultSet.getString(2));
            client.setSurname(resultSet.getString(3));
            client.setEmail(resultSet.getString(4));
            client.setLogin(resultSet.getString(5));
            client.setPassword(resultSet.getString(6));
            client.setAdmit(resultSet.getString(7));
            clients.add(client);
        }
        return clients;
    }

    public void update(boolean flag, int id){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = ConnectionPoolSing.retrieve();
            statement = connection.createStatement();
            if (flag) {
                statement.executeUpdate(SQL_QUERY_UPDATE_CLIENTS_YES + id);
            } else {
                statement.executeUpdate(SQL_QUERY_UPDATE_CLIENTS_NO + id);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Class driver not found");

        } catch (SQLException e) {
            System.out.println("SQL exception occurred during update client");
            System.out.println(e.getMessage());

        } finally {
            ConnectionPoolSing.putBack(connection);
        }
    }

}
