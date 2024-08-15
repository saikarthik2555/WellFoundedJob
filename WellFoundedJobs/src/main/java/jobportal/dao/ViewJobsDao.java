package jobportal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import jobportal.dbconnection.DBConnection;
import jobportal.entity.JobProperties;
import jobportal.entity.UserBean;

public class ViewJobsDao {
	public ArrayList<JobProperties> alist;
	public JobProperties data;
	public UserBean ub;
	public ArrayList<UserBean> beanlist;
	public ArrayList<JobProperties> viewJobsByCompanyName(String companyName){
		try {
		PreparedStatement ps=DBConnection.getConnection().prepareStatement("SELECT * FROM JOBS WHERE COMPANYNAME=?");
		ps.setString(1, companyName);
		ResultSet rs =ps.executeQuery();
		alist=new ArrayList<>();
		
		while(rs.next()) {
		data=new JobProperties();
		data.setSlno(rs.getInt(1));
		data.setTitle(rs.getString(2));
		data.setCompanyName(rs.getString(3));
		data.setDepartment(rs.getString(4));
		data.setYop(rs.getInt(5));
		data.setExperience(rs.getString(6));
	    data.setVacancy(rs.getShort(7));
		data.setSalary(rs.getInt(8));
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
	public ArrayList<JobProperties> viewAllJobs(){
		try {
		PreparedStatement ps=DBConnection.getConnection().prepareStatement("SELECT * FROM JOBS");
		ResultSet rs =ps.executeQuery();
		alist=new ArrayList<>();
	
		if(rs==null) {
			return null;
		}
		
		while(rs.next()) {
		data=new JobProperties();
		data.setSlno(rs.getInt(1));
		data.setTitle(rs.getString(2));
		data.setCompanyName(rs.getString(3));
		data.setDepartment(rs.getString(4));
		data.setYop(rs.getInt(5));
		data.setExperience(rs.getString(6));
	    data.setVacancy(rs.getShort(7));
		data.setSalary(rs.getInt(8));
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
	public ArrayList<JobProperties> viewJobsBasedOnUserSlno(Integer slno){
		try {
		PreparedStatement ps=DBConnection.getConnection().prepareStatement( "SELECT J.SLNO, J.TITLE, J.COMPANYNAME, J.DEPARTMENT, J.YOP, J.EXPERIENCE, J.VACANCY, J.SALARY, J.RECRUITERMAILID, J.LASTDATE, J.LOCATION, J.JOBDESCRIPTION, J.SKILLS FROM JOBS J INNER JOIN APPLYJOB A ON J.SLNO=A.JOBSLNO INNER JOIN USERDETAILS U ON U.IDENTITY=?");
		ps.setInt(1, slno);
		ResultSet rs =ps.executeQuery();
		alist=new ArrayList<>();
	
		if(rs==null) {
			return null;
		}
		
		while(rs.next()) {
		data=new JobProperties();
		data.setSlno(rs.getInt("SLNO"));
		data.setTitle(rs.getString("TITLE"));
		data.setCompanyName(rs.getString("COMPANYNAME"));
		data.setDepartment(rs.getString("DEPARTMENT"));
		data.setYop(rs.getInt("YOP"));
		data.setExperience(rs.getString("EXPERIENCE"));
	    data.setVacancy(rs.getShort("VACANCY"));
		data.setSalary(rs.getInt("SALARY"));
		data.setRecruiterMaildid(rs.getString("RECRUITERMAILID"));
		data.setDate(rs.getDate("LASTDATE"));
		data.setLocation(rs.getString("LOCATION"));
		data.setDescription(rs.getString("JOBDESCRIPTION"));
		data.setSkills(rs.getString("SKILLS"));
		alist.add(data);               			//adding Collection
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return alist;
	}
	
	public ArrayList<UserBean> viewAppliedApplicantsBasedOnCompanyName(String companyName){
		try {
		PreparedStatement ps=DBConnection.getConnection().prepareStatement("SELECT U.IDENTITY,U.NAME,U.MAILID,U.QUALIFICATION,U.LOCATION,U.PHNO,J.TITLE,J.DEPARTMENT,U.GENDER,U.YOP,J.LASTDATE,U.RESUMENAME FROM USERDETAILS U INNER JOIN APPLYJOB A ON U.IDENTITY=A.USERSLNO INNER JOIN JOBS J ON J.SLNO=A.JOBSLNO AND J.COMPANYNAME=?");
		ps.setString(1, companyName);
		ResultSet rs =ps.executeQuery();
		beanlist=new ArrayList<>();
		
		while(rs.next()) {
		ub=new UserBean();
		ub.setIdentity(rs.getInt("IDENTITY"));
		ub.setFullname(rs.getString("NAME"));
		ub.setEmail(rs.getString("MAILID"));
		ub.setQualification(rs.getString("QUALIFICATION"));
		ub.setLocation(rs.getString("LOCATION"));
		ub.setPhno(rs.getLong("PHNO"));
		ub.setPswd(rs.getString("TITLE"));
		ub.setState(rs.getString("DEPARTMENT"));
		ub.setGender(rs.getString("GENDER"));
		ub.setYop(rs.getShort("YOP"));
		ub.setYob(rs.getDate("LASTDATE"));
		ub.setFilename(rs.getString("RESUMENAME"));
		beanlist.add(ub);               			//adding Collection
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return beanlist;
	}
	


}
