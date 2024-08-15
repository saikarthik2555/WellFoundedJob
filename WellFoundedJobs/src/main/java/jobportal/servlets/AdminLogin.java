package jobportal.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jobportal.dao.AdminLoginDao;
import jobportal.entity.Admin;

@SuppressWarnings("serial")
@WebServlet("/adminlogin")
public class AdminLogin extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) {
		String adminname=req.getParameter("adminname").toUpperCase();
		String emailid=req.getParameter("mailid");
		String pswd=req.getParameter("pswd");
	Admin admin=new AdminLoginDao().checkAdmin(adminname,emailid,pswd);
	try {
	if(admin==null ) {
		req.setAttribute("msg", "  InCorrect Details  please  Log in  again ");
		req.getRequestDispatcher("adminregistration.jsp").forward(req, res);
		return;
	}
		req.setAttribute("adminname", admin.getAdminName());
		req.setAttribute("msg", "Admin Login Successfull");
		req.getRequestDispatcher("adminlogin.jsp").forward(req, res);
	}catch(Exception e)
	{
		e.printStackTrace();
	}
  }
}
