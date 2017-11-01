package vn.ifisolution.fresher12.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import vn.ifisolution.fresher12.entity.TblPersional;
import vn.ifisolution.fresher12.entity.TblProject;
import vn.ifisolution.fresher12.entity.TblTimeSheets;
@Repository
public interface TimesheetsRepository extends JpaRepository<TblTimeSheets, Integer>{
	@Query("SELECT u from TblPersional u, TblTimeSheets ts WHERE u.id= ts.tblPersional.id AND ts.tblProject.id  = ?1")
	public List<TblPersional> findPersionalByProjectId(Integer id);
	
	@Query("SELECT u from TblProject u, TblTimeSheets ts WHERE u.id= ts.tblProject.id AND ts.tblPersional.id  = ?1")
	public List<TblProject> findProjectByPersionalId(Integer id);
	
	@Modifying
	@Query("DELETE FROM TblTimeSheets WHERE tblPersional.id  =?1")
	public void deleteByPersionalId(Integer id);
	
	@Modifying
	@Query("DELETE FROM TblTimeSheets WHERE tblProject.id  =?1")
	public void deleteByProjectId(Integer id);

}
