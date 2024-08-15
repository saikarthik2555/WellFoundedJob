package jobportal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import jobportal.dbconnection.DBConnection;
import jobportal.entity.InternshipProperties;

public class ViewInternshipsDao {
	public ArrayList<InternshipProperties> alist;
	public InternshipProperties data;
	public ArrayList<InternshipProperties> viewInternshipsByCompanyName(String companyName){
		try {
		PreparedStatement ps=DBConnection.getConnection().prepareStatement("SELECT * FROM INTERNSHIPS WHERE COMPANYNAME=?");
		ps.setString(1, companyName);
		ResultSet rs =ps.executeQuery();
		alist=new ArrayList<>();
		
		while(rs.next()) {
		data=new InternshipProperties();
		data.setSlno(rs.getInt(1));
		data.setTitle(rs.getString(2));
		data.setCompanyName(rs.getString(3));
		data.setDepartment(rs.getString(4));
		data.setYop(rs.getInt(5));
		data.setType(rs.getString(6));
	    data.setDuration(rs.getShort(7));
		data.setFees(rs.getInt(8));
		data.setRecruiterMaildid(rs.getString(9));
		data.setDate(rs.getDate(10));
		data.setLocation(rs.getString(11));
		data.setDescription(rs.getString(12));
		data.setSkills(rs.getString(13));
		alist.add(data);               			//adding Collection
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return alist;
	}
	public ArrayList<InternshipProperties> viewAllInternships(){
		try {
		PreparedStatement ps=DBConnection.getConnection().prepareStatement("SELECT * FROM INTERNSHIPS");
		ResultSet rs =ps.executeQuery();
		alist=new ArrayList<>();
	
		if(rs==null) {
			return null;
		}
		
		while(rs.next()) {
		data=new InternshipProperties();
		data.setSlno(rs.getInt(1));
		data.setTitle(rs.getString(2));
		data.setCompanyName(rs.getString(3));
		data.setDepartment(rs.getString(4));
		data.setYop(rs.getInt(5));
		data.setType(rs.getString(6));
	    data.setDuration(rs.getShort(7));
		data.setFees(rs.getInt(8));
		data.setRecruiterMaildid(rs.getString(9));
		data.setDate(rs.getDate(10));
		data.setLocation(rs.getString(11));
		data.setDescription(rs.getString(12));
		data.setSkills(rs.getString(13));
		alist.add(data);               			//adding Collection
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return alist;
	}


}
