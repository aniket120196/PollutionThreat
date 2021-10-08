<%@page import="javax.swing.JOptionPane"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>VictoryPro</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/coin-slider.css" />
<script type="text/javascript" src="js/cufon-yui.js"></script>
<script type="text/javascript" src="js/cufon-georgia.js"></script>
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript" src="js/coin-slider.min.js"></script>
<script type="text/javascript" src="js/noback.js"></script>
</head>
<body onload="noBack()" onpageshow="if (event.presisted) noBack();" onUnload="">
<div class="main">
  <div class="header">
    <div class="header_resize">
      <div class="menu_nav">
        <ul>
            <li ><a href="home.jsp"><span>HOME</span></a></li>
             <li ><a href="profile.jsp"><span>PROFILE</span></a></li>
            
          <li ><a href="upload.html"><span>FILES UPLOAD</span></a></li>
          <li ><a href="view.jsp"><span>VIEW FILE</span></a></li>
          <li ><a href="request.jsp"><span>REQUEST</span></a></li>
          <li class="active" ><a href="download.jsp"><span>DOWNLOAD</span></a></li>
           <li ><a href="user.jsp"><span>LOGOUT</span></a></li>-

        </ul>
     </div>
      <div class="clr"></div>
      <div class="slider">
        <div id="coin-slider"> <a href="#"><img src="images/image.jpg" width="960" height="480" alt="" /></a> <a href="#"><img src="images/image1.jpg" width="960" height="360" alt="" /></a> <a href="#"><img src="images/image2.jpg" width="960" height="360" alt="" /></a> </div>
        <div class="clr"></div>
      </div>
        <!--<a href="#"><img src="images/image.jpg" width="960" height="360"  /></a>--> 
         <!--<div class="slider">-->
             
      </div>
         <center>
              <table border="2px">
                   <tr><th style="color: black"> S.No</th><th style="color: black">User Name</th><th style="color: black">File Name</th><th style="color: black">Private key</th><th style="color: black">Public Key</th><th style="color: black">Download</th></tr>
        <% 
//           
            try{
                String usernam = (String)session.getAttribute("nam");
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pollution","root","root");

//                
                String sa="Select * from imm where username=? and status=?";
//                
            PreparedStatement pr=con.prepareStatement(sa);
            pr.setString(1,usernam );
            pr.setString(2,"accept" );
            ResultSet rs=pr.executeQuery();

                while(rs.next()){
                
                  String sno=rs.getString("sno");
                  String username=rs.getString("username");
                  String filename=rs.getString("fileName");
                  String privatekey=rs.getString("key1");
                  String publickey=rs.getString("key2");
                 
                  
                
           
            
            %>
            <form action="download" method="post">
                
                <input type="text" name="un" value="<%=username%>" hidden="">
                    <input type="text" name="sno" value="<%=publickey%>" hidden="">
                <tr id="da"><td style="color: black"><%=sno%></td><td style="color: black"><%=username%></td><td style="color: black"><%=filename%></td><td style="color: black"><%=privatekey%></td><td style="color: black"> <input type="text" name="key" value="<%=publickey%>"></td>
                    
                    <td><input type="submit" value="download" style="background-color: greenyellow"></td>
                  
                </tr>
            </form>
            <%
             } } 
            
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            
            }
            %>
            
              </table>
              
          </center>
         
       
        </div>
        <div class="clr"></div>
      
      <div class="clr"></div>
    </div>
  </div>
  <div class="content">

  </div>

</body>
</html>

     