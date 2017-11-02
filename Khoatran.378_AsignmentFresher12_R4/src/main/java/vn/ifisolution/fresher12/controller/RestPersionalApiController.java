package vn.ifisolution.fresher12.controller;

import java.util.Date;
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

import vn.ifisolution.fresher12.entity.TblPersional;
import vn.ifisolution.fresher12.service.PersionalService;
@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class RestPersionalApiController {
//	public static final Logger logger = LoggerFactory.getLogger(RestClassesApiController.class);
	@Autowired
	PersionalService persionalService;

	@RequestMapping(value = "/personal", method = RequestMethod.GET)
	public ResponseEntity<List<TblPersional>> getAllClass() {
		List<TblPersional> listClass = persionalService.fetchAll();
		if (listClass.isEmpty())
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<List<TblPersional>>(listClass, HttpStatus.OK);
	}

	@RequestMapping(value = "/personal/{id}", method = RequestMethod.GET)
	public ResponseEntity<TblPersional> getOne(@PathVariable("id") Integer id) {
		TblPersional classes = persionalService.findOne(id);
		if (classes == null) {

			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}

		else
			return new ResponseEntity<TblPersional>(classes, HttpStatus.FOUND);
	}
	//find bay name class
//	@RequestMapping(value = "/classes/{name}/nameClass", method = RequestMethod.GET)
//	public ResponseEntity<List<TblPersional>> getByName(@PathVariable("name") String name) {
//		List<TblPersional> classesList = persionalService.find(name);
//		if (classesList == null) {
//
//			return new ResponseEntity(HttpStatus.NOT_FOUND);
//		}
//
//		else
//			return new ResponseEntity<List<TblPersional>>(classesList, HttpStatus.FOUND);
//	}

	// public
	@RequestMapping(value = "/personal/", method = RequestMethod.POST)
	public ResponseEntity<?> saveEntity(@RequestBody TblPersional classes) {
//		if (persionalService.isExit(classes))
//			return new ResponseEntity(HttpStatus.CONFLICT);
//		else
			persionalService.save(classes);
		return new ResponseEntity<TblPersional>(classes, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/personal/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody TblPersional classes, @PathVariable("id") Integer id) {
		TblPersional std = persionalService.findOne(id);
		if (std == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		} else
			std = classes;
		persionalService.update(std);
		return new ResponseEntity<TblPersional>(classes, HttpStatus.OK);
	}
	// delete

	@RequestMapping(value = "/personal/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
		TblPersional std = persionalService.findOne(id);
		if (std == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		} else
			persionalService.delete(std);
		return new ResponseEntity<TblPersional>(std, HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/personal/", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteAll() {
		persionalService.deleteAll();
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
}