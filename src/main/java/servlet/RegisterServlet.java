package servlet;

import bean.Employee;
import service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    private final EmployeeService employeeService;

    public RegisterServlet() {
        this.employeeService = new EmployeeService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve parameters from the request
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String designation = request.getParameter("designation");
        String birthdayStr = request.getParameter("birthday"); // Assuming it's a string for now

        // Convert birthday string to java.sql.Date
        java.sql.Date birthday = java.sql.Date.valueOf(birthdayStr);

        // Create an Employee object with the retrieved parameters
        Employee employee = new Employee();
        employee.setUsername(username);
        employee.setPassword(password);
        employee.setName(name);
        employee.setEmail(email);
        employee.setDesignation(designation);
        employee.setBirthday(birthday);

        // Add the new employee to the database
        employeeService.addEmployee(employee);

        // Redirect the user to a confirmation page
        response.sendRedirect("registration_success.jsp");
    }
}
