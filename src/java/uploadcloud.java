/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Cloudme.CloudmeUser;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author Eniya
 */
public class uploadcloud extends HttpServlet {

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
               try{
          Class.forName("com.mysql.jdbc.Driver");
                Connection con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/pollution","root","root");
                PreparedStatement ps=con.prepareStatement("select * from imm where status=?");
                ps.setString(1, "encrypt");
             ResultSet rs=ps.executeQuery();
             int kk=0;
             while(rs.next())
             {
                 String filename=rs.getString("fileName");
//                 int size=rs.getInt("filesize");
                 int sno=rs.getInt("sno");
//                 JOptionPane.showMessageDialog(null,filename+"   "+size);
                  CloudmeUser user=new CloudmeUser("ccaf","ccaf123");
         user.getFileManager().uploadFile("D:/image/encrypt"+filename,"/Hybrid/");
         user.killUser();
         Random randomGenerator = new Random();
            int ka = randomGenerator.nextInt(100000000);
               ps=con.prepareStatement("update imm set key2=?,status=? where sno=?");
                ps.setString(1, ka+"");
                ps.setString(2, "upload");
                ps.setInt(3, sno);
                ps.executeUpdate();
                kk++;
             }
             if(kk!=0)
             {
                 JOptionPane.showMessageDialog(null, "upload Successfully");
                 RequestDispatcher rd=request.getRequestDispatcher("cloud.jsp");
                    rd.forward(request, response);
             }
             else
             {
                 JOptionPane.showMessageDialog(null, "upload Failed");
                 RequestDispatcher rd=request.getRequestDispatcher("cloud.jsp");
                    rd.forward(request, response);
             }
         }
          catch(Exception e)
          {
              JOptionPane.showMessageDialog(null, e);
              JOptionPane.showMessageDialog(null, "upload Failed");
                 RequestDispatcher rd=request.getRequestDispatcher("cloud.jsp");
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
