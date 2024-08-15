package jobportal.entity;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class InternshipProperties implements Serializable{
	private Integer slno;
	private String title;
	private String companyName;
	private String department;
	private Integer yop;
	private String type;
	private Short duration;
	private Integer fees;
	private String recruiterMaildid;
	private Date date;
	private String location;
	private String description;
	private String skills;
	
	public InternshipProperties() {
		
	}

	public InternshipProperties(Integer slno, String title, String companyName, String department, Integer yop,
			String type, Short duration, Integer fees, String recruiterMaildid, Date date, String location,
			String description, String skills) {
		super();
		this.slno = slno;
		this.title = title;
		this.companyName = companyName;
		this.department = department;
		this.yop = yop;
		this.type = type;
		this.duration = duration;
		this.fees = fees;
		this.recruiterMaildid = recruiterMaildid;
		this.date = date;
		this.location = location;
		this.description = description;
		this.skills = skills;
	}

	public Integer getSlno() {
		return slno;
	}

	public void setSlno(Integer slno) {
		this.slno = slno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Integer getYop() {
		return yop;
	}

	public void setYop(Integer yop) {
		this.yop = yop;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Short getDuration() {
		return duration;
	}

	public void setDuration(Short duration) {
		this.duration = duration;
	}

	public Integer getFees() {
		return fees;
	}

	public void setFees(Integer fees) {
		this.fees = fees;
	}

	public String getRecruiterMaildid() {
		return recruiterMaildid;
	}

	public void setRecruiterMaildid(String recruiterMaildid) {
		this.recruiterMaildid = recruiterMaildid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	@Override
	public String toString() {
		return "InternshipProperties [slno=" + slno + ", title=" + title + ", companyName=" + companyName
				+ ", department=" + department + ", yop=" + yop + ", type=" + type + ", duration=" + duration
				+ ", fees=" + fees + ", recruiterMaildid=" + recruiterMaildid + ", date=" + date + ", location="
				+ location + ", description=" + description + ", skills=" + skills + "]";
	}

	
}
