package jobportal.servlets;

import java.util.ArrayList;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jobportal.dao.ViewJobsDao;
import jobportal.entity.JobProperties;
import jobportal.entity.UserBean;

@SuppressWarnings("serial")
@WebServlet("/viewjobs")				//for User
public class ViewJobsforUser extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res) {
		HttpSession hs=req.getSession(false);
		try {
		if(hs==null) {
			req.setAttribute("msg", "Session Expired please log-in again");
			req.getRequestDispatcher("userlogin.jsp").forward(req, res);
			return;
		}

			ArrayList<JobProperties> alist=new ViewJobsDao().viewAllJobs();
			hs.setAttribute("jobs", alist);	
			UserBean ub=(UserBean)hs.getAttribute("userbean");
			req.setAttribute("username", ub.getFullname());
			req.setAttribute("msg", "All Jobs");
			req.getRequestDispatcher("viewjobs.jsp").forward(req, res);    //for User
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
