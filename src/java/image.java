/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
 * @author ARUN
 */
public class image extends HttpServlet {

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
            
            
            
            String fil=request.getParameter("photo");
           
            FileInputStream fis = null;
            File ss=new File("D:/image/"+fil);
            String sss="D:/image/"+fil;
            int i=0;
            
            
            Random randomGenerator = new Random();
            int ka = randomGenerator.nextInt(100000000);
            String k=Integer.toString(ka);
            
            Encrypt e=new Encrypt();
            
            e.fun(sss,fil,k);
            
             HttpSession session=request.getSession();
            String na = (String)session.getAttribute("nam");
             check c=new check();
//            c.fun(sss);
            int ch=c.fun(sss);
            String che=Integer.toString(ch);
//            HttpSession sess=request.getSession();
//            String nna = (String)session.getAttribute("nam");
//            sess.setAttribute("namm", che);
            try
            {
                
                
//                GetFileSize bb=new GetFileSize();
//                String size=bb.add(fil);
//                i++;
                 File file = new File(sss);
                 fis = new FileInputStream(file);
               
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pollution","root","root");
                PreparedStatement ps=con.prepareStatement("insert into imm (userName,fileName,filePath,fileContent,key1,checksum,status) values(?,?,?,?,?,?,?)");
                
//                ps.setInt(1,i );
               
                ps.setString(1,na); 
//                JOptionPane.showMessageDialog(null, na);
                ps.setString(2,fil);    
//                JOptionPane.showMessageDialog(null, s);
                ps.setString(3,sss);
//              JOptionPane.showMessageDialog(null, sss);
                ps.setAsciiStream(4, fis, (int) file.length());
//               JOptionPane.showMessageDialog(null, fis);
//              ps.setString(5,size);
                ps.setString(5,k);
//              JOptionPane.showMessageDitimebasedgroupkeyalog(null, k);
                ps.setString(6,che);
//               ps.setString(7,"null");
//                ps.setString(8,"null");
                ps.setString(7,"encrypt");
                  
                  
//                 GetFileSize g=new  GetFileSize();
//                 g.getFileSize(fil);
                         
                 
                  File f=new File("D:\\image\\fake\\"+fil);
            f.createNewFile();
            FileWriter fw=new FileWriter(f);
            fw.write(fil+na+sss);
            fw.flush();
            fw.close();
                          
                int r=ps.executeUpdate();
                if(r!=0)
                {                    
//                 JOptionPane.showMessageDialog(null, );
                 JOptionPane.showMessageDialog(null, "Upload successfully");
                 RequestDispatcher rd = request.getRequestDispatcher("upload.html");
//                request.setAttribute("msg1", "Upload SUCCESSFULLY ..");
                rd.forward(request, response);
                }
                else
                {
                 JOptionPane.showMessageDialog(null, "Upload failed");
                 
            out.println("<script>");
                out.println("alert('File uploaded successfully');");
                out.println("location='upload.html'");
                out.println("</script>");
                }
              
                
                
            }
            
             catch(Exception e1)
             {
                 JOptionPane.showMessageDialog(null,e1);
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
