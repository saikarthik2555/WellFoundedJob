<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="jobportal.entity.*"%>
<!DOCTYPE html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <title>Job Portal</title>
  <link rel="stylesheet" href="adminregistration.css">
  <link rel="stylesheet" href="selecttag.css">
 </head>
 <body>
  <header>
  <h2><a href="">Job Portal</a></h2>
  <h2><a href="recruiterloginsuccess.jsp">Home</a></h2>
 <%  RecruiterBean rb=(RecruiterBean)session.getAttribute("recruiter");%>
 <h3><img src="images\usericon.png" width="20" height="20"><a href="receivedapplicants?recruiterCompany=<%=rb.getCompanyName()%>">Received Applications</a></h3>
  <h3><img src="images\recruitericon.png" width="20" height="20"><a href="viewjobsforrecruiter">View Jobs</a></h3>
   <h3><img src="images\recruitericon.png" width="20" height="20"><a href="viewinternshipsforrecruiter">View Internships</a></h3>
  <h3><img src="images\adminicon.webp" width="20" height="20"><a href="postjob.jsp">Post Job</a></h3>
<h3><img src="images\adminicon.webp" width="20" height="20"><a href="postinternship.jsp">Post Internship</a></h3>
  <h3><a href="recruiterprofile"><% out.println(request.getAttribute("companyName")); %></a></h3>
  <h3><a href="recruiterlogout">Log Out</a></h3>
  </header>	
   <section>
   <div class="login">
    <h3 align="center"> &nbsp;&nbsp;&nbsp; <%out.println(request.getAttribute("msg")); %></h3>
  <form action="postjob" method="POST">
  <label>Enter Job Title</label><br>
  <input type="text" name="title" autofocus maxlength="90"><br>
  <label>Choose Department</label>
  <select id="dept" name="dept">
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
  <option>other...(provide job department in description)</option>
  </select><br>
  
  <label>Select Experience</label>
  <select id="exp" name="exp">
  <option>Fresher - 1</option>
  <option>2 - 4</option>
  <option>4 - 6</option>
  <option>6 - 8</option>
  <option>8 - 10</option>
  <option>above 10 </option>
  </select><br>
  <label>Enter Vacancy</label><br>
  <input type="number" min="0" max="99999"name="vacancy"><br>  
  <label>Enter Salary</label><br>
  <input type="number" min="0" max="9999999" name="sal"><br>  
  <label>Enter Recruiter / Hiring Manager Mail Id</label><br>
  <input type="email" name="mailid" required maxlength="30"><br>  
  <label>Select Location</label>
  <select id="loc" name="loc">
  <option>Hyderabad</option>
  <option>Chennai</option>
  <option>Bangalore</option>
  <option>Pune</option>
  <option>Delhi</option>
  <option>Mumbai</option>
  <option>other</option>
  </select><br>
  <label>Choose Last Date for Applying</label><br>
  <input type="date" name="dt" min="2024-08-05" max="2050-12-31">
   <label>Eligible Batches</label><br>
<label>2021</label><input type="checkbox" id="c1" name="2021" value="21"><br>
<label>2022</label><input type="checkbox" id="c1" name="2022" value="22"><br>
<label>2023</label><input type="checkbox" id="c1" name="2023" value="23" ><br>
<label>2024</label><input type="checkbox" id="c1" name="2024" value="24"><br>
<label>2025</label><input type="checkbox" id="c1" name="2025" value="25"><br>
<label>All</label><input type="checkbox" id="c1" name="all" value="0"><br>
  <label>Skills</label><br>
  <input type="text" name="skills"  maxlength="55"><br>
  <label>Job Description</label><br>
  <textarea name="descrip" rows ="6" cols="60" maxlength="280" style="padding:3px;">
  </textarea>
  <button onclick="submit">Publish Job</button><hr><button type="reset">Refresh</button>
  </form>
  </div>
  <div class="img">
  <img src="images\postjob.jpg" width="400" height="350">
  </div>
  </section>
 </body>
</html>