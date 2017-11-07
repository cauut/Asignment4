package vn.ifisolution.fresher12.repositories;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.jpa.repository.Modifying;

import vn.ifisolution.fresher12.entity.TimeSheet;

public interface TimeSheetRepository extends CassandraRepository<TimeSheet>{
	
	//find by Project Id
	@Query("SELECT * FROM tbltimesheets where id_project = ?0 ALLOW FILTERING")
	Iterable<TimeSheet> findByProjectId(UUID idProject);
	
	@Query("SELECT * FROM tbltimesheets where id_personal= ?0 ALLOW FILTERING")
	Iterable<TimeSheet> findByPersonId(UUID idPerson);
	
	@Modifying
	@Query("DELETE FROM tbltimesheets WHERE id_project = ?0")
	void deleteByProjectId(UUID idProject);
	
	@Modifying
	@Query("DELETE FROM tbltimesheets WHERE id_personal= ?0")
	void deleteByPersonId(UUID idPerson);

}
