package fblogin;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class FacebookLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Simplified authentication logic, replace with your own authentication process
        if (username.equals("Team1") && password.equals("123")) {
            // Successful login
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect("welcomefb.jsp"); // Redirect to a welcome page
        } else {
            // Failed login
            response.sendRedirect("fblogin.jsp"); // Redirect back to the login page
        }
    }
}
