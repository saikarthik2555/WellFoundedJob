package jobportal.dao;

import java.sql.PreparedStatement;

import jobportal.dbconnection.DBConnection;
import jobportal.entity.InternshipProperties;

public class EditInternshipDao {
	public int i;
	public int updateInternshipBasedOnSlno(InternshipProperties jp) {
		try {
			PreparedStatement ps=DBConnection.getConnection().prepareStatement("UPDATE INTERNSHIPS SET DEPARTMENT=?,YOP=?,TYPE=?,DURATION=?,FEES=?,INTERNSHIPDESCRIPTION=?,LOCATION=?,LASTDATE=?,SKILLS=? WHERE SLNO=?");
		ps.setString(1, jp.getDepartment());
		ps.setInt(2, jp.getYop());
		ps.setString(3, jp.getType());
		ps.setShort(4, jp.getDuration());
		ps.setInt(5, jp.getFees());
		ps.setString(6, jp.getDescription());
		ps.setString(7, jp.getLocation());
		ps.setDate(8, jp.getDate());
		ps.setString(9, jp.getSkills());
		ps.setInt(10, jp.getSlno());
		
		i=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

}
