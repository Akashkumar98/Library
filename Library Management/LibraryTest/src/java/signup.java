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


public class signup extends HttpServlet {
    
    
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {  
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();            
        String name=request.getParameter("uname");  
        String pass=request.getParameter("upass");  
        String age=request.getParameter("uage");  
        String mail=request.getParameter("umail");  
        Connection con=null;
        String query007="insert into ** values(?,?,?,?)";
        try
        {  
            Class.forName("    ");  
            con=DriverManager.getConnection("  ");  
            PreparedStatement ps=con.prepareStatement(query007);  
            ps.setString(1,name);
            ps.setString(2,pass);  
            ps.setString(3,age);  
            ps.setString(4,mail);
            int i=ps.executeUpdate();  
            if(i>0)  
            out.print("You have successfully registered.");        
        }
     catch(Exception e) 
        {
            System.out.println(e);
        } 
        out.print("Check 1 2 3..");        
     out.close();  
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
 

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   

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
