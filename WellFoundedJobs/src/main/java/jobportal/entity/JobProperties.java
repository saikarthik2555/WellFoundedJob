package jobportal.entity;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class JobProperties implements Serializable{
	private Integer slno;
	private String title;
	private String companyName;
	private String department;
	private Integer yop;
	private String experience;
	private Short vacancy;
	private Integer salary;
	private String recruiterMaildid;
	private Date date;
	private String location;
	private String description;
	private String skills;
	
	public JobProperties() {
		
	}

	public JobProperties(Integer slno, String title, String companyName, String department, Integer yop,
			String experience, Short vacancy, Integer salary, String recruiterMaildid, Date date, String location,
			String description, String skills) {
		super();
		this.slno = slno;
		this.title = title;
		this.companyName = companyName;
		this.department = department;
		this.yop = yop;
		this.experience = experience;
		this.vacancy = vacancy;
		this.salary = salary;
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

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public Short getVacancy() {
		return vacancy;
	}

	public void setVacancy(Short vacancy) {
		this.vacancy = vacancy;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
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
		return "JobProperties [slno=" + slno + ", title=" + title + ", companyName=" + companyName + ", department="
				+ department + ", yop=" + yop + ", experience=" + experience + ", vacancy=" + vacancy + ", salary="
				+ salary + ", recruiterMaildid=" + recruiterMaildid + ", date=" + date + ", location=" + location
				+ ", description=" + description + ", skills=" + skills + "]";
	}
	
}
