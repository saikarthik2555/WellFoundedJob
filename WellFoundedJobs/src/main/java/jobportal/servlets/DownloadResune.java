package jobportal.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/download")
public class DownloadResune extends HttpServlet{
	public int BUFFERSIZE=1024*1000;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String filename=req.getParameter("resumeName");
		String path=getServletContext().getRealPath("")+"images"+File.separator+filename;
		//System.out.println(path);
		
		File f=new File(path);
		OutputStream os=null;
		FileInputStream fis=null;
		if(f.exists()) {
			os=res.getOutputStream();
			fis=new FileInputStream(f);
			
			byte []b=new byte[BUFFERSIZE];
			int byteReader=-1;
			while((byteReader=fis.read(b))!=-1) {
				os.write(b,0,byteReader);
			}
		}
		else {
			res.getWriter().println("Resume Not Available");
		}
	}

}
