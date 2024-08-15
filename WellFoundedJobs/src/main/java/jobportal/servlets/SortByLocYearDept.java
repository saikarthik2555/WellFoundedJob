package jobportal.servlets;

import java.util.ArrayList;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jobportal.dao.SortByLocYearDeptDao;
import jobportal.entity.JobProperties;

@SuppressWarnings("serial")
@WebServlet("/sortByLocYearDept")
public class SortByLocYearDept extends HttpServlet{
	ArrayList<JobProperties> alist;
	String location="";
	String department="";
	String btch="0";
	Integer year=0;
	String basedOn="";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) {
		 location=req.getParameter("loc");
		 department=req.getParameter("dept");
		 btch=req.getParameter("batch");
		// year=Integer.parseInt(btch);
		System.out.println(location+" "+department+" "+btch);
		
		if(location.equals("All Locations") && department.equals("All Departments")) {
			basedOn=location+" "+department;
			alist=new SortByLocYearDeptDao().sort(btch);
		}
		else if(location.equals("All Locations")) {
			basedOn=department;
			alist=new SortByLocYearDeptDao().sortByDepartment(btch,department);
		}
		else{
			basedOn=location;
			alist=new SortByLocYearDeptDao().sortByLocation(btch,location);
		}
		
		try {
		if(alist==null) {
			req.setAttribute("msg", "No Job Found : "+basedOn);
			req.getRequestDispatcher("userloginsuccess.jsp").forward(req, res);
			return;
		}
	    req.setAttribute("sortedjobs", alist);
	    req.setAttribute("msg", "Sorted Jobs : "+basedOn);
	    req.getRequestDispatcher("sorteddata.jsp").forward(req, res);
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}
}
