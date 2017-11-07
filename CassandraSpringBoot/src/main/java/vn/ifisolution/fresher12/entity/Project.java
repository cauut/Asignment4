package vn.ifisolution.fresher12.entity;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table(value="tblproject")
public class Project {
	private ProjectId pk;
	private String description;
	public ProjectId getPk() {
		return pk;
	}
	@PrimaryKey
	public void setPk(ProjectId pk) {
		this.pk = pk;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Project() {
		super();
	}
	public Project(ProjectId pk, String description) {
		super();
		this.pk = pk;
		this.description = description;
	}
	
	

}
