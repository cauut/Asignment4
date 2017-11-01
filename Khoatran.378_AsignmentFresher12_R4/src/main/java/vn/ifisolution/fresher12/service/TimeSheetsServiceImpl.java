package vn.ifisolution.fresher12.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.ifisolution.fresher12.entity.TblPersional;
import vn.ifisolution.fresher12.entity.TblProject;
import vn.ifisolution.fresher12.entity.TblTimeSheets;
import vn.ifisolution.fresher12.repositories.TimesheetsRepository;

@Service("timeSheetsService")
public class TimeSheetsServiceImpl implements TimeSheetsService {
	@Autowired
	TimesheetsRepository timesheetsRepository;
	@Override
	public void saveTimeSheets(TblTimeSheets registration) {
		// TODO Auto-generated method stub
		timesheetsRepository.save(registration);
		
	}

	@Override
	public List<TblTimeSheets> fetchAll() {
		// TODO Auto-generated method stub
		return timesheetsRepository.findAll();
	}

	@Override
	public void delete(TblTimeSheets studentClassRegistration) {
		// TODO Auto-generated method stub
		timesheetsRepository.delete(studentClassRegistration.getId());
		
	}

	@Override
	public void removeByPersional(Integer idStudent) {
		// TODO Auto-generated method stub
		timesheetsRepository.deleteByPersionalId(idStudent);
		
	}

	@Override
	public void removeByProject(Integer idClass) {
		// TODO Auto-generated method stub
		timesheetsRepository.deleteByProjectId(idClass);
		
	}

	@Override
	public boolean isExit(TblTimeSheets studentClassRegistration) {
		// TODO Auto-generated method stub
		return timesheetsRepository.exists(studentClassRegistration.getId());
	}

	@Override
	public List<TblProject> findProjectByPersionalId(Integer id) {
		// TODO Auto-generated method stub
		return timesheetsRepository.findProjectByPersionalId(id);
	}

	@Override
	public List<TblPersional> findPersionalByProjectId(Integer id) {
		// TODO Auto-generated method stub
		return timesheetsRepository.findPersionalByProjectId(id);
	}
	

}
