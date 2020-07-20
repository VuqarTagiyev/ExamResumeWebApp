package az.company.controller;

import az.company.context.Context;
import az.company.dao.impl.UserDaoImpl;
import az.company.entity.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SignUpController", urlPatterns = {"/sign_up"})
public class SignUpController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("sign_up.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int studentTicketNumber = Integer.parseInt(request.getParameter("student_ticket_number"));
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = new User(null, email, studentTicketNumber, password);
        UserDaoImpl userDao = Context.getUserDaoImpl();
        userDao.addUser(user);
        response.sendRedirect("login");
    }
}
