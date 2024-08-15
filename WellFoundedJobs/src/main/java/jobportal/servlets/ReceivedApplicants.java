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
import jobportal.entity.RecruiterBean;
import jobportal.entity.UserBean;

@SuppressWarnings("serial")
@WebServlet("/receivedapplicants")
public class ReceivedApplicants extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs=req.getSession(false);
		try {
		if(hs==null) {
			req.setAttribute("msg", "Session Expired please log-in again");
			req.getRequestDispatcher("recruiterlogin.jsp").forward(req, res);
			return;
		}

		String companyName=req.getParameter("recruiterCompany").toUpperCase();
		
		ArrayList<UserBean> appliedapplicants=new ViewJobsDao().viewAppliedApplicantsBasedOnCompanyName(companyName);
			hs.setAttribute("appliedapplicants", appliedapplicants);	
			req.setAttribute("msg", "Applicants Applied For Jobs");
			req.getRequestDispatcher("viewappliedapplicants.jsp").forward(req, res);    //for Recruiter
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
 }	
	