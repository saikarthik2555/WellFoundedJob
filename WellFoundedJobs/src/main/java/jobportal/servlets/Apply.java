package jobportal.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jobportal.dao.ApplyJobDao;

@SuppressWarnings("serial")
@WebServlet("/applyjob")
public class Apply extends HttpServlet{
	int i;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs=req.getSession(false);
		if(hs==null) {
		req.setAttribute("msg", "Session Expired please login again ");	
		req.getRequestDispatcher("userlogin.jsp").forward(req, res);
		return;
		}

	
		Integer jobSlno=Integer.parseInt(req.getParameter("applyUsingJobSlno"));	
		Integer userSlno=Integer.parseInt(req.getParameter("applyUsingUserSlno"));
		String resumeName=req.getParameter("resumeName");
		System.out.println(resumeName);
		
		i=new ApplyJobDao().insertDetails(jobSlno,userSlno,resumeName);
		if(i>0) {
			req.setAttribute("msg","Applied Successfully");
			req.getRequestDispatcher("viewjobs.jsp").forward(req, res);
		}else {
			req.setAttribute("msg", "Not Applied Please Apply Again");
			req.getRequestDispatcher("viewjobs.jsp").forward(req, res);
		}	
	}
}
