<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="jobportal.entity.RecruiterBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Job Portal</title>
 <link rel="stylesheet" href="adminregistration.css">
</head>
<body>
  <header>
  <h2><a href="">Job Portal</a></h2>
  <h2><a href="recruiterloginsuccess.jsp">Home</a></h2>
 <%  RecruiterBean rb=(RecruiterBean)session.getAttribute("recruiter");%>
  <h3><img src="images\usericon.png" width="20" height="20"><a href="receivedapplicants?recruiterCompany=<%=rb.getCompanyName()%>">Received Applications</a></h3>
  <h3><img src="images\recruitericon.png" width="20" height="20"><a href="viewjobsforrecruiter">View Jobs</a></h3>
  <h3><img src="images\recruitericon.png" width="20" height="20"><a href="viewinternshipsforrecruiter">View Internships</a></h3>
  <h3><img src="images\adminicon.webp" width="20" height="20"><a href="postjob.html">Post Job</a></h3>
  <h3><img src="images\recruitericon.png" width="20" height="20"><a href="postinternship.html">Post Internship</a></h3> 
  <h3><a href="recruiterprofile"><%out.println(rb.getCompanyName()); %></a></h3>
  <h3><a href="recruiterlogout">Log Out</a></h3>
  </header>	
  <section>
  <div class="img">
  <img src="images\recruiterlogin.jpg" width="400" height="350">
  </div>
  </section>
 </body>
</html>