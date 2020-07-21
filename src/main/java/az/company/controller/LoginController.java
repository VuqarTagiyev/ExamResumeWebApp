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

@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer studentTicketNumer = Integer.parseInt(request.getParameter("student_ticket_number"));
        System.out.println(studentTicketNumer);
        String password = request.getParameter("password");
        UserDaoImpl userDao = Context.getUserDaoImpl();
        User user = userDao.getUserByStudentTicketNumberAndPassword(studentTicketNumer, password);
        if (user == null) {
            response.sendRedirect("login");
        } else {
            if (user.getUserPosition().getId() == 4) {
                request.getSession().setAttribute("loggedIn", user);
                request.getSession().setAttribute("admin", user);
                response.sendRedirect("admin_panel");
            } else {
                request.getSession().setAttribute("loggedIn", user);
                response.sendRedirect("main");
            }
        }
    }
}
