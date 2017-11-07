package vn.ifisolution.fresher12;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import vn.ifisolution.fresher12.configuration.CassandraConfiguration;
import vn.ifisolution.fresher12.entity.Person;
import vn.ifisolution.fresher12.entity.Project;
import vn.ifisolution.fresher12.entity.TimeSheet;
import vn.ifisolution.fresher12.repositories.PersonRepository;
import vn.ifisolution.fresher12.repositories.ProjectRepository;
import vn.ifisolution.fresher12.repositories.TimeSheetRepository;

/**
 * Hello world!
 *
 */
@Import(CassandraConfiguration.class)
@SpringBootApplication(scanBasePackages = {"vn.ifisolution.fresher12"})
public class App implements CommandLineRunner{
	@Autowired
	PersonRepository personRepository;
	@Autowired
	ProjectRepository projectRepository;
	@Autowired
	TimeSheetRepository timeSheetRepository;
    public static void main( String[] args ) {
    
    	SpringApplication.run(App.class, args);
    }
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		Iterable<Person> personList = personRepository.findByCity_address("Ha Noi");
		Iterable<Project> projectList = projectRepository.findAll();
		Iterable<TimeSheet> timeSheetList = timeSheetRepository.findByPersonId(UUID.fromString("0458d250-c2f7-11e7-82a3-6558bf84da7a"));
		System.out.println("run console for people");
		for(Person person : personList)
			System.out.println(person.getPk().getName());
		System.out.println("project");
		for(Project project : projectList)
			System.out.println(project.getPk().getName());
		
		System.out.println("time sheet");
		for(TimeSheet timeSheet : timeSheetList)
			System.out.println(timeSheet.getPk().getName());
		
		
	}
}
