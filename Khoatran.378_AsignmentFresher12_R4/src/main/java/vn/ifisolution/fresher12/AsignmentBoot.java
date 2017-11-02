package vn.ifisolution.fresher12;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import vn.ifisolution.fresher12.configuration.JpaConfigAsignment;
import vn.ifisolution.fresher12.entity.TblPersional;
import vn.ifisolution.fresher12.entity.TblProject;
import vn.ifisolution.fresher12.entity.TblTimeSheets;
import vn.ifisolution.fresher12.service.PersionalService;
import vn.ifisolution.fresher12.service.ProjectService;
import vn.ifisolution.fresher12.service.TimeSheetsService;

@Import(JpaConfigAsignment.class)
@SpringBootApplication(scanBasePackages={"vn.ifisolution.fresher12"})// same as @Configuration @EnableAutoConfiguration @ComponentScan
public class AsignmentBoot implements CommandLineRunner{
	@Autowired 
	PersionalService persionalService;
	@Autowired
	ProjectService projectService;
	@Autowired
	TimeSheetsService timeSheetsService;

	public static void main(String[] args) {
		SpringApplication.run(AsignmentBoot.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		persionalService.save(new TblPersional("khoa", new Date(new java.util.Date().getTime()), "Chuong My"));
		projectService.save(new TblProject("Fontand", "Asignment", new java.util.Date(),new java.util.Date()));
		timeSheetsService.saveTimeSheets(new TblTimeSheets(new TblPersional(1,"khoa", new Date(new java.util.Date().getTime()), "Chuong My"), new TblProject(1,"Fontand", "Asignment", new java.util.Date(),new java.util.Date()),  new Date(new java.util.Date().getTime()),  new Date(new java.util.Date().getTime()), "khong co mo ta", "khong luong"));
		
	}
}
