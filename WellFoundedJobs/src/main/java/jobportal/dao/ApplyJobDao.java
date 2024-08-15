package jobportal.dao;

import java.sql.PreparedStatement;

import jobportal.dbconnection.DBConnection;

public class ApplyJobDao {
	int i=0;
	public int insertDetails(Integer jobSlno,Integer userSlno,String resumeName) {
		try {
			PreparedStatement ps=DBConnection.getConnection().prepareStatement("INSERT INTO APPLYJOB VALUES(?,?,?)");
			ps.setInt(1, jobSlno);
			ps.setInt(2, userSlno);
			ps.setString(3, resumeName);
			
			i=ps.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}
		return i;
	}

}
