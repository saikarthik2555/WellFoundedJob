package jobportal.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jobportal.dao.RecruiterLoginDao;
import jobportal.entity.RecruiterBean;

@SuppressWarnings("serial")
@WebServlet("/recruiterlogin")
public class RecruiterLogin extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) {
		String emailid=req.getParameter("mailid");
		String pswd=req.getParameter("pswd");
		RecruiterBean rb=new RecruiterLoginDao().recruiterLogin(emailid, pswd);
		try {
		if(rb==null) {
			req.setAttribute("msg", "InCorrect Email Id or Password");
			req.getRequestDispatcher("recruiterlogin.jsp").forward(req, res);
		}else {
			HttpSession hs=req.getSession();			//session obj
			hs.setAttribute("recruiter", rb);
			req.setAttribute("companyName", rb.getCompanyName());   //company name
			req.getRequestDispatcher("recruiterloginsuccess.jsp").forward(req, res);
			}
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {		
				e.printStackTrace();
			}
		}
	}
