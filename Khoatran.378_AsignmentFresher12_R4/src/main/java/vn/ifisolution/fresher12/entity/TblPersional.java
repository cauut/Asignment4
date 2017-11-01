// default package
// Generated Oct 31, 2017 11:36:24 AM by Hibernate Tools 5.1.5.Final
package vn.ifisolution.fresher12.entity;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * TblPersional generated by hbm2java
 */
@Entity
@Table(name = "tblPersional_khoa")
public class TblPersional implements java.io.Serializable {

	private Integer id;
	private String name;
	private Date birthday;
	private String address;
	private Set<TblTimeSheets> tblTimeSheetses = new HashSet<TblTimeSheets>(0);

	public TblPersional() {
	}

	public TblPersional(String name, java.sql.Date birthday, String address) {
		this.name = name;
		this.birthday = birthday;
		this.address = address;
	}

	public TblPersional(String name, java.sql.Date birthday, String address, Set<TblTimeSheets> tblTimeSheetses) {
		this.name = name;
		this.birthday = birthday;
		this.address = address;
		this.tblTimeSheetses = tblTimeSheetses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false, length = 40)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "birthday", nullable = false, length = 10)
	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(java.sql.Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "address", nullable = false, length = 100)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tblPersional")
	public Set<TblTimeSheets> getTblTimeSheetses() {
		return this.tblTimeSheetses;
	}

	public void setTblTimeSheetses(Set<TblTimeSheets> tblTimeSheetses) {
		this.tblTimeSheetses = tblTimeSheetses;
	}

}
