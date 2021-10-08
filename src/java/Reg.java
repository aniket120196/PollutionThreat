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
public class Reg extends HttpServlet {

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
           
           String fn=request.getParameter("un");
            String ln=request.getParameter("pas");
            String em=request.getParameter("pei");
            String gen=request.getParameter("gen");
            String dob=request.getParameter("pee");
            String conn=request.getParameter("pay");
            try{
                
               int a=0;
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pollution","root","root");
            
            PreparedStatement ps =null;
            ps=con.prepareStatement("select username from reg where username=?");
            ps.setString(1,fn);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
            a++;
            }
            if(a==0){
            
            
                   ps= con.prepareStatement("insert into reg(username,password,mailid,gender,dob,contact,status) values(?,?,?,?,?,?,?)");
            
            ps.setString(1,fn);
            ps.setString(2,ln);
            ps.setString(3,em);
            ps.setString(4,gen);
            ps.setString(5,dob);
            ps.setString(6,conn);
            ps.setString(7,"access");
            
            int r=ps.executeUpdate();
            if(r!=0)
            {
                JOptionPane.showMessageDialog(null, "Succesful");
                RequestDispatcher rd=request.getRequestDispatcher("user.jsp");
            rd.forward(request, response);
            }
            else{
                JOptionPane.showMessageDialog(null, "Failed");
                RequestDispatcher rd=request.getRequestDispatcher("reg.jsp");
            rd.forward(request, response);
                
            }
            }
            else{
                JOptionPane.showMessageDialog(null, "already register");
                RequestDispatcher rd=request.getRequestDispatcher("reg.jsp");
            rd.forward(request, response);
            }
            }
           catch(Exception e){
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
