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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Akash Kumar S
 */
@WebServlet(urlPatterns = {"/regup"})
public class regup extends HttpServlet {



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
        String name=request.getParameter("uname");  
        String pass=request.getParameter("upass");  
        String age=request.getParameter("uage");  
        String mail=request.getParameter("umail");
        out.print("<h1>  WELCOME TO LIBRARY MANAGEMENT SYSTEM!</h1>");
        out.print("<h2>Thanks for Using!</h2>");
        String query007="INSERT INTO ROOT.USERDATA  VALUES (?,?,?,?)";
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver");            
            conn=DriverManager.getConnection("jdbc:derby://localhost:1527/lbm","root","akash"); 
            //conn=DriverManager.getConnection("jdbc:derby://localhost:1527/lbm;create=true;user=root;password=akash");  
            PreparedStatement ps=conn.prepareStatement(query007);  
            ps.setString(1,name);
            ps.setString(2,pass);  
            ps.setString(3,age);  
            ps.setString(4,mail);
            int i=ps.executeUpdate(); 
            if(i>0)  
                out.print("<h2>You have successfully registered.</h2>");        
        }
         catch(Exception e) 
        {
            out.print("<h1>Error in the data Fed upon:</h1>");
            System.out.println(e);
        } 
        
        out.print("<form action=\"index.html\"> <input type=\"submit\" value=\"Go to Login\" /> </form>");
        out.close();  
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
