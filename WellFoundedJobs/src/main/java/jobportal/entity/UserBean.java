package jobportal.entity;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class UserBean implements Serializable{
	private Integer identity;
	private String fullname;
	private String qualification;
	private String email;
	private Long phno;
	private String location;
	private String state;
	private String gender;
	private Short yop;
	private Date yob;
	private String pswd;
	private String filename;
	
	public UserBean() {
		
	}

	public UserBean(Integer identity, String fullname, String qualification, String email, Long phno, String location,
			String state, String gender, Short yop, Date yob, String pswd, String filename) {
		super();
		this.identity = identity;
		this.fullname = fullname;
		this.qualification = qualification;
		this.email = email;
		this.phno = phno;
		this.location = location;
		this.state = state;
		this.gender = gender;
		this.yop = yop;
		this.yob = yob;
		this.pswd = pswd;
		this.filename = filename;
	}

	public Integer getIdentity() {
		return identity;
	}

	public void setIdentity(Integer identity) {
		this.identity = identity;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhno() {
		return phno;
	}

	public void setPhno(Long phno) {
		this.phno = phno;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Short getYop() {
		return yop;
	}

	public void setYop(Short yop) {
		this.yop = yop;
	}

	public Date getYob() {
		return yob;
	}

	public void setYob(Date yob) {
		this.yob = yob;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	@Override
	public String toString() {
		return "UserBean [identity=" + identity + ", fullname=" + fullname + ", qualification=" + qualification
				+ ", email=" + email + ", phno=" + phno + ", location=" + location + ", state=" + state + ", gender="
				+ gender + ", yop=" + yop + ", yob=" + yob + ", pswd=" + pswd + ", filename=" + filename + "]";
	}

	
	
	
}
