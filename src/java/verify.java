/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Cloudme.CloudmeUser;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
public class verify extends HttpServlet {

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
            
            String che=request.getParameter("ch");
            String fi=request.getParameter("fil");
            String user=request.getParameter("na");
            String sno=request.getParameter("sno");
            String filename=request.getParameter("filename");
//             String fil=request.getParameter("photo");
             FileInputStream fis = null;
            File ss=new File(fi);
            String sss=fi;
            int i=0;
            
//            File f=new File("D:\\image\\encrypt\\"+fi);
          String path=fi;
            String path1="D:\\image\\encrypt\\"+filename;
            
//             HttpSession session=request.getSession();
//            String na = (String)session.getAttribute("nam");
            check c=new check();

            int ch=c.fun(fi);
         
            String ci=Integer.toString(ch);
            if(sno==ci)
                {}else{}
            try{
           
           File file = new File(sss);
                 fis = new FileInputStream(file);
                 
            Class.forName("com.mysql.jdbc.Driver");
                Connection con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/pollution","root","root");
                PreparedStatement ps=con.prepareStatement("update imm set  checksum1=?,status='upload' where userName=? and sno=?");
//                 PreparedStatement ps=con.prepareStatement("insert into imm (checksum1,userName) values(?,?)");
       
                ps.setString(1,ci); 
//                JOptionPane.showMessageDialog(null, na);
                 ps.setString(2,user);
                 ps.setString(3,sno);
                 
                  int r=ps.executeUpdate();
                if(r!=0)
                {             
                 if(che.equals(ci)){
//                     
//                     CloudmeUser use=new CloudmeUser("ccaf","ccaf123");
//         use.getFileManager().uploadFile("D:\\image\\encrypt\\"+filename,"/Personaldetails/");
//         use.killUser();
                     String s=filename;
                     String[] args={s};
//                    cloudme cc=new cloudme();
//                     
//                     cc.cloud1(args);
//                     dropbox d=new dropbox();
//                     d.cloud1(args);
                     
                      try{
        CloudmeUser user1 = new CloudmeUser("suresh12345","suresh12345");
         user1.getFileManager().uploadFile(path1,"/pollution/");
         user1.killUser();}catch(Exception e)
         {
             System.out.println(e);
         }
         JOptionPane.showMessageDialog(null, "Upload successfully");
          RequestDispatcher rd = request.getRequestDispatcher("cloud.jsp");
                     
                 }
                }
                else
                {
                 JOptionPane.showMessageDialog(null, "Upload falied");
                }
                 }
            
            

             catch(Exception e1)
             {
                 JOptionPane.showMessageDialog(null,e1);
             }
            
             RequestDispatcher rd = request.getRequestDispatcher("cloud.jsp");
                request.setAttribute("msg1", "Upload SUCCESSFULLY ..");
                rd.forward(request, response);
            

            out.println("<script>");
                out.println("alert('File uploaded successfully');");
                out.println("location='cloud.jsp'");
                out.println("</script>");
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
