package jobportal.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RecruiterBean implements Serializable{
	private String companyName;
	private String emailid;
	private String pswd;
	private Long phno;
	private String location;
	
	public RecruiterBean() {
		
	}

	public RecruiterBean(String companyName, String emailid, String pswd, Long phno, String location) {
		super();
		this.companyName = companyName;
		this.emailid = emailid;
		this.pswd = pswd;
		this.phno = phno;
		this.location = location;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
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

	@Override
	public String toString() {
		return "RecruiterBean [companyName=" + companyName + ", emailid=" + emailid + ", pswd=" + pswd + ", phno="
				+ phno + ", location=" + location + "]";
	}

	
}
