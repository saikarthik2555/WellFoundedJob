package jobportal.servlets;

import java.util.ArrayList;
import java.util.Iterator;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jobportal.entity.JobProperties;

@SuppressWarnings("serial")
@WebServlet("/editjob")
public class EditJob extends HttpServlet{
	public java.sql.Date sqldate;
	protected void doGet(HttpServletRequest req,HttpServletResponse res) {
		HttpSession hs=req.getSession(false);
		try {
		if(hs==null) {
		req.setAttribute("msg", "Session Expired please login again ");	
		req.getRequestDispatcher("recruiterlogin.jsp").forward(req, res);
		return;
		}
		ArrayList<JobProperties> arlist=(ArrayList<JobProperties>)hs.getAttribute("arraylist");
	
		Integer slno=Integer.parseInt(req.getParameter("editUsingSlno"));			
		Iterator<JobProperties> it=arlist.iterator();
		while(it.hasNext()) {
			JobProperties jp=it.next();
			if(jp.getSlno().equals(slno)) {					//particular Slno
			//	System.out.println(jp.getSlno());
				hs.setAttribute("particularjob", jp);
			//	System.out.println(jp);						//passing obj to jsp
				req.setAttribute("companyName", jp.getCompanyName());
				req.getRequestDispatcher("editjob.jsp").forward(req, res);
			}
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
