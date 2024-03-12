package service;

import bean.Employee;
import repository.EmployeeRepository;

import java.util.List;

public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService() {
        this.employeeRepository = new EmployeeRepository();
    }

    // Add a new employee
    public void addEmployee(Employee employee) {
        employeeRepository.addEmployee(employee);
    }

    // Get all employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }
}
