<%-- 
    Document   : adminpanel
    Created on : 21.07.2020, 14:46:47
    Author     : Исмаил
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        if(request.getSession().getAttribute("admin") == null){
            response.sendRedirect("error");
            return;
        }
    %>
    <body>
        <h1>Hello Administrator!</h1>

        <form method="POST" action="admin_panel">
            <input class="form-submit" type="submit" value="Logout"/>
        </form>
    </body>
</html>
