/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.company.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Исмаил
 */
@WebFilter(filterName = "LoggedIn", urlPatterns = "*")
public class LoggedInFilter implements Filter {
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("INIT");    
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        if (req.getSession().getAttribute("loggedIn") == null 
                && !req.getRequestURI().contains("/login") 
                && !req.getRequestURI().contains("/sign_up")
                && !req.getRequestURI().contains("/error")) {
            res.sendRedirect("error");
        } else {
            chain.doFilter(request, response);
        }
    }
    
    @Override
    public void destroy() {
        System.out.println("Destroy");    
    }
    
}
