package vn.ifisolution.fresher12.service;

import java.util.List;
import java.util.UUID;

import vn.ifisolution.fresher12.entity.Person;

public interface PersonService {
	public List<Person> findAll();
	public List<Person> findByProject(UUID id);
	public void deletePerson(UUID id);
	public void deleteAll();
	Person findOne(UUID id);
	void update(Person person);
	void save(Person person);
	void save(Iterable<Person> personList);
	
}
