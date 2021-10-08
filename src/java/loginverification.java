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
import java.sql.Statement;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 *
 * @author Eniya
 */
public class loginverification extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String userid=request.getParameter("name");
            String mailid=request.getParameter("mail");
            String vkey=request.getParameter("verkey");
            try
            {
                int count=0;
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pollution","root","root");
            
//           String sq= "update reg set blockkey=? where username=?";
//           
//           PreparedStatement ps=con.prepareStatement(sq);
//           
//           ps.setString(1, "no");
//           ps.setString(2, "uname");
//             ps.executeUpdate(sq);
//              dbconnection dbb=new dbconnection();
//              Connection con=dbb.getconn();
//               PreparedStatement psn=con.prepareStatement(dbqueries.LOGINVERIFY);
             String aa= "select * from reg where username=? and mailid=? and blockkey=?";
             PreparedStatement p=con.prepareStatement(aa);
             
        p.setString(1,userid);
        p.setString(2,mailid);
        p.setString(3,vkey);
//        psn.setString(2, password);
        ResultSet irr=p.executeQuery();
        while(irr.next()){
               count++;
                         }
        if(count!=0)
        {
            int c=0;
            Class.forName("com.mysql.jdbc.Driver");
            Connection co=DriverManager.getConnection("jdbc:mysql://localhost:3306/pollution","root","root");
           String s= "update reg set blockreq=? where username=?";
           PreparedStatement psn=co.prepareStatement(s);
//             psn.executeUpdate(s);
//            psn=con.prepareStatement(dbqueries.LOGINVERIFY1);
        psn.setString(1,"yes");
        psn.setString(2,userid);
//        psn.setString(3,vkey);
//        psn.setString(2, password);
        int ir=psn.executeUpdate();
        if(ir!=0)
        {
            JOptionPane.showMessageDialog(null, " Request Send Succesfully");
            RequestDispatcher rd=request.getRequestDispatcher("loginverification.jsp");	
//			request.setAttribute("msg","Request Send successfully");
//                        out.println("<script type=\"text/javascript\">");
//                         out.println("alert('Request Send successfully');");
			rd.forward(request, response);
        }
        
        else
        {
            JOptionPane.showMessageDialog(null, " Request Send Failed");
            RequestDispatcher rd=request.getRequestDispatcher("loginverification.jsp");	
//			request.setAttribute("msg","Request Send Failed");
			rd.forward(request, response);
        }
        }
         else
        {
            RequestDispatcher rd=request.getRequestDispatcher("loginverification.jsp");	
			request.setAttribute("msg","Enter valid details");
			rd.forward(request, response);
        }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
                RequestDispatcher rd=request.getRequestDispatcher("loginverification.jsp");	
			request.setAttribute("msg","Enter valid details");
			rd.forward(request, response);
            }
        }
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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        processRequest(request, response);
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
