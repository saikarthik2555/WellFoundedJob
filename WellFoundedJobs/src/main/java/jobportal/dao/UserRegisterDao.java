package jobportal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import jobportal.dbconnection.DBConnection;

public class UserRegisterDao {
	private static Connection con;
	private int i;
	
	public  Integer registerUser(Integer identity,String username,String mail,String pswd,String qualification,Long phno,String location,String state,String gender,Short yop,Date date,String filename) {
		try {
		 con=DBConnection.getConnection();
	    PreparedStatement ps=con.prepareStatement("INSERT INTO USERDETAILS VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
	   ps.setInt(1, identity);
	    ps.setString(2, username);
		ps.setString(3, mail);
		ps.setString(4, pswd);
		ps.setString(5, qualification);
		ps.setLong(6, phno);
		ps.setString(7, location);
		ps.setString(8, state);
		ps.setString(9, gender);
		ps.setShort(10, yop);
		ps.setDate(11, date);
		ps.setString(12, filename);
		System.out.println("From Yserregistration dao"+filename);
		//execute 
		i=ps.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	

}
