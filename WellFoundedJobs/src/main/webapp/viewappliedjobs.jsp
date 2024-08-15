<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="jobportal.entity.UserBean,jobportal.entity.JobProperties,java.util.*"%>
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
  <h2><a href="userloginsuccess.jsp">Home</a></h2>
  <%UserBean ub=(UserBean)session.getAttribute("userbean");%>
  <h3><img src="images\usericon.png" width="20" height="20"><a href="appliedapplications?userSlno=<%=ub.getIdentity()%>">Applied Applications</a></h3>
  <h3><img src="images\recruitericon.png" width="20" height="20"><a href="viewjobs">View Jobs</a></h3>
  <h3><img src="images\adminicon.webp" width="20" height="20"><a href="viewinternships">View Internships</a></h3>
  <h3><a href="userprofile"><%out.println(ub.getFullname());%></a></h3>
  <h3><a href="userlogout">Log Out</a></h3>
  </header>	

  <h3 align="center"><% out.println(request.getAttribute("msg")); %> </h3>


   <div class="main">
  <aside id="aside">
  <div><a href="">Internships</a></div>
  <div><a href="">Projects</a></div>
  <div><a href="">News</a></div>
  <div><a href="">Blogs</a></div>
  <div><a href="">Tech Industry</a></div>
  <div><a href="">Resume Building</a></div>
  <div><a href="">Interview Questions</a></div>
  <div><a href="">Mock Tests</a></div>
  <div><a href="">Events</a></div>
  <div><a href="">Concept of the Day</a></div>
  <div><a href="">Question Papers</a></div>
  <div><a href="">Free Courses</a></div>
  <div><a href="">Applied Jobs</a></div>
  </aside>
  <% 
  ArrayList<JobProperties> appliedjobs=(ArrayList<JobProperties>)session.getAttribute("appliedjobs"); 
  if(appliedjobs!=null){
Iterator<JobProperties> i=appliedjobs.iterator();
while(i.hasNext()){
	JobProperties jp=i.next();
  %>
  <section>
  <div class="data">
  <h3 align="right"><% out.println(jp.getCompanyName()); %></h3>
  <h3><% out.println(jp.getTitle()); %></h3>  
  <h4><% out.println(jp.getDescription()); %></h4>
  <br>
  <input type="text" placeholder="Skills :<% out.println(jp.getSkills()); %> " readonly>
  <input type="text" placeholder="department :<% out.println(jp.getDepartment()); %> " readonly>
  <input type="text" placeholder="salary : <% out.println(jp.getSalary()); %>" readonly>
  <input type="text" placeholder="location : <% out.println(jp.getLocation()); %>" readonly>
  <input type="text" placeholder="recruiter mail id : <% out.println(jp.getRecruiterMaildid()); %>" readonly><br>
  <label>Last Date for Attending: </label><h3><% out.println(jp.getDate()); %></h3>
  
  </div>
  </section>
  <%
  }
  }
  %>
  </div>
 </body>
</html>
