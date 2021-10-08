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
          <li ><a href="request.jsp"><span>REQUEST</span></a></li>
          <li ><a href="uploadfile.jsp"><span>USER UPLOAD</span></a></li>
          <li ><a href="view.jsp"><span>VIEW FILE</span></a></li>
           <li ><a href="user.jsp"><span>LOGOUT</span></a></li>

        </ul>
      </div>

      <div class="clr"></div>
     
        <a href="#"><img src="images/image.jpg" width="960" height="360"  /></a> 
         <div class="slider">
             
      </div>
        
          <center>
              <form action="uploadcloud" method="post">
             
              <table>
                  <tr><th>S.No</th><th>Username</th><th>File Name</th><th>File Path</th><th>Key</th></tr>
                  <%
                      

                      try{
                          
                          
                      
                          Class.forName("com.mysql.jdbc.Driver");
                          Connection con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/pollution","root","root");
                          PreparedStatement ps=con.prepareStatement("select * from imm where status='encrypt'");
                          ResultSet rs=ps.executeQuery();
                          while(rs.next()){
                              String sno=rs.getString(1);
                              String user=rs.getString(2);
                              String filename=rs.getString(3);
                              String filepath=rs.getString(4);

                              String key=rs.getString(5);
                              
                          
                          
                          
                          
                          
                      
                  
                  
                  
                  %>
                  
                
                   
                      <tr><td style="color: black"><%=sno%></td><td style="color: black"><%=user%></td><td style="color: black"><%=filename%></td><td style="color: black"><%=filepath%></td><td style="color: black"><input type="text" name="key" value="<%=key%>"></td></tr> 
                      
                          
                 
                  <%
                          }} catch(Exception e){
                      JOptionPane.showMessageDialog(null, e);
                          }
                  %>
               
              </table>
                   <input type="submit">
     
              </form>
          </center>
        
       
        </div>
        <div class="clr"></div>
      
      <div class="clr"></div>
    </div>
  </div>
 
</body>
</html>

     