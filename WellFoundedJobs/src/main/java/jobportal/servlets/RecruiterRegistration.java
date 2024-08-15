package jobportal.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jobportal.dao.RecruiterRegistrationDao;

@SuppressWarnings("serial")
@WebServlet("/recruiterregistration")
public class RecruiterRegistration extends HttpServlet{
		public int i;
		@Override
		protected void doPost(HttpServletRequest req,HttpServletResponse res) {
			String companyName=req.getParameter("recruitername").toUpperCase();
			String mailid=req.getParameter("mailid");
			String pswd=req.getParameter("pswd");
			Long phno=Long.parseLong(req.getParameter("contact"));
			String location=req.getParameter("location");
			
			 i=new RecruiterRegistrationDao().registerUser(companyName,mailid,pswd,phno,location);
			try {
			if(i>0) {
				req.setAttribute("msg","Registered Successfully, Please Log In ");
				req.getRequestDispatcher("recruiterregistration.jsp").forward(req, res);
			}else {
				req.setAttribute("msg", "Not Registered, please register with New Email Id");
				req.getRequestDispatcher("recruiterregistration.jsp").forward(req, res);
			}
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

}
