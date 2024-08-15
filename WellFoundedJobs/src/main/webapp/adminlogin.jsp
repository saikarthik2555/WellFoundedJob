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
  <h2><a href="">Job Portal</a></h2>
  <h2><a href="">Home</a></h2>
  <h3><img src="images\usericon.png" width="20" height="20"><a href="candidateregistered">Candidate Registered</a></h3>
  <h3><img src="images\recruitericon.png" width="20" height="20"><a href="recuiterregistered">Recruiter Registered</a></h3>
  <h3><img src="images\adminicon.webp" width="20" height="20"><a href="adminprofile"><%out.println(request.getAttribute("adminname")); %></a></h3>
  <h3><a href="">About Us</a></h3>
  <h3><a href="adminlogout">Log Out</a></h3>
  </header>
  </body>
</html>
