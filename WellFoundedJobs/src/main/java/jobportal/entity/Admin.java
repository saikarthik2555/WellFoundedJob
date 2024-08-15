package jobportal.entity;

public class Admin {
	private String adminName;
	private String emailid;
	private String pswd;
	
	public Admin() {
		
	}

	public Admin(String adminName, String emailid, String pswd) {
		super();
		this.adminName = adminName;
		this.emailid = emailid;
		this.pswd = pswd;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
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

	@Override
	public String toString() {
		return "Admin [adminName=" + adminName + ", emailid=" + emailid + ", pswd=" + pswd + "]";
	}
	
    

}
