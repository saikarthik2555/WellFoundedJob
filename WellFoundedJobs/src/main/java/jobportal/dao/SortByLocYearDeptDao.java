package jobportal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import jobportal.dbconnection.DBConnection;
import jobportal.entity.JobProperties;

public class SortByLocYearDeptDao {
	public JobProperties jp;
	public ArrayList<JobProperties> alist;
	
	public ArrayList<JobProperties> sort(String year){
		try {
		PreparedStatement ps=DBConnection.getConnection().prepareStatement("SELECT * FROM JOBS");
	//	ps.setString(1, "%"+year+"%");
		
		ResultSet rs=ps.executeQuery();
		
		alist=new ArrayList<>();
		
		if(rs==null) {
			System.out.println("Data Not Found while sorting");
			return null;
		}
		while(rs.next()) {
			jp=new JobProperties();
			jp.setSlno(rs.getInt(1));
			jp.setTitle(rs.getString(2));
			jp.setCompanyName(rs.getString(3));
			jp.setDepartment(rs.getString(4));
			jp.setYop(rs.getInt(5));
			jp.setExperience(rs.getString(6));
		    jp.setVacancy(rs.getShort(7));
			jp.setSalary(rs.getInt(8));
			jp.setRecruiterMaildid(rs.getString(9));
			jp.setDate(rs.getDate(10));
			jp.setLocation(rs.getString(11));
			jp.setDescription(rs.getString(12));
			jp.setSkills(rs.getString(13));
			alist.add(jp);  
		}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return alist;
	}
	public ArrayList<JobProperties> sortByDepartment(String year,String department){
		try {
			System.out.println("deparment invoked");
		PreparedStatement ps=DBConnection.getConnection().prepareStatement("SELECT * FROM JOBS WHERE DEPARTMENT=?");
	//	ps.setString(1, "%"+year+"%");
		ps.setString(1, department);
		
		ResultSet rs=ps.executeQuery();
		
		alist=new ArrayList<>();
		
		if(rs==null) {
			System.out.println("Data Not Found while sorting");
			return null;
		}
		while(rs.next()) {
			jp=new JobProperties();
			jp.setSlno(rs.getInt(1));
			jp.setTitle(rs.getString(2));
			jp.setCompanyName(rs.getString(3));
			jp.setDepartment(rs.getString(4));
			jp.setYop(rs.getInt(5));
			jp.setExperience(rs.getString(6));
		    jp.setVacancy(rs.getShort(7));
			jp.setSalary(rs.getInt(8));
			jp.setRecruiterMaildid(rs.getString(9));
			jp.setDate(rs.getDate(10));
			jp.setLocation(rs.getString(11));
			jp.setDescription(rs.getString(12));
			jp.setSkills(rs.getString(13));
			alist.add(jp);  
		}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return alist;
	}
	
	public ArrayList<JobProperties> sortByLocation(String year,String location){
		System.out.println("location invoked");
		try {
		PreparedStatement ps=DBConnection.getConnection().prepareStatement("SELECT * FROM JOBS WHERE LOCATION=?");
	//	ps.setString(1, "%"+year+"%");
		ps.setString(1, location);
		
		ResultSet rs=ps.executeQuery();
		
		alist=new ArrayList<>();
		
		if(rs==null) {
			System.out.println("Data Not Found while sorting");
			return null;
		}
		while(rs.next()) {
			jp=new JobProperties();
			jp.setSlno(rs.getInt(1));
			jp.setTitle(rs.getString(2));
			jp.setCompanyName(rs.getString(3));
			jp.setDepartment(rs.getString(4));
			jp.setYop(rs.getInt(5));
			jp.setExperience(rs.getString(6));
		    jp.setVacancy(rs.getShort(7));
			jp.setSalary(rs.getInt(8));
			jp.setRecruiterMaildid(rs.getString(9));
			jp.setDate(rs.getDate(10));
			jp.setLocation(rs.getString(11));
			jp.setDescription(rs.getString(12));
			jp.setSkills(rs.getString(13));
			alist.add(jp);  
		}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return alist;
	}


}
