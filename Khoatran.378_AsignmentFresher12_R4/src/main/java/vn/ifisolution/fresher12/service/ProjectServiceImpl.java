package vn.ifisolution.fresher12.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.ifisolution.fresher12.entity.TblProject;
import vn.ifisolution.fresher12.repositories.ProjectRepository;

@Service("ProjectService")
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	ProjectRepository projectRepository;
	
	
	/* (non-Javadoc)
	 * @see vn.ifisolution.fresher12.service.StudentsService#findOne(java.lang.Integer)
	 */
	@Override
	public TblProject findOne(Integer id) {
		return projectRepository.findOne(id);
	}
	/* (non-Javadoc)
	 * @see vn.ifisolution.fresher12.service.StudentsService#save(vn.ifisolution.fresher12.entity.Students)
	 */
	@Override
	public void save(TblProject student) {
		projectRepository.save(student);
	}
	/* (non-Javadoc)
	 * @see vn.ifisolution.fresher12.service.StudentsService#fetchAll()
	 */
	@Override
	public List<TblProject> fetchAll(){
		return projectRepository.findAll();
	}
	/* (non-Javadoc)
	 * @see vn.ifisolution.fresher12.service.StudentsService#update(vn.ifisolution.fresher12.entity.Students)
	 */
	@Override
	public void update(TblProject student) {
		TblProject std = findOne(student.getId());
		if(std!=null) {
			std = student;
			projectRepository.save(std);
		}
	}
	/* (non-Javadoc)
	 * @see vn.ifisolution.fresher12.service.StudentsService#isExit(vn.ifisolution.fresher12.entity.Students)
	 */
	@Override
	public boolean isExit(TblProject student) {
		return findOne(student.getId())!=null?true:false;
	}
	/* (non-Javadoc)
	 * @see vn.ifisolution.fresher12.service.StudentsService#delete(vn.ifisolution.fresher12.entity.Students)
	 */
	@Override
	public void delete(TblProject student) {
		projectRepository.delete(student.getId());
	}
	/* (non-Javadoc)
	 * @see vn.ifisolution.fresher12.service.StudentsService#deleteAll()
	 */
	@Override
	public void deleteAll() {
		projectRepository.deleteAll();
	}
}
