package vn.ifisolution.fresher12.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Id;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.CassandraType;
import org.springframework.data.cassandra.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;

import com.datastax.driver.core.DataType.Name;

@PrimaryKeyClass
public class PersonId implements Serializable {
	private UUID id;
	private String name;
	private String city_address;
	private String sex;

	public PersonId(String name, String city_address, String sex) {
		super();
		id = UUID.randomUUID();
		this.name = name;
		this.city_address = city_address;
		this.sex = sex;
	}

	public PersonId(UUID id, String name, String city_address, String sex) {
		super();
		this.id = id;
		this.name = name;
		this.city_address = city_address;
		this.sex = sex;
	}

	// primary key ((id, city_address,sex), name));
	@PrimaryKeyColumn(name = "id", type = PrimaryKeyType.PARTITIONED)
	@Id
	@CassandraType(type = Name.UUID)
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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

	@PrimaryKeyColumn(name = "city_address", type = PrimaryKeyType.PARTITIONED)
	@Id
	@CassandraType(type = Name.TEXT)
	public String getCity_address() {
		return city_address;
	}

	public void setCity_address(String city_address) {
		this.city_address = city_address;
	}

	@PrimaryKeyColumn(name = "sex", type = PrimaryKeyType.PARTITIONED)
	@Id
	@CassandraType(type = Name.TEXT)
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public PersonId() {
	}
	

}
