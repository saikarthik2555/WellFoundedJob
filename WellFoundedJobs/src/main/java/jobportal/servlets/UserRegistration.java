package jobportal.servlets;


import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import jobportal.dao.UserRegisterDao;

@SuppressWarnings("serial")
@WebServlet("/userregistration")
@MultipartConfig
public class UserRegistration extends HttpServlet{
	private Date date;
	private int i;
	private java.sql.Date sqldate;
	public Integer identity=0;
	private String filename;
	Part p;
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		Part p=req.getPart("resume");
		identity=getUniqueNumber();		//unique id to User 
		
		String username=req.getParameter("username");
		String qualification=req.getParameter("qualification");
		String mail=req.getParameter("mailid");
		Long phno=Long.parseLong(req.getParameter("contact"));
		String location=req.getParameter("location");
		String state=req.getParameter("state");
		String gender=req.getParameter("gender");
		Short yop=Short.parseShort(req.getParameter("yop"));
		try {
			date=new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("dob"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		sqldate=new java.sql.Date(date.getTime());
		
		String pswd=req.getParameter("pswd");
		
		
		 filename=p.getSubmittedFileName();
	 i=	new UserRegisterDao().registerUser(identity,username,mail,pswd,qualification,phno,location,state,gender,yop,sqldate,filename);
	if(i>0) {
	String path= getServletContext().getRealPath("/images");   //storing file name in images folder
	File f=new File(path);     //strong path 
	if(!f.exists()) {
		f.mkdirs();
	}
	System.out.println("After storing in dao"+filename);
	p.write(path + File.separator + filename);
	req.setAttribute("msg"," User Registered successfully");
	req.getRequestDispatcher("userregistration.jsp").forward(req, res);
	}
	else {
	req.setAttribute("msg", "Not Regsitered, Please Register Again");
	req.getRequestDispatcher("userregistration.jsp").forward(req, res);
	}
 }
	public static Integer getUniqueNumber(){
		Integer number=new Random().nextInt(2000);
	         return number;
	}
}
