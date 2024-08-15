package jobportal.dao;

import java.sql.PreparedStatement;

import jobportal.dbconnection.DBConnection;

public class DeleteJobDao {
	public int i=0;
	public int deleteJobBasedOnSlno(Integer slno) {
		try {
		PreparedStatement ps=DBConnection.getConnection().prepareStatement("DELETE FROM JOBS WHERE SLNO=?");
		ps.setInt(1, slno);
		
		i=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return i;
		
	}

}
