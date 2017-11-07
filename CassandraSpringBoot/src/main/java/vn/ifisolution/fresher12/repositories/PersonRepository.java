package vn.ifisolution.fresher12.repositories;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.jpa.repository.Modifying;

import vn.ifisolution.fresher12.entity.Person;

public interface PersonRepository extends CassandraRepository<Person>{
	@Modifying
	@Query("SELECT * FROM tblpeople where city_address = ?0 ALLOW FILTERING")
	Iterable<Person> findByCity_address(String cityAddress);
	
	@Query("SELECT * FROM tblpeople where sex = ?0 ALLOW FILTERING")
	Iterable<Person> findByGender(String sex);
	
}
