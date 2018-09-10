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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Akash Kumar S
 */
public class page1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();         
        Connection conn = null;
        String fname=request.getParameter("fname");  
        String lname=request.getParameter("lname");  
        String subject=request.getParameter("subject");  
        out.print("<h1><center>JARVIS WELCOMES YOU!</center></h1>");
        out.print("<h2>Thanks for Using!</h2>");
        String query007="insert into cse.datadb values(?,?,?)";
        try{
            
            Class.forName("org.apache.derby.jdbc.ClientDriver");            
            conn=DriverManager.getConnection("jdbc:derby://localhost:1527/complain","cse","eec");
            PreparedStatement ps=conn.prepareStatement(query007); 
            ps.setString(1,fname);
            ps.setString(2,lname);  
            ps.setString(3,subject);
            int i=ps.executeUpdate(); 
            if(i>0)  
                out.print("You have successfully registered.");   
        }
        catch(Exception e){
            System.out.println(e);
            out.print("Error");
        }
        
        out.print("<br><form action=\"list\" method=\"post\"> <input type=\"submit\" value=\"View Complaints!\" /> </form>");
        out.close();  
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
