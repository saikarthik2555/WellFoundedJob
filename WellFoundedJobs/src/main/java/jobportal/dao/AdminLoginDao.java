package jobportal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jobportal.dbconnection.DBConnection;
import jobportal.entity.Admin;

public class AdminLoginDao {
	public Admin admin;
	public Admin checkAdmin(String adminname,String emailid,String pswd) {
		try {
			PreparedStatement ps=DBConnection.getConnection().prepareStatement("SELECT * FROM JOBPORTALADMIN WHERE ADMINNAME=? AND EMAILID=? AND PSWD=?");
			ps.setString(1, adminname);
			ps.setString(2, emailid);
			ps.setString(3, pswd);
		    ResultSet rs=ps.executeQuery();
		    admin=new Admin();
		    if(rs.next()) {
		    	admin.setAdminName(rs.getString(1));
		    	admin.setEmailid(rs.getString(2));
		    	admin.setPswd(rs.getString(3));	
		    }else {
		    	return null;
		    }
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return admin;
	}
}