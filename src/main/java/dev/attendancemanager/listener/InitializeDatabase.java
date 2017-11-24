package dev.attendancemanager.listener;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/*")
public class InitializeDatabase {
	
	@PostConstruct
	public void initialize(){
		
	}

}
