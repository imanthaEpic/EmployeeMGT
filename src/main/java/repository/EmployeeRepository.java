package repository;

import bean.Employee;
import util.DatabaseUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {

    // Add a new employee to the database
    public void addEmployee(Employee employee) {
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO employee (username, password, name, email, designation, birthday) " +
                             "VALUES (?, ?, ?, ?, ?, ?)")) {
            preparedStatement.setString(1, employee.getUsername());
            preparedStatement.setString(2, employee.getPassword());
            preparedStatement.setString(3, employee.getName());
            preparedStatement.setString(4, employee.getEmail());
            preparedStatement.setString(5, employee.getDesignation());
            preparedStatement.setDate(6, (Date) employee.getBirthday());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }
    }

    // Get all employees from the database
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Employee employee = new Employee();
                // Populate employee object from the resultSet
                employee.setId(resultSet.getLong("id"));
                employee.setUsername(resultSet.getString("username"));
                employee.setPassword(resultSet.getString("password"));
                employee.setName(resultSet.getString("name"));
                employee.setEmail(resultSet.getString("email"));
                employee.setDesignation(resultSet.getString("designation"));
                employee.setBirthday(resultSet.getDate("birthday"));
                
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }
        return employees;
    }
}
