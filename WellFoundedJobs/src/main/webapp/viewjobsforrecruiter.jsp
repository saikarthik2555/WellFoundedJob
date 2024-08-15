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
 <%  RecruiterBean rb=(RecruiterBean)session.getAttribute("recruiter");%>
 <h3><img src="images\usericon.png" width="20" height="20"><a href="receivedapplicants?recruiterCompany=<%=rb.getCompanyName()%>">Received Applications</a></h3>
  <h3><img src="images\recruitericon.png" width="20" height="20"><a href="viewjobsforrecruiter">View Jobs</a></h3>
<h3><img src="images\recruitericon.png" width="20" height="20"><a href="viewinternshipsforrecruiter">View Internships</a></h3>
  <h3><img src="images\adminicon.webp" width="20" height="20"><a href="postjob.html">Post Job</a></h3>
  <h3><img src="images\adminicon.webp" width="20" height="20"><a href="postinternship.html">Post Internship</a></h3>
  <h3><a href="recruiterprofile"><%out.println(request.getAttribute("companyName")); %></a></h3>
  <h3><a href="recruiterlogout">Log Out</a></h3>
  </header>	
  <h3 align="center"><% out.println(request.getAttribute("msg")); %></h3>
  <% 
 ArrayList<JobProperties> alist=(ArrayList<JobProperties>)session.getAttribute("arraylist"); 
  if(alist!=null){
Iterator<JobProperties> i=alist.iterator();
while(i.hasNext()){
	JobProperties data=i.next();

  %>
  <section>
  <div class="data">
  <h3><% out.println(data.getTitle()); %></h3>
  <p><% out.println(data.getDescription()); %></p>
  <br>
  <input type="text" placeholder="department :<% out.println(data.getDepartment()); %> " readonly>
  <input type="text" placeholder="vacancy : <% out.println(data.getVacancy()); %>" readonly>
  <input type="text" placeholder="salary : <% out.println(data.getSalary()); %>" readonly>
  <input type="text" placeholder="experience : <% out.println(data.getExperience()); %>" readonly>
  <input type="text" placeholder="location : <% out.println(data.getLocation()); %>" readonly>
  <input type="text" placeholder="passout : <% out.println(data.getYop()); %>" readonly>
  <input type="text" placeholder="skills : <% out.println(data.getSkills()); %>" readonly><br>
  
  <label>Last Date : </label><h3><% out.println(data.getDate()); %></h3>
  </div>

  <div class="btn">
  <a href="editjob?editUsingSlno=<%=data.getSlno()%>">Edit</a>
  <a href="deletejob?deleteUsingSlno=<%=data.getSlno()%>">Delete</a>
  </div>
  </section>
  <%
  }
  }
  %>
 </body>
</html>