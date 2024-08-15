package jobportal.entity;

public class ApplyJob {
	private Integer slno;
	private Integer identity;
	private String resumeName;
	
	public ApplyJob() {
		
	}

	public ApplyJob(Integer slno, Integer identity, String resumeName) {
		super();
		this.slno = slno;
		this.identity = identity;
		this.resumeName = resumeName;
	}

	public Integer getSlno() {
		return slno;
	}

	public void setSlno(Integer slno) {
		this.slno = slno;
	}

	public Integer getIdentity() {
		return identity;
	}

	public void setIdentity(Integer identity) {
		this.identity = identity;
	}

	public String getResumeName() {
		return resumeName;
	}

	public void setResumeName(String resumeName) {
		this.resumeName = resumeName;
	}

	@Override
	public String toString() {
		return "ApplyJob [slno=" + slno + ", identity=" + identity + ", resumeName=" + resumeName + "]";
	}
	
	
	
}
