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
<body onload="noBack()" onpageshow="if (event.presisted) noBack();" onUnload="" >
<div class="main">
  <div class="header">
    <div class="header_resize">
      <div class="menu_nav">
        <ul>
            <li ><a href="home.jsp"><span>HOME</span></a></li>
             <li class="active"><a href="profile.jsp"><span>PROFILE</span></a></li>
            
          <li ><a href="upload.html"><span>FILES UPLOAD</span></a></li>
          <li ><a href="view.jsp"><span>VIEW FILE</span></a></li>
          <li ><a href="request.jsp"><span>REQUEST</span></a></li>
          <li ><a href="download.jsp"><span>DOWNLOAD</span></a></li>
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
        
         <%
             String na=(String)session.getAttribute("nam");
            %>
        <center>
            
            <table border="2px">
            <tr><th style="color:black" >username</th><th style="color:black" >mailid</th><th style="color:black" >gender</th><th style="color:black" >dob</th><th style="color:black" >contact</th></tr>
             <%
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/pollution","root","root");
                PreparedStatement ps=con.prepareStatement("select * from reg where username=?"); 
                ps.setString(1, na);
                ResultSet rs=ps.executeQuery();
                while(rs.next()){
                    
                    String name=rs.getString("username");
                    String mail=rs.getString("mailid");
                    String gen=rs.getString("gender");
                    String dob=rs.getString("dob");
                    String conn=rs.getString("contact");
          
               %> 
            
            <tr><td style="color:black"><%=name%></td><td style="color:black"><%=mail%></td><td style="color:black"><%=gen%></td><td style="color:black"><%=dob%></td><td style="color:black"><%=conn%></td></tr>
            
               <% 
            }}
            catch(Exception g){
                JOptionPane.showMessageDialog(null, g);
                
            }
            
            %>
            
            
            
        </table>
             </center>
       
        </div>
        <div class="clr"></div>
      
      <div class="clr"></div>
    </div>
  </div>
  
</body>
</html>

     