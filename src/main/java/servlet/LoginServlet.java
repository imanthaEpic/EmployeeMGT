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

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    private final EmployeeService employeeService;

    public LoginServlet() {
        this.employeeService = new EmployeeService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve username and password from the request
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Validate the login credentials
        //Employee employee = employeeService.getEmployeeByUsernameAndPassword(username, password);

//        if (employee != null) {
//            // If valid, create a session and store employee information
//            HttpSession session = request.getSession();
//            session.setAttribute("employee", employee);
//            // Redirect to dashboard or home page
//            response.sendRedirect("dashboard.jsp");
//        } else {
//            // If invalid, redirect back to login page with an error message
//            response.sendRedirect("login.jsp?error=1");
//        }
    }
}
