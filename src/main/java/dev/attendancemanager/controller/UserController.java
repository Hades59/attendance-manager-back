package dev.attendancemanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.attendancemanager.entite.Absence;
import dev.attendancemanager.entite.AbsenceStatus;
import dev.attendancemanager.entite.User;
import dev.attendancemanager.repository.AbsenceRepository;
import dev.attendancemanager.repository.UserRepository;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private AbsenceRepository absenceRepository;
	@Autowired
	private UserRepository userRepository;

	/**
	 * Method for create and update an absence
	 * 
	 * @param matricule
	 * @param absence
	 * @return Absence
	 */
	@PostMapping(path = "/{matricule}/absences")
	public Absence createAbsence(@PathVariable String matricule, @RequestBody Absence absence) {

		// si l'id est valoriser => update
		System.out.println(absence);
		absence.setStatus(AbsenceStatus.INITIALE);
		System.out.println("###############################################Mon id :"+absence.getId());
		User user = userRepository.findByMatricule(matricule);
		absence.setUser(user);
		absenceRepository.save(absence);

		return absence;
	}
	
	
	

}
