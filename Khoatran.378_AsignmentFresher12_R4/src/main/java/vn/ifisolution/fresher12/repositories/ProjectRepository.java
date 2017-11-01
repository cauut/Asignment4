package vn.ifisolution.fresher12.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.ifisolution.fresher12.entity.TblProject;
@Repository
public interface ProjectRepository extends JpaRepository<TblProject, Integer>{

}
