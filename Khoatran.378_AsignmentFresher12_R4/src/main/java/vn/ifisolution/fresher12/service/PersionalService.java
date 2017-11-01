package vn.ifisolution.fresher12.service;

import java.util.List;

import vn.ifisolution.fresher12.entity.TblPersional;

public interface PersionalService {

	TblPersional findOne(Integer id);

	void save(TblPersional student);

	List<TblPersional> fetchAll();

	void update(TblPersional student);

	boolean isExit(TblPersional student);

	void delete(TblPersional student);

	void deleteAll();

}