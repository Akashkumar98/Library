/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Akash Kumar S
 */
@WebServlet(urlPatterns = {"/del"})
public class del extends HttpServlet {

 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        

        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        String bid=request.getParameter("bid");  
        Connection conn = null; 
        out.print("<html>"); 
        out.print("<body>"); 
        String query="select * from root.userdata"; 
        //String query007="select * from root.userdata where name="+xname" and pass="+xpass""; 
        try 
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn=DriverManager.getConnection("jdbc:derby://localhost:1527/lbm","root","akash");  
            out.print("Check 1 ");
            PreparedStatement ps=conn.prepareStatement("DELETE FROM ROOT.BOOKS WHERE (BID = ?)");  
            ps.setString(1,bid); 
            out.print("Check 2 ");
            int flag=ps.executeUpdate();
            out.print("<h2> Deleted Successfully!");      
        }  
        catch(Exception e) 
        {
            out.print("<h1>Error</h1>");
            System.out.println(e);
        }  
     
        out.print("<br><form action=\"books\" method=\"post\"> <input type=\"submit\" value=\"Visit Books\" /> </form>");
        out.print("</body>");
        out.print("</html>");
        out.close();  
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
 
    
}
