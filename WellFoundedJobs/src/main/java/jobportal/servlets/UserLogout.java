package jobportal.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/userlogout")
public class UserLogout extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res) {
		HttpSession hs=req.getSession(false);
		try {
		if(hs==null) {
			req.setAttribute("msg", "Session Expired please log-in again");
			req.getRequestDispatcher("userregistration.jsp").forward(req, res);
			return;
		}
		hs.removeAttribute("userbean");
		hs.invalidate();
		req.setAttribute("msg","Successfully Logout");
		req.getRequestDispatcher("userregistration.jsp").forward(req, res);
		
	}catch(Exception e) {
		e.printStackTrace();
	   }
     }
	}
