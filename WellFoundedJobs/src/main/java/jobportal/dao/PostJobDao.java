package jobportal.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import jobportal.dbconnection.DBConnection;

public class PostJobDao{
	public int i;
	public int postJob(Integer slno,String title,String companyName,String department,Integer yop,String experience,Short vacancy,Integer salary,String recruiterMailId,Date dt,String location,String description,String skills) {
		
		try{
			PreparedStatement ps=DBConnection.getConnection().prepareStatement("INSERT INTO JOBS VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, slno);
			ps.setString(2, title);
			ps.setString(3, companyName);
	        ps.setString(4, department);
	        ps.setInt(5, yop);
	        ps.setString(6, experience);
	        ps.setShort(7, vacancy);
	        ps.setInt(8,salary);
	        ps.setString(9, recruiterMailId);
	        ps.setDate(10, dt);
	        ps.setString(11, location);
	        ps.setString(12, description);
	        ps.setString(13, skills);
	        
	        i=ps.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}
}
