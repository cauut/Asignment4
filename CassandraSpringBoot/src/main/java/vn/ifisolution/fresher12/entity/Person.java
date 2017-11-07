package vn.ifisolution.fresher12.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;
//@Entity
@Table(value="tblpeople")
public class Person implements Serializable{
	private PersonId pk;
    private LocalDate birthday;
    private String street_address;
	public Person(PersonId pk, LocalDate birthday, String street_address) {
		super();
		this.pk = pk;
		this.birthday = birthday;
		this.street_address = street_address;
	}
	@PrimaryKey
	public PersonId getPk() {
		return pk;
	}
	public void setPk(PersonId pk) {
		this.pk = pk;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	public String getStreet_address() {
		return street_address;
	}
	public void setStreet_address(String street_address) {
		this.street_address = street_address;
	}
	public Person() {
	}
	
   
}
