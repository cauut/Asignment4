package vn.ifisolution.fresher12.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Id;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.CassandraType;
import org.springframework.data.cassandra.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;

import com.datastax.driver.core.DataType.Name;
@PrimaryKeyClass
public class TimeSheetId implements Serializable{
//	primary key((id, id_project, id_personal,type), name, startdate, enddate));
	private UUID id, id_project, id_personal;
	private String type, name;
	private LocalDate startdate, enddate;
	public TimeSheetId(UUID id, UUID id_project, UUID id_personal, String type, String name, LocalDate startdate,
			LocalDate enddate) {
		super();
		this.id = id;
		this.id_project = id_project;
		this.id_personal = id_personal;
		this.type = type;
		this.name = name;
		this.startdate = startdate;
		this.enddate = enddate;
	}
	public TimeSheetId(UUID id_project, UUID id_personal, String type, String name, LocalDate startdate,
			LocalDate enddate) {
		super();
		id = UUID.randomUUID();
		this.id_project = id_project;
		this.id_personal = id_personal;
		this.type = type;
		this.name = name;
		this.startdate = startdate;
		this.enddate = enddate;
	}
	public TimeSheetId() {
		super();
	}
	@PrimaryKeyColumn(name = "id", type = PrimaryKeyType.PARTITIONED)
	@Id
	@CassandraType(type = Name.UUID)
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	@PrimaryKeyColumn(name = "id_project", type = PrimaryKeyType.PARTITIONED)
	@Id
	@CassandraType(type = Name.UUID)
	public UUID getId_project() {
		return id_project;
	}
	public void setId_project(UUID id_project) {
		this.id_project = id_project;
	}
	@PrimaryKeyColumn(name = "id_personal", type = PrimaryKeyType.PARTITIONED)
	@Id
	@CassandraType(type = Name.UUID)
	public UUID getId_personal() {
		return id_personal;
	}
	public void setId_personal(UUID id_personal) {
		this.id_personal = id_personal;
	}
	@PrimaryKeyColumn(name = "type", type = PrimaryKeyType.PARTITIONED)
	@Id
	@CassandraType(type = Name.TEXT)
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@PrimaryKeyColumn(name = "name", type = PrimaryKeyType.CLUSTERED)
	@Id
	@CassandraType(type = Name.TEXT)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@PrimaryKeyColumn(name = "startdate", type = PrimaryKeyType.CLUSTERED)
	@Id
	@CassandraType(type = Name.DATE)
	public LocalDate getStartdate() {
		return startdate;
	}
	public void setStartdate(LocalDate startdate) {
		this.startdate = startdate;
	}
	@PrimaryKeyColumn(name = "enddate", type = PrimaryKeyType.CLUSTERED)
	@Id
	@CassandraType(type = Name.DATE)
	public LocalDate getEnddate() {
		return enddate;
	}
	public void setEnddate(LocalDate enddate) {
		this.enddate = enddate;
	}
	
	
	
	


}
