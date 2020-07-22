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

@WebServlet(name = "LogoutControlles", urlPatterns = {"/logout"})
public class LogoutController extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().invalidate();
        
        response.sendRedirect("login");
    }
}
