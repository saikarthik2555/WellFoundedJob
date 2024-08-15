package jobportal.dao;

import java.sql.PreparedStatement;

import jobportal.dbconnection.DBConnection;
import jobportal.entity.JobProperties;

public class EditJobDao {
	public int i;
	public int updateJobBasedOnSlno(JobProperties jp) {
		try {
		PreparedStatement ps=DBConnection.getConnection().prepareStatement("UPDATE JOBS SET DEPARTMENT=?,YOP=?,EXPERIENCE=?,VACANCY=?,SALARY=?,JOBDESCRIPTION=?,LOCATION=?,LASTDATE=?,SKILLS=? WHERE SLNO=?");
		ps.setString(1, jp.getDepartment());
		ps.setInt(2, jp.getYop());
		ps.setString(3, jp.getExperience());
		ps.setShort(4, jp.getVacancy());
		ps.setInt(5, jp.getSalary());
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
