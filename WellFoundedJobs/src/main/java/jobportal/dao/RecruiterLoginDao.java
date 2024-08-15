package jobportal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import jobportal.dbconnection.DBConnection;
import jobportal.entity.RecruiterBean;

public class RecruiterLoginDao {
	public RecruiterBean rb=null;
	
	public  RecruiterBean recruiterLogin(String mailid,String pswd) {
		try {
		Connection con=DBConnection.getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT * FROM RECRUITERDETAILS WHERE MAILID=? AND PSWD=?");
		ps.setString(1, mailid);
		ps.setString(2, pswd);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			rb=new RecruiterBean();
			rb.setCompanyName(rs.getString(1));
			rb.setEmailid(rs.getString(2));
			rb.setPswd(rs.getString(3));
			rb.setPhno(rs.getLong(4));
			rb.setLocation(rs.getString(5));
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return rb;
	}

}
