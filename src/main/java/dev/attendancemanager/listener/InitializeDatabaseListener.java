package dev.attendancemanager.listener;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import dev.attendancemanager.entite.AbscenceType;
import dev.attendancemanager.entite.Absence;
import dev.attendancemanager.entite.AbsenceStatus;
import dev.attendancemanager.entite.Departement;
import dev.attendancemanager.entite.Ferie;
import dev.attendancemanager.entite.FerieType;
import dev.attendancemanager.entite.Role;
import dev.attendancemanager.entite.User;
import dev.attendancemanager.repository.AbsenceRepository;
import dev.attendancemanager.repository.FerieRepository;
import dev.attendancemanager.repository.UserRepository;

@EnableScheduling
@Service
public class InitializeDatabaseListener {

	@Autowired private UserRepository userRepository;

	@Autowired private FerieRepository ferieRepository;

	@Autowired private AbsenceRepository absenceRepository;

	private RestTemplate restTemplate = new RestTemplate();
	@Autowired private ObjectMapper mapper;
	private ResponseEntity<String> response;
	private Integer lastHash = null;
	private String url = "https://raw.githubusercontent.com/DiginamicFormation/ressources-atelier/master/users.json";

	@Scheduled(fixedRate = 30000)
	@Transactional
	public void update() throws IOException {

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

		List<User> users = rebase();

		List<Ferie> feries = new ArrayList<>();

		List<Absence> abscences = new ArrayList<>();

		Absence absence1 = new Absence(
				LocalDate.of(2017, 12, 11),
				LocalDate.of(2017, 12, 12),
				"Week-end prolongé",
				AbscenceType.CONGE_PAYE,
				AbsenceStatus.EN_ATTENTE_VALIDATION);

		Absence absence2 = new Absence(
				LocalDate.of(2017, 12, 20),
				LocalDate.of(2017, 12, 27),
				"Vacances de noel",
				AbscenceType.CONGE_PAYE,
				AbsenceStatus.EN_ATTENTE_VALIDATION);

		Absence absence3 = new Absence(
				LocalDate.of(2018, 1, 29),
				LocalDate.of(2018, 2, 10),
				"RTT",
				AbscenceType.RTT,
				AbsenceStatus.EN_ATTENTE_VALIDATION);

		Absence absence4 = new Absence(
				LocalDate.of(2017, 12, 11),
				LocalDate.of(2017, 12, 15),
				"RTT",
				AbscenceType.RTT,
				AbsenceStatus.EN_ATTENTE_VALIDATION);

		absence1.setUser(users.get(1));
		absence2.setUser(users.get(5));
		absence3.setUser(users.get(0));
		absence4.setUser(users.get(0));

		abscences.add(absence1);
		abscences.add(absence2);
		abscences.add(absence3);
		abscences.add(absence4);

		abscences.forEach(absenceRepository::save);

		Ferie ferie = new Ferie(
				LocalDate.of(2018, 5, 1),
				FerieType.FERIE,
				"Fête du travail");

		Ferie ferie2 = new Ferie(
				LocalDate.of(2018, 8, 14),
				FerieType.FERIE,
				"Fête Nationale");


		feries.add(ferie);
		feries.add(ferie2);
		feries.forEach(ferieRepository::save);
		
	}

	private List<User> rebase() throws IOException {
		JsonNode array = mapper.readValue(response.getBody(), JsonNode.class);

		List<User> users = new ArrayList<>();

		array.forEach(jsonNode -> {
			String matricule = jsonNode.get("matricule").textValue();
			String firstname = jsonNode.get("prenom").textValue();
			String lastname = jsonNode.get("nom").textValue();
			String email = jsonNode.get("email").textValue();
			String password = jsonNode.get("password").textValue();
			Departement departement = null;
			Role role = Role.ROLE_MANAGER;

			for (Departement dep : Departement.values()){

				if(dep.getName().equals(jsonNode.get("departement").textValue())){
					departement = Departement.valueOf(dep.name());
					break;
				}
			}

			users.add(new User(matricule, firstname, lastname, email, password, departement, role));
		});
		
		List<User> usersBase = userRepository.findAll();
		

		users.stream().map(u -> {
			
			Optional<User> uB = usersBase.stream().filter(base -> base.getMatricule().equals(u.getMatricule())).findAny();
			
			uB.ifPresent(base -> u.setId(base.getId()));
			return u;
			
		}).forEach(userRepository::save);
		
		lastHash = response.getBody().hashCode();

		return users;
	}

}

