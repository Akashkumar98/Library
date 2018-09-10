<%-- 
    Document   : page1
    Created on : Sep 2, 2018, 7:45:09 PM
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
        <h1>Hello !</h1>
     
        <% String name=request.getParameter("uname"); %>
        
        <p> Welcome <%=name%> </p>
        <p> Sign Up Successful! </p>
        <form action="index.">
            <input type="submit" value="Go to Log In" />
        </form>
        
    </body>
</html>
