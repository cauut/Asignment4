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
public class ObjectId implements Serializable {
	private String partnerId;
	private String bucketId;
	private String objectCode;
	private Date startDate;

	@PrimaryKeyColumn(name = "partner_id", type = PrimaryKeyType.PARTITIONED)
//	@Id
	@CassandraType(type = Name.ASCII)
	public String getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}
	@PrimaryKeyColumn(name = "bucket_id", type = PrimaryKeyType.PARTITIONED)
//	@Id
	@CassandraType(type = Name.ASCII)
	public String getBucketId() {
		return bucketId;
	}

	public void setBucketId(String bucketId) {
		this.bucketId = bucketId;
	}
	@PrimaryKeyColumn(name = "object_code", type = PrimaryKeyType.CLUSTERED, ordering= Ordering.ASCENDING)
//	@Id
	@CassandraType(type = Name.ASCII)
	public String getObjectCode() {
		return objectCode;
	}

	public void setObjectCode(String objectCode) {
		this.objectCode = objectCode;
	}
	@PrimaryKeyColumn(name = "start_date", type = PrimaryKeyType.CLUSTERED, ordering= Ordering.DESCENDING)
//	@Id
	@CassandraType(type = Name.TIMESTAMP)
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public ObjectId(String partnerId, String bucketId, String objectCode, Date startDate) {
		super();
		this.partnerId = partnerId;
		this.bucketId = bucketId;
		this.objectCode = objectCode;
		this.startDate = startDate;
	}

	public ObjectId() {
		super();
	}

}
