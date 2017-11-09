package vn.ifisolution.fresher12.service;

import java.util.List;
import java.util.UUID;

import vn.ifisolution.fresher12.entity.TimeSheet;

public interface TimeSheetService {
	List<TimeSheet> findByProjectId(UUID projectId);
	List<TimeSheet> findByPersonalId(UUID personalId);
	List<TimeSheet> findAll();
	TimeSheet findOne(UUID id);
	void deleteTimeSheet(UUID id);
	void deleteAllTimeSheet(UUID id);
	void update(TimeSheet timeSheet);
	void save(TimeSheet timeSheet);
	void save(Iterable<TimeSheet> timesheets);
}
