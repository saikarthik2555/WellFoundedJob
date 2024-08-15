<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,jobportal.entity.*" %>
<!DOCTYPE html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <title>Job Portal</title>
  <link rel="stylesheet" href="editdata.css">
 </head>
 <body>
  <header>
  <h2><a href="">Job Portal</a></h2>
  <h2><a href="userloginsuccess.jsp">Home</a></h2>
  <%  UserBean ub=(UserBean)session.getAttribute("userbean");  %>
  <h3><img src="images\usericon.png" width="20" height="20"><a href="appliedapplications?userSlno=<%=ub.getIdentity()%>">Applied Applications</a></h3>
  <h3><img src="images\recruitericon.png" width="20" height="20"><a href="userloginsuccess.jsp">View Jobs</a></h3>
  <h3><img src="images\adminicon.webp" width="20" height="20"><a href="viewinternships">View Internships</a></h3>
  <h3><a href="userprofile"><%out.println(request.getAttribute("userName")); %></a></h3>
  <h3><a href="userlogout">Log Out</a></h3>
  </header>	
  <section>
  <div class="data">
  <h3 align="right"><% out.println(ub.getFullname()); %></h3>
   <label>Mail Id</label><input type="text" value="<%= ub.getEmail()%>" readonly><br>
   <label>Qualifications</label><input type="text" value="<%=ub.getQualification()%>" readonly><br>    
   <label>Phone Number</label><input type="text"  value="<%=ub.getPhno()%>" readonly><br>
   <label>Location</label><input type="text"  value="<%=ub.getLocation()%>" readonly><br>
   <label>State</label><input type="text"  value="<%=ub.getState()%>" readonly><br>
   <label>Gender</label><input type="text"  value="<%=ub.getGender()%>" readonly><br>
 <label>Year Of Pass Out</label><input type="text"  value="<%=ub.getYop()%>" readonly><br>
 <label>Date Of Birth</label><input type="text"  value="<%=ub.getYob()%>" readonly><br>
  <label>Resume</label><input type="text"  value="<%=ub.getFilename()%>" readonly><br>
 
 
  </div>
  </section>
 </body>
</html>