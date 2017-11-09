package vn.ifisolution.fresher12.service;

import java.util.List;
import java.util.UUID;

import vn.ifisolution.fresher12.entity.Project;

public interface ProjectService {
	public List<Project> findAll();
	public List<Project> findByPerson();
	public void deleteProject(UUID id);
	public void deleteAll();
	Project findOne(UUID id);
	void update(Project project);
	void save(Project project);
	void save(Iterable<Project> projectList);

}
