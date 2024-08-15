package jobportal.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/recruiterlogout")
public class RecruiterLogout extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res) {
		HttpSession hs=req.getSession(false);
		try {
		if(hs==null) {
			req.setAttribute("msg", "Session Expired please log-in again");
			req.getRequestDispatcher("recruiterregistration.jsp").forward(req, res);
			return;
		}
		hs.removeAttribute("recruiter");
		hs.invalidate();
		req.setAttribute("msg","Successfully Logout");
		req.getRequestDispatcher("recruiterregistration.jsp").forward(req, res);
		
	}catch(Exception e) {
		e.printStackTrace();
	}
  }

}
