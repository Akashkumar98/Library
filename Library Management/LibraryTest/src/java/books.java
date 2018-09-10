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
@WebServlet(urlPatterns = {"/books"})
public class books extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
   
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        out.print("<html>");
        out.println("<center><h1>Available Collection of Books!</h1></center>");
        out.print("<body>");
        
        
        try{
            
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conn=DriverManager.getConnection("jdbc:derby://localhost:1527/lbm","root","akash");  
            PreparedStatement ps=conn.prepareStatement("select * from ROOT.BOOKS");  
            ResultSet rs=ps.executeQuery();
            ResultSetMetaData rsmd= rs.getMetaData();
            
            
            out.print("<table width=\"100%\" border=\"1\" cellspacing=\"5\" cellpadding=\"15\" bgcolor=\"#D6EAF8\" > ");
            out.print("<tr><td><h3>Book Name:  </h3></td><td><h3>Book ID:</h3></td><td><h3>"+rsmd.getColumnName(3)+"</h3></td><td><h3>Publications</h3></td>");
            while(rs.next())
            {          
                out.print("<tr><td>" + rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td>");
            }
            out.print("</table>");

            
        }
        catch(Exception e){
            out.print("Error..");
            System.out.print(e);
        }
        
        out.print("<br><form action=\"adc.jsp\"> <input type=\"submit\" value=\"Add or Delete Books!\" /> </form>");                
       
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
