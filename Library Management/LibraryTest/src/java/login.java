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
@WebServlet(urlPatterns = {"/login"})
public class login extends HttpServlet {

  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        

        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        int flag=0;
        String xname=request.getParameter("uname");  
        String xpass=request.getParameter("upass"); 
        Connection conn = null;
        out.print("<html>");
        out.println("<h1>Hello There!</h1>");
        out.print("<body>");
        String query="select * from root.userdata"; 
        //String query007="select * from root.userdata where name="+xname" and pass="+xpass"";
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn=DriverManager.getConnection("jdbc:derby://localhost:1527/lbm","root","akash");  
            PreparedStatement ps=conn.prepareStatement("select * from ROOT.USERDATA where (name=? and pass=?)");  
            ps.setString(1,xname);  
            ps.setString(2,xpass);
            ResultSet rs=ps.executeQuery();
            ResultSetMetaData rsmd= rs.getMetaData();
            while(rs.next())
            {
                out.print("<h1>Login Successful!</h1>");
                out.print("<table width=\"45%\" border=\"1\" cellspacing=\"5\" cellpadding=\"15\" bgcolor=\"#D5F5E3\">");
                out.print("<tr>");
                out.print("<td><b>"+rsmd.getColumnName(1)+"</b></td>");
                out.print("<td>"+rs.getString(1)+"</td></tr>");
                out.print("<td><b>"+rsmd.getColumnName(3)+"</b></td>");
                out.print("<td>"+rs.getString(3)+"</td></tr>");
                out.print("<td><b>"+rsmd.getColumnName(4)+"</b></td>");
                out.print("<td>"+rs.getString(4)+"</td></tr>");
                out.print("</table>");
                flag=1;
                  
            }
            out.print("</body>");
            out.print("</html>");
                  
        }  
        catch(Exception e) 
        {
            out.print("<h1>Error</h1>");
            System.out.println(e);
        }  
        if(flag==1){
            out.print("<br><form action=\"books\" method=\"post\"> <input type=\"submit\" value=\"Visit Books\" /> </form>");
            }
        else{
            out.print("<h1>Wrong Name or Password!</h1>");
        }

        out.close();  
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
