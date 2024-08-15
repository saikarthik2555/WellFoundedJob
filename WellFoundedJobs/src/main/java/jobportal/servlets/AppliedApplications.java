package jobportal.servlets;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jobportal.dao.ViewJobsDao;
import jobportal.entity.JobProperties;
import jobportal.entity.UserBean;

@SuppressWarnings("serial")
@WebServlet("/appliedapplications")
public class AppliedApplications extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs=req.getSession(false);
		try {
		if(hs==null) {
			req.setAttribute("msg", "Session Expired please log-in again");
			req.getRequestDispatcher("userlogin.jsp").forward(req, res);
			return;
		}

		Integer slno=Integer.parseInt(req.getParameter("userSlno"));
			ArrayList<JobProperties> appliedjobs=new ViewJobsDao().viewJobsBasedOnUserSlno(slno);
			hs.setAttribute("appliedjobs", appliedjobs);	
			UserBean ub=(UserBean)hs.getAttribute("userbean");
			req.setAttribute("username", ub.getFullname());
			req.setAttribute("msg", "All Applied Jobs");
			req.getRequestDispatcher("viewappliedjobs.jsp").forward(req, res);    //for User
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
