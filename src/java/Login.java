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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Login extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();

            String uname = request.getParameter("name");
            String pwd = request.getParameter("pass");

            session.setAttribute("nam", uname);

            try {
                String uri = request.getScheme() + "://"
                        + request.getServerName()
                        + ":"
                        + request.getServerPort()
                        + request.getRequestURI()
                        + "?"
                        + request.getQueryString();
                System.out.println("uri = " + uri);
                int i = 0;
                String Count;
//            String b=Integer.toString(j);
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pollution", "root", "root");
                Statement st = con.createStatement();
                String sa = "select *from reg where username='" + uname + "' and password='" + pwd + "'and status='access' ";
//            String a="update reg set logincount=? where username=?";
                PreparedStatement ps = con.prepareStatement(sa);

//            ResultSet ra=ps.executeQuery(ps);
                ResultSet ra = st.executeQuery(sa);
//                  while(ra.next()){
//                    
////                    String name=rs.getString("username");
                
//                    String mail=ra.getString("mailid");

//                    int cound=r.getInt("logincount");
//                   String s1=r.getString("logincount");
                while (ra.next()) {
                    i++;
                }
                if (i != 0) {
//     {
//         String co=r.getString("logincount");
//        Count++; 
//     }

                    String sql = "update reg set logincount='0' where username='" + uname + "'";
                    ps.executeUpdate(sql);

                    JOptionPane.showMessageDialog(null, "Successful");
                    RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
                    rd.forward(request, response);
                } //            int j=1;
                //            String k=Integer.toString(j);
                //                int x=j+(r.getInt("logincount"));
                else {
                    String username = "select *from reg where username='" + uname + "' ";
                    
//                      String ="Select * from reg where username= '"+uname+"'  "; 
                    ResultSet rs = st.executeQuery(username);
                   
                    if (rs.next()) {
                        Count = rs.getString("logincount");
                        String mail=rs.getString("mailid");
//   String p=rs.getString("logincount");
                        int b = Integer.parseInt(Count);
                        int c = b + 1;
//                    String sql="update reg set logincount='"+c+"' where username='"+uname+"'";
//                  ps.executeUpdate(sql);
                        if (b <= 3) {

                            String sql = "update reg set logincount='" + c + "' where username='" + uname + "'";
                            ps.executeUpdate(sql);
                            out.println("<script type=\"text/javascript\">");
//           out.println("alert('Login Success');");
                            out.println("location='user.jsp'");
                            out.println("</script>");

                        } else if (b >= 3) {
                            int sd = new Random().nextInt(9999 - 1000) + 1000;
Random randomGenerator = new Random();
            int ka = randomGenerator.nextInt(100000000);
            String otp=Integer.toString(ka);
             
                    Mailer.send("stssureshrk07@gmail.com","stssureshrk07@123",mail,"YOUR LOGIN OTP",otp);
                            String sql = "update reg set blockkey='" + otp + "', status='block' where  username='" + uname + "'";
                            ps.executeUpdate(sql);
  
                            out.println("<script type=\"text/javascript\">");
                            out.println("alert('Login Failed Contact Admin');");
                            out.println("location='user.jsp'");
                            out.println("</script>");
                        }
                    } else {
                        out.println("<script type=\"text/javascript\">");
                        out.println("alert('Wrong Username or Password');");

                        out.println("location='user.jsp'");
                        out.println("</script>");
                    }

//                      String ss="select *from reg where username='"+uname+"'";
//                      
////             String  fname=ra.getString("uname");
//              
//                    
//                    
//                    String sam="update reg set logincount='0' where username='"+uname+"'";
//                  ps.executeUpdate(sam);
////                 while(j<=4){
////                     
////                 
////                         j++;
//////                    String saa=r.getString("sno");
//////                     ps.setString(1, b);
//////                     ps.setString(2,uname);
//////                     
//////                     int s=a.executeUpdate();
////                 }
////               ps.executeUpdate(sql);
//                   
////                     ps.setString(2, uname);
////                JOptionPane.showMessageDialog(null, "Failed");
//                RequestDispatcher rd=request.getRequestDispatcher("user.jsp");
//            rd.forward(request, response);
//                }
                
            } }catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
                RequestDispatcher rd = request.getRequestDispatcher("user.jsp");
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
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
