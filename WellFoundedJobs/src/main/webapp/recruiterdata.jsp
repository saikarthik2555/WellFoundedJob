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
  <h2><a href="recruiterloginsuccess.jsp">Home</a></h2>
  <%  RecruiterBean rb=(RecruiterBean)session.getAttribute("recruiter");  %>
 <h3><img src="images\usericon.png" width="20" height="20"><a href="receivedapplicants?recruiterCompany=<%=rb.getCompanyName()%>">Received Applications</a></h3>
  <h3><img src="images\recruitericon.png" width="20" height="20"><a href="viewjobsforrecruiter">View Jobs</a></h3>
  <h3><img src="images\recruitericon.png" width="20" height="20"><a href="viewinternshipsforrecruiter">View Internships</a></h3>
  <h3><img src="images\adminicon.webp" width="20" height="20"><a href="postjob.html">Post Job</a></h3>
  <h3><img src="images\recruitericon.png" width="20" height="20"><a href="postinternship.html">Post Internship</a></h3>
  <h3><a href="recruiterprofile"><%out.println(request.getAttribute("companyName")); %></a></h3>
  <h3><a href="recruiterlogout">Log Out</a></h3>
  </header>	
  <section>
  <div class="data">
  <h3 align="right"><% out.println(rb.getCompanyName()); %></h3>
   <label>Recruiter Mail Id</label><input type="text" placeholder="recruiter mailid : " value="<%= rb.getEmailid()%>" readonly><br>
   <label>Contact Number</label><input type="number" placeholder="contact no : " value="<%= rb.getPhno() %>" readonly><br>    
   <label>Location</label><input type="text" name="location" placeholder="location : " value="<%=rb.getLocation()%>" readonly><br>
  </div>
  </section>
 </body>
</html>