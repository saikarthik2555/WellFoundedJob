package jobportal.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jobportal.entity.RecruiterBean;

@SuppressWarnings("serial")
@WebServlet("/recruiterprofile")
public class RecruiterProfile extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res) {
		HttpSession hs=req.getSession(false);
		try {
		if(hs==null) {
		req.setAttribute("msg", "Session Expired please login again ");	
		req.getRequestDispatcher("recruiterlogin.jsp").forward(req, res);
		return;
		}
		
		RecruiterBean rb=(RecruiterBean)hs.getAttribute("recruiter");
		req.setAttribute("companyName", rb.getCompanyName());
		req.getRequestDispatcher("recruiterdata.jsp").forward(req, res);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
