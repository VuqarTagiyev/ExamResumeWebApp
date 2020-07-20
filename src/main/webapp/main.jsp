<%-- 
    Document   : main
    Created on : 20.07.2020, 21:13:50
    Author     : Исмаил
--%>

<%@page import="az.company.entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            User user = (User) request.getSession().getAttribute("loggedIn");
            if (user == null) {
                response.sendRedirect("error");
                return;
            }
            String name = user.getName();

        %>
        <h1>Welcome <%=name%></h1>
        <form method="POST" action="main">
            <input type="submit" value="Logout"/>
        </form>
    </body>
</html>
