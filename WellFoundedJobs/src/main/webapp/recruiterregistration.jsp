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
<h2 align="center">Recruiter Registration</h2><br>
    <h3 align="right"><%out.println(request.getAttribute("msg")); %></h3>
<form action="recruiterregistration" method="POST">
<label>Enter Company Name</label><br>
<input type="text" maxlength="35"  required name="recruitername">
<label>Enter Email</label><br>
<input type="email" name="mailid">
<label>Enter Contact Number</label><br>
<input type="number" name="contact">
<label>Enter Location</label><br>
<input type="text" name="location">
<label>Enter Password</label><br>
<input type="password" required name="pswd">
<button type="submit">Register</button> <hr>
<button style="margin-left:200px;" type="reset">Reset</button>
</form>
</div>
   <div class="img">
  <img src="images\recruiterregistra.png" height="350" width="350"><br>
  <a href="recruiterlogin.html">Log In </a>
  </div>
</section>
 </body>
</html>
