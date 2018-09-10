n<%-- 
    Document   : books
    Created on : Sep 8, 2018, 11:32:45 AM
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
        <sql:setDataSource var = "snapshot" driver = "org.apache.derby.jdbc.ClientDriver"
         url = "jdbc:derby://localhost/lbm"
         user = "root"  password = "akash"/>
        <h1></h1>
        
        <sql:query dataSource = "${snapshot}" var = "result">
         SELECT * from BOOKS;
        </sql:query>
 
      <table border = "1" width = "85%">
         <tr>
            <th>Book Name</th>
            <th>Book ID</th>
            <th>Author</th>
            <th>Publications</th>
         </tr>
         
         <c:forEach var = "row" items = "${result.rows}">
            <tr>
               <td><c:out value = "${row.bname}"/></td>
               <td><c:out value = "${row.bid}"/></td>
               <td><c:out value = "${row.author}"/></td>
               <td><c:out value = "${row.publ}"/></td>
            </tr>
         </c:forEach>
      </table>
            <br><br>    
        <form action="adc.jsp"> 
            <input type="submit" value="Add / Delete Books" />     
        </form>
    </body>
</html>
