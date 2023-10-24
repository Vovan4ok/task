package servlets;

import models.User;
import services.UserService;
import services.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserServiceImpl userService = UserServiceImpl.getUserService();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String userSurname = request.getParameter("userSurname");
        String userEmail = request.getParameter("userEmail");
        String userPassword = request.getParameter("userPassword");

        if((userName.isEmpty() && userSurname.isEmpty() && userEmail.isEmpty() && userPassword.isEmpty()) || userService.getUserByEmail(userEmail) != null) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        User user = new User(userName, userSurname, userEmail, userPassword);
        userService.create(user);

        HttpSession session = request.getSession(true);
        session.setAttribute("userId", userService.getUserByEmail(userEmail));

        request.getRequestDispatcher("cabinet.jsp").forward(request, response);
    }
}
