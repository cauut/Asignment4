package vn.ifisolution.fresher12.repositories;

import java.time.LocalDate;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import vn.ifisolution.fresher12.entity.Person;
import vn.ifisolution.fresher12.entity.Project;

public interface ProjectRepository extends CassandraRepository<Project>{
//	@Modifying
	@Query("SELECT * FROM tblproject where type = ?0 ALLOW FILTERING")
	Iterable<Person> findByType(String type);
	
	@Query("SELECT * FROM tblproject where startdate >= ?0  AND enddate <= ?1 ALLOW FILTERING")
	Iterable<Person> findByDate(LocalDate startDate, LocalDate endDate);
}
