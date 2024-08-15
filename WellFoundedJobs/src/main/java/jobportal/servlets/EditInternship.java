package jobportal.servlets;

import java.util.ArrayList;
import java.util.Iterator;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jobportal.entity.InternshipProperties;
import jobportal.entity.JobProperties;

@SuppressWarnings("serial")
@WebServlet("/editinternship")
public class EditInternship extends HttpServlet{
	public java.sql.Date sqldate;
	protected void doGet(HttpServletRequest req,HttpServletResponse res) {
		HttpSession hs=req.getSession(false);
		try {
		if(hs==null) {
		req.setAttribute("msg", "Session Expired please login again ");	
		req.getRequestDispatcher("recruiterlogin.jsp").forward(req, res);
		return;
		}
		ArrayList<InternshipProperties> arlist=(ArrayList<InternshipProperties>)hs.getAttribute("internshiplist");
	
		Integer slno=Integer.parseInt(req.getParameter("editUsingSlno"));			
		Iterator<InternshipProperties> it=arlist.iterator();
		while(it.hasNext()) {
			InternshipProperties jp=it.next();
			if(jp.getSlno().equals(slno)) {					//particular Slno
			//	System.out.println(jp.getSlno());
				hs.setAttribute("particularinternship", jp);
			//	System.out.println(jp);						//passing obj to jsp
				req.setAttribute("companyName", jp.getCompanyName());
				req.getRequestDispatcher("editinternship.jsp").forward(req, res);
			}
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
