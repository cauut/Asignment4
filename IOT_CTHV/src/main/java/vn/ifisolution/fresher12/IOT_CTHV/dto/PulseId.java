package vn.ifisolution.fresher12.IOT_CTHV.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.cassandra.core.Ordering;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.mapping.CassandraType;
import org.springframework.data.cassandra.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;

import com.datastax.driver.core.DataType.Name;
@PrimaryKeyClass
public class PulseId implements Serializable{

	private String moduleId;
	private Integer bucketTs;
	private Date ts;
	
	@PrimaryKeyColumn(name = "module_id", type = PrimaryKeyType.PARTITIONED)
//	@Id
	@CassandraType(type = Name.ASCII)
	public String getModuleId() {
		return moduleId;
	}
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	@PrimaryKeyColumn(name = "bucket_ts", type = PrimaryKeyType.PARTITIONED)
//	@Id
	@CassandraType(type = Name.BIGINT)
	public Integer getBucketTs() {
		return bucketTs;
	}
	public void setBucketTs(Integer bucketTs) {
		this.bucketTs = bucketTs;
	}
	@PrimaryKeyColumn(name = "ts", type = PrimaryKeyType.CLUSTERED, ordering=Ordering.DESCENDING)
//	@Id
	@CassandraType(type = Name.TIMESTAMP)
	public Date getTs() {
		return ts;
	}
	public void setTs(Date ts) {
		this.ts = ts;
	}
	public PulseId(String moduleId, Integer bucketTs, Date ts) {
		super();
		this.moduleId = moduleId;
		this.bucketTs = bucketTs;
		this.ts = ts;
	}
	public PulseId() {
		super();
	}
	
	
	
	
//	CREATE TABLE iot_cthv.pulse (
//			module_id ascii,
//			bucket_ts bigint,
//			ts timestamp,
//			champsa ascii,
//			PRIMARY KEY (( module_id, bucket_ts ), ts)
//			) WITH CLUSTERING ORDER BY ( ts DESC );
}
