package jobportal.servlets;

import java.util.ArrayList;
import java.util.Iterator;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jobportal.dao.DeleteJobDao;
import jobportal.entity.JobProperties;

@SuppressWarnings("serial")
@WebServlet("/deletejob")
public class DeleteJob extends HttpServlet{
	public int i;
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res) {
		HttpSession hs=req.getSession(false);
		try {
		if(hs==null) {
		req.setAttribute("msg", "Session Expired please login again ");	
		req.getRequestDispatcher("recruiterlogin.jsp").forward(req, res);
		return;
		}
		
		ArrayList<JobProperties> arlist=(ArrayList<JobProperties>)hs.getAttribute("arraylist");
	
		Integer slno=Integer.parseInt(req.getParameter("deleteUsingSlno"));			
		Iterator<JobProperties> it=arlist.iterator();
		while(it.hasNext()) {
			JobProperties jp=it.next();
			if(jp.getSlno().equals(slno)) {					//particular Slno
				i=new DeleteJobDao().deleteJobBasedOnSlno(slno);
				if(i>0) {
				req.setAttribute("msg", "Job Removed Successfully");
				req.setAttribute("companyName", jp.getCompanyName());
				req.getRequestDispatcher("viewremainingjobs.jsp").forward(req, res);
				}else {
				req.setAttribute("companyName", jp.getCompanyName());
				req.setAttribute("msg", "Job Not Removed ");
				req.setAttribute("jobs", arlist);
				req.getRequestDispatcher("viewjobsforrecruiter.jsp").forward(req, res);
				}
			}
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
