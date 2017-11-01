package vn.ifisolution.fresher12.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.ifisolution.fresher12.entity.TblPersional;
import vn.ifisolution.fresher12.repositories.PersonalRepository;
@Service("PersionalService")
public class PersionalServiceImpl implements PersionalService {
	@Autowired
	PersonalRepository personalRepository;
	
	
	/* (non-Javadoc)
	 * @see vn.ifisolution.fresher12.service.StudentsService#findOne(java.lang.Integer)
	 */
	@Override
	public TblPersional findOne(Integer id) {
		return personalRepository.findOne(id);
	}
	/* (non-Javadoc)
	 * @see vn.ifisolution.fresher12.service.StudentsService#save(vn.ifisolution.fresher12.entity.Students)
	 */
	@Override
	public void save(TblPersional student) {
		personalRepository.save(student);
	}
	/* (non-Javadoc)
	 * @see vn.ifisolution.fresher12.service.StudentsService#fetchAll()
	 */
	@Override
	public List<TblPersional> fetchAll(){
		return personalRepository.findAll();
	}
	/* (non-Javadoc)
	 * @see vn.ifisolution.fresher12.service.StudentsService#update(vn.ifisolution.fresher12.entity.Students)
	 */
	@Override
	public void update(TblPersional student) {
		TblPersional std = findOne(student.getId());
		if(std!=null) {
			std = student;
			personalRepository.save(std);
		}
	}
	/* (non-Javadoc)
	 * @see vn.ifisolution.fresher12.service.StudentsService#isExit(vn.ifisolution.fresher12.entity.Students)
	 */
	@Override
	public boolean isExit(TblPersional student) {
		return findOne(student.getId())!=null?true:false;
	}
	/* (non-Javadoc)
	 * @see vn.ifisolution.fresher12.service.StudentsService#delete(vn.ifisolution.fresher12.entity.Students)
	 */
	@Override
	public void delete(TblPersional student) {
		personalRepository.delete(student.getId());
	}
	/* (non-Javadoc)
	 * @see vn.ifisolution.fresher12.service.StudentsService#deleteAll()
	 */
	@Override
	public void deleteAll() {
		personalRepository.deleteAll();
	}
	
}
