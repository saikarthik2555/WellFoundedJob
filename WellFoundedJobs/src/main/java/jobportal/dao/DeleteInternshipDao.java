package jobportal.dao;

import java.sql.PreparedStatement;

import jobportal.dbconnection.DBConnection;

public class DeleteInternshipDao {
	public int i=0;
	public int deleteInternshipBasedOnSlno(Integer slno) {
		try {
		PreparedStatement ps=DBConnection.getConnection().prepareStatement("DELETE FROM INTERNSHIPS WHERE SLNO=?");
		ps.setInt(1, slno);
		
		i=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return i;
		
	}

}
