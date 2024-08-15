package jobportal.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jobportal.entity.UserBean;

@SuppressWarnings("serial")
@WebServlet("/userprofile")
public class UserProfile extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res) {
		HttpSession hs=req.getSession(false);
		try {
		if(hs==null) {
		req.setAttribute("msg", "Session Expired please login again ");	
		req.getRequestDispatcher("userlogin.jsp").forward(req, res);
		return;
		}
		
		UserBean ub=(UserBean)hs.getAttribute("userbean");
		req.setAttribute("userName", ub.getFullname());
		req.getRequestDispatcher("userdata.jsp").forward(req, res);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
