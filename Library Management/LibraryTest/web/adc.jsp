<%-- 
    Document   : adc
    Created on : Sep 8, 2018, 12:21:53 PM
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
        <h1>Add or Delete Books:!</h1>
        <h2>Add a Book!</h2>
        <table border="0">
            <form action="add" method="POST">
            <tbody>
                <tr>
                    <td>Book Name:</td>
                    <td> <input type="text" name="bname" value="" size="30" /> </td>
                </tr>
                <tr>
                    <td>Book ID:</td>
                    <td> <input type="text" name="bid" value="" size="15" /> </td>
                </tr>
                <tr>
                    <td>Author:</td>
                    <td> <input type="text" name="author" value="" size="30" /> </td>
                </tr>
                <tr>
                    <td>Publication:</td>
                    <td> <input type="text" name="publ" value="" size="30" /> </td>
                </tr>
                <tr>
                    <td></td>
                    <td> <input type="submit" value="Add!" /> </td>
                </tr>
            </tbody>
            </form>
        </table>
        <br>
        <h2>Delete a Book!</h2>
        <table border="0">
            <form action="del" method="POST">
            <tbody>
                <tr>
                    <td>Book ID:</td>
                    <td> <input type="text" name="bid" value="" size="15" /> </td>
                </tr>
                <tr>
                    <td></td>
                    <td> <input type="submit" value="Delete!" /> </td>
                </tr>
            </tbody>
            </form>
        </table>


    </body>
</html>
