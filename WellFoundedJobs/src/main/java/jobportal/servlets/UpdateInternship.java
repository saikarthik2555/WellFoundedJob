package jobportal.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jobportal.dao.EditInternshipDao;
import jobportal.entity.InternshipProperties;

@SuppressWarnings("serial")
@WebServlet("/updateinternship")
public class UpdateInternship extends HttpServlet{
	public java.sql.Date sqldate;
	public java.util.Date dt;
	public int i;
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs=req.getSession(false);
		if(hs==null) {
		req.setAttribute("msg", "Session Expired please login again ");	
		req.getRequestDispatcher("recruiterlogin.jsp").forward(req, res);
		return;
		}
		
		ArrayList<InternshipProperties> arlist=(ArrayList<InternshipProperties>)hs.getAttribute("internshiplist");
		
		try {
			dt = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("date"));
		} catch (ParseException e) {
			System.out.println("Invalid date format");
			e.printStackTrace();
		}
		sqldate=new java.sql.Date(dt.getTime());
		
		System.out.println(req.getParameter("slno"));
		Integer slno=Integer.parseInt(req.getParameter("slno"));	
		Iterator<InternshipProperties> it=arlist.iterator();
		while(it.hasNext()) {
			InternshipProperties jp=it.next();
			if(jp.getSlno().equals(slno)) {		//if particular Slno matching then update
						//System.out.println("from update job Slno matching ");
							jp.setDepartment(req.getParameter("department"));
							jp.setDescription(req.getParameter("description"));
							jp.setDuration(Short.parseShort(req.getParameter("duration")));
							jp.setFees(Integer.parseInt(req.getParameter("fee")));
							jp.setType(req.getParameter("type"));
							jp.setLocation(req.getParameter("location"));
							jp.setYop(Integer.parseInt(req.getParameter("batches")));
							jp.setSkills(req.getParameter("skills"));
							jp.setDate(sqldate);
							i=new EditInternshipDao().updateInternshipBasedOnSlno(jp);
							if(i>0) {
								req.setAttribute("msg","Internship Updated Successfully ");
								req.setAttribute("companyName", jp.getCompanyName());
								req.getRequestDispatcher("viewinternshipsforrecruiter.jsp").forward(req, res);
							}else {
								req.setAttribute("msg","Internship Not Updated");
								req.setAttribute("companyName", jp.getCompanyName());
								req.getRequestDispatcher("viewinternshipsforrecruiter.jsp").forward(req, res);
							}
							break;
			           }//end of if
			else {
				System.out.println("update Internship slno not matching :"+jp.getSlno()+" from editjob jsp"+slno);
			}
					
				}	//end of while
	         }
    }

