package com.shaheen.repository;

import com.shaheen.config.ConnectionToMysql;
import com.shaheen.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    private final String selectAll = "SELECT * FROM EMPLOYEE";
    private final String selectById = "SELECT * FROM EMPLOYEE WHERE ID = ?";
    private final String insert = "INSERT INTO EMPLOYEE (FIRSTNAME,LASTNAME,PHONE,EMAIL,PASSWORD) VALUES(?,?,?,?,?)";
    private final String update = "UPDATE EMPLOYEE SET FIRSTNAME =?,LASTNAME= ?,PHONE = ?,EMAIL =?,PASSWORD = ? " +
            "WHERE ID = ?";
    private final String delete = "DELETE FROM EMPLOYEE WHERE ID = ?";
    // connection
    private Connection connection = null;
    // preparedStatment
    private PreparedStatement preparedStatement = null;
    // resultSet
    private ResultSet resultSet = null;

    public EmployeeRepositoryImpl() {
        connection = ConnectionToMysql.getInstance().getConnection();
        System.out.println(connection);
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(selectAll);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee employee = mapResultSetToEmployee(resultSet);
                employees.add(employee);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    private Employee mapResultSetToEmployee(ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getInt("ID"));
        employee.setFirstName(resultSet.getString("FIRSTNAME"));
        employee.setLastName(resultSet.getString("LASTNAME"));
        employee.setEmail(resultSet.getString("EMAIL"));
        employee.setPhone(resultSet.getString("PHONE"));
        employee.setPassword(resultSet.getString("PASSWORD"));
        return employee;
    }

    @Override
    public Employee getById(int id) {
        Employee employee = new Employee();
        try {
            preparedStatement = connection.prepareStatement(selectById);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employee = mapResultSetToEmployee(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public Employee insert(Employee employee) {
        try {
            preparedStatement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            preparedStatement = mapEmployeeToPrepardStatment(employee, preparedStatement);
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                employee.setId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    private PreparedStatement mapEmployeeToPrepardStatment(Employee employee, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, employee.getFirstName());
        preparedStatement.setString(2, employee.getLastName());
        preparedStatement.setString(3, employee.getPhone());
        preparedStatement.setString(4, employee.getEmail());
        preparedStatement.setString(5, employee.getPassword());
        return preparedStatement;
    }

    @Override
    public Employee update(Employee employee) {
        try {
            preparedStatement = connection.prepareStatement(update);
            preparedStatement = mapEmployeeToPrepardStatment(employee, preparedStatement);
            preparedStatement.setInt(6, employee.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public void delete(int id) {
        try {
            preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
