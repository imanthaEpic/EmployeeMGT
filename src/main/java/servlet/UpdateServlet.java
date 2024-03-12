package servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import bean.Employee;
import jakarta.servlet.http.HttpSession;
import service.EmployeeService;

@WebServlet(name = "UpdateServlet", urlPatterns = {"/update"})
public class UpdateServlet extends HttpServlet {

    private final EmployeeService employeeService;

    public UpdateServlet() {
        this.employeeService = new EmployeeService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve parameters from the request
        HttpSession session = request.getSession();
        Employee employee = (Employee) session.getAttribute("employee");

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String designation = request.getParameter("designation");
        String birthday = request.getParameter("birthday"); // Assuming it's a string for now

        // Update the employee information
        employee.setName(name);
        employee.setEmail(email);
        employee.setDesignation(designation);
        // Parse birthday string to Date and set it in the Employee object

        // Update employee in the database
        //employeeService.updateEmployee(employee);

        // Redirect the user to a confirmation page
        response.sendRedirect("update_success.jsp");
    }
}
