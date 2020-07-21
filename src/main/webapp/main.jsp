
<%@page import="az.company.entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css">
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
            String surname = user.getSurname();

        %>
        <h1>Welcome <%=name%></h1>
        <div class="container_avatar">
            <center>
                <img style="border-radius: 50%; width: 75px; height: 75px;"  class="img_avatar" src="images/img_avatar.png" alt="Avatar">
                <h3><%=name%> <%=surname%></h3>
            </center>
        </div>
        <form method="POST" action="main">
            <input class="form-submit" type="submit" value="Logout"/>
        </form>
    </body>
</html>
