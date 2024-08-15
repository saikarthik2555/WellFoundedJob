<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,jobportal.entity.InternshipProperties" %>
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
  <h3><img src="images\usericon.png" width="20" height="20"><a href="">Received Applications</a></h3>
  <h3><img src="images\recruitericon.png" width="20" height="20"><a href="viewjobsforrecruiter">View Jobs</a></h3>
   <h3><img src="images\recruitericon.png" width="20" height="20"><a href="viewinternshipsforrecruiter">View Internships</a></h3>
  <h3><img src="images\adminicon.webp" width="20" height="20"><a href="postjob.html">Post Job</a></h3>
    <h3><img src="images\adminicon.webp" width="20" height="20"><a href="postinternship.html">Post Internship</a></h3>
  <h3><a href="recruiterprofile"><%out.println(request.getAttribute("companyName")); %></a></h3>
  <h3><a href="recruiterlogout">Log Out</a></h3>
  </header>	
  <h3 align="center"><% out.println(request.getAttribute("msg")); %></h3>
  <% 
 ArrayList<InternshipProperties> alist=(ArrayList<InternshipProperties>)session.getAttribute("internships"); 
  if(alist!=null){
Iterator<InternshipProperties> i=alist.iterator();
while(i.hasNext()){
	InternshipProperties data=i.next();

  %>
  <section>
  <div class="data">
  <h3><% out.println(data.getTitle()); %></h3>
  <p><% out.println(data.getDescription()); %></p>
  <br>
  <input type="text" placeholder="department :<% out.println(data.getDepartment()); %> " readonly>
  <input type="text" placeholder="fee : <% out.println(data.getFees()); %>" readonly>
  <input type="text" placeholder="type : <% out.println(data.getType()); %>" readonly>
  <input type="text" placeholder="duration : <% out.println(data.getDuration()); %>" readonly>
  <input type="text" placeholder="location : <% out.println(data.getLocation()); %>" readonly>
  <input type="text" placeholder="passout : <% out.println(data.getYop()); %>" readonly>
  <input type="text" placeholder="skills : <% out.println(data.getSkills()); %>" readonly><br>
  
  <label>Last Date : </label><h3><% out.println(data.getDate()); %></h3>
  </div>
  <%
  Integer slno=data.getSlno();
  %>
  <div class="btn">
  <a href="editinternship?editUsingSlno=<%=slno%>">Edit</a>
  <a href="deleteinternship?deleteUsingSlno=<%=slno%>">Delete</a>
  </div>
  </section>
  <%
  }
  }
  %>
 </body>
</html>