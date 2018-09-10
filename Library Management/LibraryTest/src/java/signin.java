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

public class signin extends HttpServlet {

     public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {  

        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();            
        String name=request.getParameter("uname");  
        String pass=request.getParameter("upass");  
        Connection con=null;
        String query007=" ";
        try
        {  
            Class.forName("  ");  
            con=DriverManager.getConnection("   ");  
            PreparedStatement ps=con.prepareStatement(query007);  
            
            out.println("<h1>Hello sign in</h1>");
            
            
            
            
            
            
            
            
            
         }    
     catch(Exception e) 
        {
            System.out.println(e);
        }  
     out.close();  
    }
    
    
    
  
}
