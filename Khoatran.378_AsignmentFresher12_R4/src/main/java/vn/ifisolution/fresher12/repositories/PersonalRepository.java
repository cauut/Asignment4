package vn.ifisolution.fresher12.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.ifisolution.fresher12.entity.TblPersional;
@Repository

public interface PersonalRepository extends JpaRepository<TblPersional, Integer>{
	

}
