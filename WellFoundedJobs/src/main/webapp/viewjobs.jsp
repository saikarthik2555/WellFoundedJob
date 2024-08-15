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
  <nav>
  <h3 align="center"><% out.println(request.getAttribute("msg")); %> </h3>
  <form action="sortByLocYearDept" method="GET" class="flex-form">
  <div class="group">
  <label>Year</label>
  <select id="batch" name="batch" >
  <option value="21">2021</option>
  <option value="22">2022</option>
  <option value="23">2023</option>
  <option value="24">2024</option>
  <option value="0" >All</option>
  </select><br>
  </div>
  <div class="group">
  <label>Location</label>
  <select id="loc" name="loc" >
  <option>Hyderabad</option>
  <option>Chennai</option>
  <option>Bangalore</option>
  <option>Pune</option>
  <option>Delhi</option>
  <option>Mumbai</option>
  <option>All Locations</option>
  </select><br>
  </div>
  <div class="group">
  <label>Department</label>
  <select id="dept" name="dept" >
  <option>Software Development</option>
  <option>System & Network Administration</option>
  <option>Cyber Security</option>
  <option>DataBase Administration</option>
  <option>Quality Assurance</option>
  <option>Research & Development</option>
  <option>Product Manager</option>
  <option>Customer & Client Services</option>
  <option>Human Resources</option>
  <option>Finance & Accounting</option>
  <option>Banking</option>
  <option>Marketing & Sales</option>
  <option>Government</option>
  <option>All Departments</option>
  </select><br>
  </div>
  <button type="submit">Sort</button>
  </form>
   </nav>

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
  ArrayList<JobProperties> alist=(ArrayList<JobProperties>)session.getAttribute("jobs"); 
  if(alist!=null){
Iterator<JobProperties> i=alist.iterator();
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
  <input type="text" placeholder="vacancy : <% out.println(jp.getVacancy()); %>" readonly>
  <input type="text" placeholder="salary : <% out.println(jp.getSalary()); %>" readonly>
  <input type="text" placeholder="experience : <% out.println(jp.getExperience()); %>" readonly>
  <input type="text" placeholder="location : <% out.println(jp.getLocation()); %>" readonly>
  <input type="text" placeholder="passout : <% out.println(jp.getYop()); %>" readonly><br>
  <label>Last Date for Applying: </label><h3><% out.println(jp.getDate()); %></h3>
 <a id="btn" href="applyjob?applyUsingJobSlno=<%=jp.getSlno()%>&applyUsingUserSlno=<%=ub.getIdentity()%>&resumeName=<%=ub.getFilename()%>">Apply</a>
  
  </div>
  </section>
  <%
  }
  }
  %>
  </div>
 </body>
</html>




<%--      //for table format
  <section>
  <table id="center" border>
  <caption>Latest Jobs</caption>
  <thead><tr><th>Company Name</th><th>Job Title</th><th>Last Date</th><th>Job Desciption</th><th>Location</th><th>Action&nbsp;&nbsp;&nbsp;</th><tr></thead>
  <tbody>-->
   <%
 ArrayList<JobProperties> alist=(ArrayList<JobProperties>)session.getAttribute("jobs"); 
  if(alist!=null){
Iterator<JobProperties> i=alist.iterator();
while(i.hasNext()){
	JobProperties jp=i.next();

  %> 
	<tr>
	<td><% out.println(jp.getCompanyName()); %></td><td><% out.println(jp.getTitle()); %></td><td><% out.println(jp.getDate()); %></td><td><% out.println(jp.getDescription()); %></td><td><% out.println(jp.getLocation()); %></td><td><a href="">apply</a></td>
	</tr>
	<%
	}
  }
	%>
	   </tbody>
  <tfoot></tfoot>
	
  </table>
  </section>
   --%>