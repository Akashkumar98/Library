<%-- 
    Document   : page2
    Created on : Sep 2, 2018, 8:38:28 PM
    Author     : Akash Kumar S
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello!</h1>
        <br><br>
        
        <% String name=request.getParameter("uname"); %>
        
        <p> Welcome <%=name%> </p>
        <p> Sign In Successful! </p>
        
    </body>
</html>
