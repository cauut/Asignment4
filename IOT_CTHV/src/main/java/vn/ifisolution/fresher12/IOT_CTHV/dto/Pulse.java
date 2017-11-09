package vn.ifisolution.fresher12.IOT_CTHV.dto;

import java.io.Serializable;

import org.springframework.data.cassandra.mapping.CassandraType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import com.datastax.driver.core.DataType.Name;
@Table(value="pulse")
public class Pulse implements Serializable{
	
	private PulseId pk;
	private String champsa;
	@PrimaryKey
	public PulseId getPk() {
		return pk;
	}
	public void setPk(PulseId pk) {
		this.pk = pk;
	}
	@Column(value="champsa")
	@CassandraType(type=Name.ASCII)
	public String getChampsa() {
		return champsa;
	}
	public void setChampsa(String champsa) {
		this.champsa = champsa;
	}
	public Pulse() {
		super();
	}
	public Pulse(PulseId pk, String champsa) {
		super();
		this.pk = pk;
		this.champsa = champsa;
	}
	
	
}
