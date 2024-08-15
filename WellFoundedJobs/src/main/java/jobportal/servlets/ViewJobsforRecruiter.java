package jobportal.servlets;

import java.util.ArrayList;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jobportal.dao.ViewJobsDao;
import jobportal.entity.JobProperties;
import jobportal.entity.RecruiterBean;

@SuppressWarnings("serial")
@WebServlet("/viewjobsforrecruiter")
public class ViewJobsforRecruiter extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res) {
		HttpSession hs=req.getSession(false);
		try {
		if(hs==null) {
			req.setAttribute("msg", "Session Expired please log-in again");
			req.getRequestDispatcher("recruiterlogin.jsp").forward(req, res);
			return;
		}
			RecruiterBean rb=(RecruiterBean)hs.getAttribute("recruiter");
			String companyName=rb.getCompanyName().toUpperCase();
			
			ArrayList<JobProperties> alist=new ViewJobsDao().viewJobsByCompanyName(companyName);
			hs.setAttribute("arraylist", alist);			
			req.setAttribute("companyName", companyName); 
			req.setAttribute("msg", "All Jobs");
			req.getRequestDispatcher("viewjobsforrecruiter.jsp").forward(req, res);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
