package vn.ifisolution.fresher12.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vn.ifisolution.fresher12.entity.TblProject;
import vn.ifisolution.fresher12.service.ProjectService;
@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class RestProjectApiController {
//	public static final Logger logger = LoggerFactory.getLogger(RestClassesApiController.class);
	@Autowired
	ProjectService projectService;

	@RequestMapping(value = "/project", method = RequestMethod.GET)
	public ResponseEntity<List<TblProject>> getAllClass() {
		List<TblProject> listClass = projectService.fetchAll();
		if (listClass.isEmpty())
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<List<TblProject>>(listClass, HttpStatus.OK);
	}

	@RequestMapping(value = "/project/{id}", method = RequestMethod.GET)
	public ResponseEntity<TblProject> getOne(@PathVariable("id") Integer id) {
		TblProject classes = projectService.findOne(id);
		if (classes == null) {

			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}

		else
			return new ResponseEntity<TblProject>(classes, HttpStatus.FOUND);
	}
	@RequestMapping(value = "/project/", method = RequestMethod.POST)
	public ResponseEntity<?> saveEntity(@RequestBody TblProject classes) {
//		if (projectService.isExit(classes))
//			return new ResponseEntity(HttpStatus.CONFLICT);
//		else
			projectService.save(classes);
		return new ResponseEntity<TblProject>(classes, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/project/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody TblProject classes, @PathVariable("id") Integer id) {
		TblProject std = projectService.findOne(id);
		if (std == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		} else
			std = classes;
		projectService.update(std);
		return new ResponseEntity<TblProject>(classes, HttpStatus.OK);
	}
	// delete

	@RequestMapping(value = "/project/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
		TblProject std = projectService.findOne(id);
		if (std == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		} else
			projectService.delete(std);
		return new ResponseEntity<TblProject>(std, HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/project/", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteAll() {
		projectService.deleteAll();
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
}