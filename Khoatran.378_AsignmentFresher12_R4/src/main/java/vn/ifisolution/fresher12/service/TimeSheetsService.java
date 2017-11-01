package vn.ifisolution.fresher12.service;

import java.util.List;

import vn.ifisolution.fresher12.entity.TblPersional;
import vn.ifisolution.fresher12.entity.TblProject;
import vn.ifisolution.fresher12.entity.TblTimeSheets;

public interface TimeSheetsService {

	void saveTimeSheets(TblTimeSheets registration);
	
	List<TblTimeSheets> fetchAll();
	void delete(TblTimeSheets studentClassRegistration);
	void removeByPersional(Integer idStudent);
	void removeByProject(Integer idClass);
	
	boolean isExit(TblTimeSheets studentClassRegistration);
	List<TblProject> findProjectByPersionalId(Integer id);
	List<TblPersional> findPersionalByProjectId(Integer id);
}