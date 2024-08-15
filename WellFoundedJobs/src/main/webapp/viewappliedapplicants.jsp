<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="jobportal.entity.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Job Portal</title>
 <link rel="stylesheet" href="userjobdetails.css">
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
    <% 
  ArrayList<UserBean> appliedjobs=(ArrayList<UserBean>)session.getAttribute("appliedapplicants"); 
  if(appliedjobs!=null){
Iterator<UserBean> i=appliedjobs.iterator();
while(i.hasNext()){
	UserBean ub=i.next();
  %>
  <section>
  <div class="data">
  <h3 align="right"><% out.println(rb.getCompanyName()); %></h3>
  <h3><% out.println(ub.getPswd()); %></h3>  
  <h4><% out.println(ub.getState()); %></h4>
  <br>
  <input type="text" placeholder="Name :<% out.println(ub.getFullname()); %> " readonly>
  <input type="text" placeholder="Qualifications :<% out.println(ub.getQualification()); %> " readonly>
  <input type="text" placeholder="Email id  : <% out.println(ub.getEmail()); %>" readonly>
  <input type="text" placeholder="Location : <% out.println(ub.getLocation()); %>" readonly>
  <input type="text" placeholder="Gender : <% out.println(ub.getGender()); %>" readonly>
  <input type="text" placeholder="Phone No : <% out.println(ub.getPhno()); %>" readonly><br>
  <input type="text" placeholder="Year Of Passout : <% out.println(ub.getYop()); %>" readonly>
  <input type="text" placeholder="Last Date Of Application : <% out.println(ub.getYob()); %>" readonly><br>
  <label>Download Resume : </label><h3><a href="download?resumeName=<%=ub.getFilename()%>">download</a></h3>
  
  </div>
  </section>
  <%
  }
  }
  %>
 </body>
</html>