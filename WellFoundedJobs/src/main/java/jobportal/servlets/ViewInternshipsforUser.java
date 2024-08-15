package jobportal.servlets;

import java.util.ArrayList;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jobportal.dao.ViewInternshipsDao;
import jobportal.entity.InternshipProperties;
import jobportal.entity.UserBean;

@SuppressWarnings("serial")
@WebServlet("/viewinternships")				//for User
public class ViewInternshipsforUser extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res) {
		HttpSession hs=req.getSession(false);
		try {
		if(hs==null) {
			req.setAttribute("msg", "Session Expired please log-in again");
			req.getRequestDispatcher("userlogin.jsp").forward(req, res);
			return;
		}

			ArrayList<InternshipProperties> alist=new ViewInternshipsDao().viewAllInternships();
			hs.setAttribute("internshiplist", alist);	
			UserBean ub=(UserBean)hs.getAttribute("userbean");
			req.setAttribute("username", ub.getFullname());
			req.setAttribute("msg", "All Internships");
			req.getRequestDispatcher("viewinternships.jsp").forward(req, res);    //for User
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
