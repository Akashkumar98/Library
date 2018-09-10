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
@WebServlet(urlPatterns = {"/list"})
public class list extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        out.print("<html>");
        out.println("<center><h1>Complaints Registered so far!</h1></center>");
        out.print("<body>");
        try{
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection conn=DriverManager.getConnection("jdbc:derby://localhost:1527/complain","cse","eec");  
        PreparedStatement ps=conn.prepareStatement("select * from CSE.DATADB");  
        ResultSet rs=ps.executeQuery();
        ResultSetMetaData rsmd= rs.getMetaData();
        
        while(rs.next()){
            
            out.print("<table width=\"90%\" border=\"1\" cellspacing=\"5\" cellpadding=\"15\" > "); // bgcolor=\"#D6EAF8\
            out.print("<tr><td><b>First Name:</b></td><td>"+rs.getString(1)+"</td></tr>" );
            out.print("<tr><td><b>Last Name:</b></td><td>"+rs.getString(2)+"</td></tr>" );
            out.print("<tr><td><b>Complaint:</b></td><td>"+rs.getString(3)+"</td></tr>" );
            out.print("</table><br><br>");
            
        }
        
        
        }
        catch(Exception e){
            System.out.print(e);
        }
    }

    
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
