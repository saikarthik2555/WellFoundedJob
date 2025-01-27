<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <title>Job Portal</title>
  <link rel="stylesheet" href="adminregistration.css">
 </head>
 <body>
  <header>
  <h2><a href="index.html">Job Portal</a></h2>
  <h2><a href="index.html">Home</a></h2>
  <h3><img src="images\usericon.png" width="20" height="20"><a href="userregistration.html">Candidate SignUp</a></h3>
  <h3><img src="images\recruitericon.png" width="20" height="20"><a href="recruiterregistration.html">Recruiter SignUp</a></h3>
  <h3><img src="images\adminicon.webp" width="20" height="20"><a href="adminregistration.html">Admin SignUp</a></h3>
  <h3><a href="">About Us</a></h3>
  </header>	  
    <section>
    <div class="login">
 <h1><% out.println(request.getAttribute("msg")); %></h1>
<h2 align="center">User Registration</h2><br>
<form action="userregistration" method="POST" enctype="multipart/form-data">
<label>Enter Full Name</label><br>
<input type="text" name="username">
<label>Enter Your Qualification</label><br>
<input type="text" name="qualification">
<label>Enter Email</label><br>
<input type="email" name="mailid">
<label>Enter Contact Number</label><br>
<input type="number" name="contact">
<label>Enter Location</label><br>
<input type="text" name="location">
<label>Enter State</label><br>
<input type="text" name="state">
<label>Choose Gender</label>
<select name="gender">
<option>Male</option>
<option>Female</option>
<option>Other</option>
</select><br>
<label>Enter Year Of Passing</label><br>
<input type="text" name="yop">
<label>Enter Date Of Birth</label><br>
<input type="date" name="dob" min="1990-01-01" max="2050-01-01">
<label><b>Upload Resume</b></label><br>
<input type="file" required name="resume">
<label>Enter Password</label><br>
<input type="password" name="pswd"><br>
<button type="submit">Register</button><button type="reset">Refresh</button>
</form>
</div>
   <div class="img">
  <img src="images\userregister.avif" height="350" width="350"><br>
  <a href="userlogin.html">Log In </a>
  </div>
</section>
 </body>
</html>
