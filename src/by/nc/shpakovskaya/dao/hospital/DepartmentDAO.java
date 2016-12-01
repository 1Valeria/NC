package by.nc.shpakovskaya.dao.hospital;

import by.nc.shpakovskaya.beans.Hospital;
import by.nc.shpakovskaya.beans.departments.Department;
import by.nc.shpakovskaya.dao.CommonDAO;
import by.nc.shpakovskaya.web.connectionPool.ConnectionPoolSing;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valeria on 21.11.2016.
 */
public class DepartmentDAO implements CommonDAO<Department> {

    static final String SQL_QUERY_ADD_DEPARTMENTS = "INSERT INTO departments (name, id_hospital)"+
            " VALUES (?, ?)";
    static final String SQL_QUERY_GET_DEPARTMENTS = "SELECT * FROM departments";

    public void add(Department department) {
        // см add2
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = ConnectionPoolSing.retrieve();
            preparedStatement = connection.prepareStatement(SQL_QUERY_ADD_DEPARTMENTS);
            preparedStatement.setString(1, department.getName());
            preparedStatement.setInt(2, department.getHospital().getId());
            List<Hospital> hospitalList = new HospitalDAO().get();
            for(Hospital hospital : hospitalList){
                if(hospital.getId()==department.getHospital().getId()){
                    System.out.println("add to hospital dep");
                    hospital.addDepartment(department);
                }
            }
            preparedStatement.executeUpdate();

        } catch (ClassNotFoundException e) {
            System.out.println("Class driver not found");
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQL exception occurred during add department");
            System.out.println(e.getMessage());
        } finally {
                ConnectionPoolSing.putBack(connection);
        }
    }

    @Override
    public List<Department> get() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Department> departments = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = ConnectionPoolSing.retrieve();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_QUERY_GET_DEPARTMENTS);
            departments = init(resultSet);

        } catch (ClassNotFoundException e) {
            System.out.println("Class driver not found");

        } catch (SQLException e) {
            System.out.println("SQL exception occurred during add department");
            System.out.println(e.getMessage());

        } finally {
            ConnectionPoolSing.putBack(connection);
        }
        return departments;
    }

    @Override
    public List<Department> init(ResultSet resultSet) throws SQLException {
        List<Department> departments = new ArrayList<>();
        while (resultSet.next()) {
            Department department = new Department();
            department.setId(resultSet.getInt(1));
            department.setName(resultSet.getString(2));
            // set hospital to depertments
            List<Hospital> hospitalList = new HospitalDAO().get();
            for(Hospital hospital : hospitalList){
                System.out.println("-" + hospital.getName());
                if(resultSet.getInt(3) == hospital.getId()){
                    System.out.println("Set to " + hospital.getName() +
                            " department " + resultSet.getString(2) + " hospital id " + resultSet.getInt(3));
                    department.setHospital(hospital);
                    hospital.addDepartment(department);
                    break;
                }
            }
            departments.add(department);
        }
        return departments;
    }
}
