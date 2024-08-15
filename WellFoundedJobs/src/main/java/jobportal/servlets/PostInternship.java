package jobportal.servlets;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jobportal.dao.PostInternshipDao;
import jobportal.entity.RecruiterBean;

@SuppressWarnings("serial")
@WebServlet("/postinternship")
public class PostInternship extends HttpServlet{
	private java.sql.Date sqldate;
	private int i;
	public Integer slno=0;
	public String companyName="";
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) {
		HttpSession hs=req.getSession(false);
		try {
		if(hs==null) {
			req.setAttribute("msg", "Session Expired please log in again");	
			req.getRequestDispatcher("recruiterlogin.html").forward(req, res);
			return;
		}
			RecruiterBean rb=(RecruiterBean)hs.getAttribute("recruiter");
			String companyName=rb.getCompanyName().toUpperCase();
			String title=req.getParameter("title");
			String department=req.getParameter("dept");
			
			String year="0";
			String i1=req.getParameter("2021");
			String i2=req.getParameter("2022");
			String i3=req.getParameter("2023");
			String i4=req.getParameter("2024");
			String i5=req.getParameter("2025");
			String i6=req.getParameter("all");
			
			
			
			if(i1==null && i2==null && i3==null && i4==null && i5==null && i6==null) {
			year="0";
			}
			
			if(i1!=null && !i1.isEmpty()) {
				year=year+i1;
			}
			if(i2!=null && !i2.isEmpty()) {
				year=year+i2;
			}
			if(i3!=null && !i3.isEmpty()) {
				year=year+i3;
			}
			if(i4!=null && !i4.isEmpty()) {
				year=year+i4;
			}
			if(i5!=null && !i5.isEmpty()) {
				year=year+i5;
			}
			if(i6!=null && !i6.isEmpty()) {
				year=year+i6;
			}
			
			Integer batches=Integer.parseInt(year);
			
			
			Short duration=Short.parseShort(req.getParameter("duration"));
			String type=req.getParameter("type").toString();
			Integer fees=Integer.parseInt(req.getParameter("fee"));
			String recruiterMailid=req.getParameter("mailid");
			String skills=req.getParameter("skills");
			String location=req.getParameter("loc");
			Date dt=new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("dt"));
			sqldate=new java.sql.Date(dt.getTime());
			String description=req.getParameter("descrip");
			
			slno=getUniqueNumber();
			
			//System.out.println(title+""+companyName+""+department+""+batches+""+experience+""+vacancy+""+salary+""+recruiterMailid+""+location+""+sqldate+""+description);
			
		i=new PostInternshipDao().postInternship(slno,title,companyName,department,batches,type,duration,fees,recruiterMailid,sqldate,location,description,skills);
		
			System.out.println(slno);
			
		if(i>0) {
			req.setAttribute("msg","Internship Posted Successfully");
			req.setAttribute("companyName", companyName);
			req.getRequestDispatcher("postinternshipsuccess.jsp").forward(req, res);
		}else {
			req.setAttribute("msg","Not Posted please try again");
			req.setAttribute("companyName", companyName);
			req.getRequestDispatcher("postinternship.jsp").forward(req, res);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Integer getUniqueNumber(){
		Integer number=new Random().nextInt(2000);
	         return number;
	}
}
