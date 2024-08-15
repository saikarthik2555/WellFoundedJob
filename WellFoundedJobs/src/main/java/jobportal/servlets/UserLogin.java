package jobportal.servlets;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jobportal.dao.UserLoginDao;
import jobportal.dao.ViewJobsDao;
import jobportal.entity.JobProperties;
import jobportal.entity.UserBean;

@SuppressWarnings("serial")
@WebServlet("/userlogin")
public class UserLogin extends HttpServlet{
	protected void doPost(HttpServletRequest req,HttpServletResponse res) {
		String emailid=req.getParameter("mailid");
		String pswd=req.getParameter("pswd");
		UserBean ub=new UserLoginDao().UserLogin(emailid, pswd);
		try {
		if(ub==null) {
			req.setAttribute("msg", "Please check EmailId and Password ");
			req.getRequestDispatcher("userlogin.jsp").forward(req, res);
			return;
		}
			HttpSession hs=req.getSession();		//session obj
			hs.setAttribute("userbean", ub); 
			req.setAttribute("msg", "Welcome "+ub.getFullname());
			ArrayList<JobProperties> jobs=new ViewJobsDao().viewAllJobs();
			hs.setAttribute("jobs", jobs);	
			req.getRequestDispatcher("userloginsuccess.jsp").forward(req, res);

			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {		
				e.printStackTrace();
			}
		}
	}
