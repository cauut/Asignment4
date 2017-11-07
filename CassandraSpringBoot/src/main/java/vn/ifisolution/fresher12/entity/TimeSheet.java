package vn.ifisolution.fresher12.entity;

import java.io.Serializable;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;
@Table(value="tbltimesheets")
public class TimeSheet implements Serializable{
	private TimeSheetId pk;
    private String name_personal,name_project,description;
	public TimeSheet(TimeSheetId pk, String name_personal, String name_project, String description) {
		super();
		this.pk = pk;
		this.name_personal = name_personal;
		this.name_project = name_project;
		this.description = description;
	}
	public TimeSheet() {
		super();
	}
	@PrimaryKey
	public TimeSheetId getPk() {
		return pk;
	}
	public void setPk(TimeSheetId pk) {
		this.pk = pk;
	}
	public String getName_personal() {
		return name_personal;
	}
	public void setName_personal(String name_personal) {
		this.name_personal = name_personal;
	}
	public String getName_project() {
		return name_project;
	}
	public void setName_project(String name_project) {
		this.name_project = name_project;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
    


}
