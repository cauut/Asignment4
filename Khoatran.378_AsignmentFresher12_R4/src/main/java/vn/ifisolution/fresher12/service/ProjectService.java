package vn.ifisolution.fresher12.service;

import java.util.List;

import vn.ifisolution.fresher12.entity.TblProject;

public interface ProjectService {

	TblProject findOne(Integer id);

	void save(TblProject student);

	List<TblProject> fetchAll();

	void update(TblProject student);

	boolean isExit(TblProject student);

	void delete(TblProject student);

	void deleteAll();

}