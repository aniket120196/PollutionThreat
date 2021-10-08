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
import java.sql.Statement;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author ARUN
 */
public class adminaccept extends HttpServlet {

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
            String ky=request.getParameter("key");
            String sno=request.getParameter("sno");
            
            Random randomGenerator = new Random();
            int ka = randomGenerator.nextInt(100000000);
            String k=Integer.toString(ka);
            
            
          try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pollution","root","root");
                PreparedStatement ps=con.prepareStatement("update imm set key2=?, status='accept' where key1=? and sno=?");
//                 JOptionPane.showMessageDialog(null, ps);
//                ps.setString(1,"accept" );
                 ps.setString(1,k );
                 
                 ps.setString(2,ky );
                 ps.setString(3,sno);
                JOptionPane.showMessageDialog(null, ky);
//                Statement st=con.createStatement();
                int r=ps.executeUpdate();
                if(r!=0)
                {
//                    String status="Update key1 set sstatus='Send' where key1='"+ky+"'";
////                        
//                    st.executeUpdate(status);
                    JOptionPane.showMessageDialog(null, "Response send successfully");
                    RequestDispatcher d=request.getRequestDispatcher("userresponse.jsp");
                    d.forward(request, response);
                }
                else
                {
                   JOptionPane.showMessageDialog(null, "Response not send");
                    RequestDispatcher d=request.getRequestDispatcher("userresponse.jsp");
                    d.forward(request, response);
                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
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
