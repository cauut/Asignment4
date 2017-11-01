package vn.ifisolution.fresher12.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import vn.ifisolution.fresher12.entity.TblPersional;
import vn.ifisolution.fresher12.entity.TblProject;
import vn.ifisolution.fresher12.entity.TblTimeSheets;
import vn.ifisolution.fresher12.service.TimeSheetsService;
import vn.ifisolution.fresher12.util.CustomErrorType;
//service for student class registration
@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class RestTimeSheetApi {
	public static final Logger logger = LoggerFactory.getLogger(RestTimeSheetApi.class);
	@Autowired
	TimeSheetsService timeSheetsService;

	// find all List
	@RequestMapping(value = "/timesheet", method = RequestMethod.GET)

	public ResponseEntity<List<TblTimeSheets>> findAll() {
		List<TblTimeSheets> listSCR = timeSheetsService.fetchAll();
		if (listSCR == null || listSCR.size() == 0)
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<List<TblTimeSheets>>(listSCR, HttpStatus.OK);
	}

	@RequestMapping(value = "/timesheet/{id}/idproject", method = RequestMethod.GET)
	public ResponseEntity<List<TblPersional>> findClassByStudent(@PathVariable("id") Integer id) {
		List<TblPersional> listSCR = timeSheetsService.findPersionalByProjectId(id);
		if (listSCR == null || listSCR.size() == 0)
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<List<TblPersional>>(listSCR, HttpStatus.OK);
	}
	
	//find student by id class
	@RequestMapping(value = "/timesheet/{id}/idpersonal", method = RequestMethod.GET)
	public ResponseEntity<List<TblProject>> findStudentClass(@PathVariable("id") Integer id) {
		List<TblProject> listSCR = timeSheetsService.findProjectByPersionalId(id);
		if (listSCR == null || listSCR.size() == 0)
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<List<TblProject>>(listSCR, HttpStatus.OK);
	}

	// save registration
	@RequestMapping(value = "/timesheet/", method = RequestMethod.POST)
	public ResponseEntity save(@RequestBody TblTimeSheets scr, UriComponentsBuilder ucBuilder) {
		if (timeSheetsService.isExit(scr)) {
			logger.error("Unable to create. A registration with name {} already exist", scr.toString());
			return new ResponseEntity(new CustomErrorType(" already exist."), HttpStatus.CONFLICT);
		}
		timeSheetsService.saveTimeSheets(scr);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/studentclassregistration/{id}").buildAndExpand(scr.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	// update registration
	@RequestMapping(value = "/timesheet/", method = RequestMethod.PUT)
	public ResponseEntity update(@RequestBody TblTimeSheets scr) {
		if (!timeSheetsService.isExit(scr)) {
			logger.error("Unable to upde. A registration  with name {} not already exist", scr.toString());
			return new ResponseEntity(new CustomErrorType(" already exist."), HttpStatus.NOT_FOUND);
		}
		timeSheetsService.saveTimeSheets(scr);
//		timeSheetsServic
		return new ResponseEntity(HttpStatus.OK);

	}

	// delete

	@RequestMapping(value = "/timesheet/", method = RequestMethod.DELETE)
	public ResponseEntity delete(@RequestBody TblTimeSheets studentClassRegistrations) {
		if (timeSheetsService.isExit(studentClassRegistrations) == false)
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		else
			timeSheetsService.delete(studentClassRegistrations);
		return new ResponseEntity<TblTimeSheets>(studentClassRegistrations, HttpStatus.NO_CONTENT);
	}

	// delete by student id
	@RequestMapping(value = "/timesheet/{id}/idProject", method = RequestMethod.DELETE)
	public ResponseEntity deleteByStudent(@PathVariable("id") Integer id) {

		timeSheetsService.removeByProject(id);
		return new ResponseEntity<Integer>(id, HttpStatus.NO_CONTENT);
	}

	// delete by class id
	@RequestMapping(value = "/timesheet/{id}/idperson", method = RequestMethod.DELETE)
	public ResponseEntity deleteByClass(@PathVariable("id") Integer id) {

		timeSheetsService.removeByPersional(id);
		return new ResponseEntity<Integer>(id, HttpStatus.NO_CONTENT);
	}
	

}