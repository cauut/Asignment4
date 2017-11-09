package vn.ifisolution.fresher12.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.repository.support.BasicMapId;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import vn.ifisolution.fresher12.entity.Person;
import vn.ifisolution.fresher12.repositories.PersonRepository;

@Service("personService")
public class PersonServiceImpl implements PersonService{
	@Autowired
	PersonRepository personRepository;

	@Override
	public List<Person> findAll() {
		// TODO Auto-generated method stub
		return Lists.newArrayList(personRepository.findAll());
	}

	@Override
	public List<Person> findByProject(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePerson(UUID id) {
		// TODO Auto-generated method stub
		personRepository.delete(new BasicMapId().id("id", id));
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		personRepository.deleteAll();
	}

	@Override
	public Person findOne(UUID id) {
		// TODO Auto-generated method stub
		return personRepository.findOne(new BasicMapId().id("id", id));
	}

	@Override
	public void update(Person person) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(Person person) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(Iterable<Person> personList) {
		// TODO Auto-generated method stub
		
	}
}
