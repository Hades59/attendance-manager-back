package dev.attendancemanager.listener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import dev.attendancemanager.entite.Departement;
import dev.attendancemanager.entite.User;
import dev.attendancemanager.repository.UserRepository;

@RestController
@RequestMapping("/*")
@EnableScheduling
public class UsersListener {


	@Autowired
	private UserRepository userRepository;
	private RestTemplate restTemplate = new RestTemplate();
	private ObjectMapper mapper = new ObjectMapper();
	private ResponseEntity<String> response;
	private Integer lastHash = null;
	private String url = "https://raw.githubusercontent.com/DiginamicFormation/ressources-atelier/master/users.json";

	@Autowired 
	private EntityManager entityManager;

	@Scheduled(fixedRate  = 20000)
	@Transactional
	public void update() throws IOException{

		ResponseEntity<String> responseUpdated = restTemplate.getForEntity(url, String.class);
		if(responseUpdated.getBody().hashCode() != lastHash){
			response = responseUpdated;
			rebase();
		}

	}

	@EventListener(ContextRefreshedEvent.class)
	@Transactional
	public void initialize() throws IOException{
		response = restTemplate.getForEntity(url, String.class);

		rebase();
	}

	
	private void rebase() throws IOException {
/*
		entityManager.createNativeQuery("TRUNCATE TABLE absence").executeUpdate();
        entityManager.createNativeQuery("DELETE FROM user").executeUpdate();
        entityManager.createNativeQuery("ALTER TABLE user AUTO_INCREMENT = 1").executeUpdate();*/
		JsonNode array = mapper.readValue(response.getBody(), JsonNode.class);

		List<User> users = new ArrayList<>();

		array.forEach(jsonNode -> {
			String matricule = jsonNode.get("matricule").textValue();
			String firstname = jsonNode.get("prenom").textValue();
			String lastname = jsonNode.get("nom").textValue();
			String email = jsonNode.get("email").textValue();
			String password = jsonNode.get("password").textValue();
			Departement departement = null;

			for (Departement dep : Departement.values()){

				if(dep.getName().equals(jsonNode.get("departement").textValue())){
					departement = Departement.valueOf(dep.name());
					break;
				}
			}

			users.add(new User(matricule, firstname, lastname, email, password, departement));
		});


		Stream.of(users).forEach(userRepository::save);
		lastHash = response.getBody().hashCode();
	}

}

