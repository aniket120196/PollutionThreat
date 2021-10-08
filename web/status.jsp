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
            <li ><a href="new.jsp"><span>HOME</span></a></li>
          
          <li><a href="cloud.jsp"><span>UPLOAD DETAILS</span></a></li>
          <li><a href="details.jsp"><span>USER DETAILS</span></a></li><!--
-->      <li><a href="userresponse.jsp"><span>ACCEPT RESPONSE</span></a></li>
<li class="active"><a href="status.jsp"><span>STATUS</span></a></li>
          <li><a href="user.jsp"><span>LOGUT</span></a></li>   
        </ul>
      </div>

      <div class="clr"></div>
      <div class="slider">
        <div id="coin-slider"> <a href="#"><img src="images/image.jpg" width="960" height="480" alt="" /></a> <a href="#"><img src="images/image1.jpg" width="960" height="360" alt="" /></a> <a href="#"><img src="images/image2.jpg" width="960" height="360" alt="" /></a> </div>
        <div class="clr"></div>
      </div>
        <!--<a href="#"><img src="images/image.jpg" width="960" height="360"  /></a>--> 
         <!--<div class="slider">-->
            <center>
             
              
              <table border="2px">
                  <th><tr><td><a>USER NAME</a></td><td><a>MAIL ID</a></td><td><a>GENDER</a></td><td><a>STATUS</a></td><td><a>UNBLOCK USER</a></td></tr></th>
                  <%
                      

                      try{
                          
                          
                      
                          Class.forName("com.mysql.jdbc.Driver");
                          Connection con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/pollution","root","root");
                          PreparedStatement ps=con.prepareStatement("select * from reg where status='block'");
                          ResultSet rs=ps.executeQuery();
                          while(rs.next()){
                              
                              String user=rs.getString("username");
                              String mail=rs.getString("mailid");
                              String gender=rs.getString("gender");
                              
                              String status=rs.getString("status");
                          
                          
                          
                          
                          
                      
                  
                  
                  
                  %>
                  
                   <form action="status" method="post">
                       <input type="text" name="na" value="<%=user%>" hidden="">
                  <input type="text" name="ch" value="<%=mail%>" hidden="">
                   <input type="text" name="fil" value="<%=gender%>" hidden="">
                    <input type="text" name="status" value="<%=status%>" hidden="">    
                       <tr><td style="color: black"><%=user%></td><td style="color: black"><%=mail%></td><td style="color: black"><%=gender%></td><td style="color: black"><%=status%></td><td><input type="submit" value="submit"></td></tr> 
                     
                     
                  </form>
                  <%
                          }} catch(Exception e){
                      JOptionPane.showMessageDialog(null, e);
                          }
                  %>
               
              </table>
                  
       
             
          </center>
        
      </div>
     
   
                               
                        
       
        </div>
        <div class="clr"></div>
      
      <div class="clr"></div>
    </div>
  </div>
  
</body>
</html>

     