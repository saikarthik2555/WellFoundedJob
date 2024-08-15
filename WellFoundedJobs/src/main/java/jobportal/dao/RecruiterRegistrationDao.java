package jobportal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jobportal.dbconnection.DBConnection;

public class RecruiterRegistrationDao {
	private static Connection con;
	private int i;
	
	public  int registerUser(String companyName,String mailid,String pswd,Long phno,String location) {
		try {
		 con=DBConnection.getConnection();
	    PreparedStatement ps=con.prepareStatement("INSERT INTO RECRUITERDETAILS VALUES(?,?,?,?,?)");
		ps.setString(1, companyName);
		ps.setString(2, mailid);
		ps.setString(3, pswd);
		ps.setLong(4, phno);
		ps.setString(5, location);
		//execute 
		i=ps.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
}
