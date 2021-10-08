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
          <li class="active"><a href="details.jsp"><span>USER DETAILS</span></a></li><!--
-->       <li><a href="userresponse.jsp"><span>ACCEPT RESPONSE</span></a></li>
           <li><a href="status.jsp"><span>STATUS</span></a></li>
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
        <!--<div style="margin-top: 100px">-->
            <table border="2px">
        
       
   
            <tr><th style="color: black">username</th><th style="color: black">filename</th><th style="color: black"><th style="color: black">filepath</th><th style="color: black"><th style="color: black"> key</th><th style="color: black">Checksum</th><th style="color: black">status</th></tr>
            
            <%
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/pollution","root","root");
                PreparedStatement ps=con.prepareStatement("select * from imm");
                ResultSet rs=ps.executeQuery();
                
                
                while(rs.next()){
                    
                    String naa=rs.getString("username");
                    String fn=rs.getString("filename");
                     String fpp=rs.getString("filepath");
//                      String fc=rs.getString("filecontent");
                    String fp=rs.getString("key1");
                     String f=rs.getString("checksum");
                      String status=rs.getString("status");
                    
                     
                     %>
                    
                         <input type="text" name="clo" value="<%=fp%>" hidden="">
                             <tr><td style="color: black"><%=naa%></td><td style="color: black"><%=fn%></td><td style="color: black"><td style="color: black"><%=fpp%></td><td style="color: black"></td><td style="color: black"><%=fp%></td><td style="color: black"><%=f%></td><td style="color: black"><%=status%></td></tr>
                     
                     
                     
               <% 
} }
            catch(Exception g){
                JOptionPane.showMessageDialog(null, g);
                
            }
           
            
            %>
            </table>
            
            </center>
                   
        </div>
        </div>
        <div class="clr"></div>
      
      <div class="clr"></div>
    </div>
  
 
 
</body>
</html>

     