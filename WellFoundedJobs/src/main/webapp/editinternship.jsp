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
  <h2><a href="">Home</a></h2>
  <h3><img src="images\usericon.png" width="20" height="20"><a href="">Received Applications</a></h3>
  <h3><img src="images\recruitericon.png" width="20" height="20"><a href="viewjobsforrecruiter">View Jobs</a></h3>
  <h3><img src="images\recruitericon.png" width="20" height="20"><a href="viewinternshipsforrecruiter">View Internships</a></h3>
  <h3><img src="images\adminicon.webp" width="20" height="20"><a href="postjob.html">Post Job</a></h3>
<h3><img src="images\adminicon.webp" width="20" height="20"><a href="postinternship.html">Post Internship</a></h3>
  <h3><a href="recruiterprofile">My Profile</a></h3>
  <h3><a href="recruiterlogout">Log Out</a></h3>
  </header>	
  <%  RecruiterBean rb=(RecruiterBean)session.getAttribute("recruiter");  %>
  <h3><% out.println(rb.getCompanyName()); %></h3>
  <% 
  InternshipProperties jp=(InternshipProperties)session.getAttribute("particularinternship"); 
  if(jp!=null){
  %>
  <section>
  <div class="data">
  <form action="updateinternship" method="POST">
  <h3><% out.println(jp.getTitle()); %></h3>
  <label>Job Description</label><input size="50" type="text" name="description" value="<%=jp.getDescription() %>" >
  <label>Department</label><input type="text" name="department" placeholder="department : " value="<%=jp.getDepartment() %>" >
   <label>Type</label><input type="text" name="type" placeholder="type : " value="<%= jp.getType() %>"><br>
   <label>Fee</label><input type="number" name="fee" placeholder="fee : " value="<%= jp.getFees() %>">
   <label>Duration</label><input type="number" name="duration" placeholder="duration : " value="<%=jp.getDuration() %>">
   <label>Location</label><input type="text" name="location" placeholder="location : " value="<%= jp.getLocation()%>"><br>
   <label>Batches</label><input type="number" name="batches"placeholder="passout : " value="<%= jp.getYop()%>">
   <label>Recruiter Mail Id</label><input type="text" placeholder="recruiter mailid : " value="<%= jp.getRecruiterMaildid()%>" readonly><br>
   <label>Skills </label><input type="text" name="skills" placeholder="skills : " value="<%= jp.getSkills()%>" ><br>
  <label>To Change Last Date for Applying: </label><h3><% out.println(jp.getDate()); %></h3>
  <input type="date" name="date" value="<%=jp.getDate()%>">
  
  <input type="hidden" name="slno" value="<%=jp.getSlno() %>">	<% // based on Serial Number we modify data // %>
  
 <div class="btn">
  <input type="submit" value="Submit">
  </div>
  </form>
  </div>
  </section>
  <%
  }else{
	  out.println(jp);
	  out.println("<h3 align='center'>+Job Not Found+</h3>");
  }
  %>
 </body>
</html>