package jobportal.servlets;

import java.util.ArrayList;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jobportal.dao.ViewInternshipsDao;
import jobportal.entity.InternshipProperties;
import jobportal.entity.RecruiterBean;

@SuppressWarnings("serial")
@WebServlet("/viewinternshipsforrecruiter")
public class ViewInternshipsForRecruiter extends HttpServlet{
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
			
			ArrayList<InternshipProperties> alist=new ViewInternshipsDao().viewInternshipsByCompanyName(companyName);
			hs.setAttribute("internshiplist", alist);			
			req.setAttribute("companyName", companyName); 
			req.setAttribute("msg", "All Internships");
			req.getRequestDispatcher("viewinternshipsforrecruiter.jsp").forward(req, res);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
