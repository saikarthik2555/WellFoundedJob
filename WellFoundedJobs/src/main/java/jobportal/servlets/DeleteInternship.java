package jobportal.servlets;

import java.util.ArrayList;
import java.util.Iterator;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jobportal.dao.DeleteInternshipDao;
import jobportal.entity.InternshipProperties;

@SuppressWarnings("serial")
@WebServlet("/deleteinternship")
public class DeleteInternship extends HttpServlet{
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
		
		ArrayList<InternshipProperties> arlist=(ArrayList<InternshipProperties>)hs.getAttribute("internshiplist");
	
		Integer slno=Integer.parseInt(req.getParameter("deleteUsingSlno"));			
		Iterator<InternshipProperties> it=arlist.iterator();
		while(it.hasNext()) {
			InternshipProperties jp=it.next();
			if(jp.getSlno().equals(slno)) {					//particular Slno
				i=new DeleteInternshipDao().deleteInternshipBasedOnSlno(slno);
				if(i>0) {
				req.setAttribute("msg", "Internship Removed Successfully");
				req.setAttribute("companyName", jp.getCompanyName());
				req.getRequestDispatcher("viewremaininginternships.jsp").forward(req, res);
				}else {
				req.setAttribute("companyName", jp.getCompanyName());
				req.setAttribute("msg", "Internship Not Removed ");
				req.setAttribute("internships", arlist);
				req.getRequestDispatcher("viewinternshipsforrecruiter.jsp").forward(req, res);
				}
			}
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
