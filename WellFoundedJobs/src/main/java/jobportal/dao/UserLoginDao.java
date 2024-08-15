package jobportal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import jobportal.dbconnection.DBConnection;
import jobportal.entity.UserBean;

public class UserLoginDao {
	public UserBean ub=null;
	
	public  UserBean UserLogin(String mailid,String pswd) {
		try {
		Connection con=DBConnection.getConnection();
		PreparedStatement ps=con.prepareStatement("SELECT * FROM USERDETAILS WHERE MAILID=? AND PSWD=?");
		ps.setString(1, mailid);
		ps.setString(2, pswd);
		ResultSet rs=ps.executeQuery();
		if(rs==null) {
			return null;
		}
		if(rs.next()) {
			ub=new UserBean();
			ub.setIdentity(rs.getInt(1));
			ub.setFullname(rs.getString(2));
			ub.setEmail(rs.getString(3));
			ub.setPswd(rs.getString(4));
			ub.setQualification(rs.getString(5));
			ub.setPhno(rs.getLong(6));
			ub.setLocation(rs.getString(7));
			ub.setState(rs.getString(8));
			ub.setGender(rs.getString(9));
			ub.setYop(rs.getShort(10));
			ub.setYob(rs.getDate(11));
			ub.setFilename(rs.getString(12));
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ub;
	}

}
