package tn.com.etap.EtapWorkers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.stream.*;

import tn.com.etap.EtapWorkers.Dao.TaskRepository;
import tn.com.etap.EtapWorkers.Service.AccountService;
import tn.com.etap.EtapWorkers.model.AppRole;
import tn.com.etap.EtapWorkers.model.AppUser;
import tn.com.etap.EtapWorkers.model.Task;

@SpringBootApplication

public class EtapWorkersApplication implements CommandLineRunner{

	
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private AccountService accountService;
	
	public static void main(String[] args) {
		SpringApplication.run(EtapWorkersApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
	//accountService.saveUser(new AppUser(null,"admin" , "1234","admin", "yes", "ncncncncnc", 58555855,
		//		df.parse("15/1/1988"), df.parse("19/5/2020"), "bayern","office" , "fdfdfd", "bxbcbcb", "bdbdbdb", false, null, null));
	//	accountService.saveUser(new AppUser(null,"user" , "1234",null, null, null, 0, null, null, null, null, null, null, false, null, null));
		
		//accountService.saveRole(new AppRole(null,"USER"));

		//accountService.saveRole(new AppRole(null,"ADMIN"));

		//accountService.addRoleToUser("admin", "ADMIN");
	//	accountService.addRoleToUser("admin", "USER");

	//	accountService.addRoleToUser("user", "USER");

		
		

		
	/*	
		
		Stream.of("T1","T2","T3").forEach(t->{
			taskRepository.save(new Task(null,t));
			
		});
		taskRepository.findAll().forEach(t->{
			System.out.println(t.getTaskName());
		});
		*/
	}
	
	
	@Bean
	public BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder();
	}

}
