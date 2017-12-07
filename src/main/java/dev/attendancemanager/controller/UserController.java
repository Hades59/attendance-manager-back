package dev.attendancemanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import dev.attendancemanager.entite.Absence;
import dev.attendancemanager.entite.AbsenceStatus;
import dev.attendancemanager.entite.User;
import dev.attendancemanager.repository.AbsenceRepository;
import dev.attendancemanager.repository.UserRepository;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired private AbsenceRepository absenceRepository;
	@Autowired private UserRepository userRepository;
	
	@GetMapping
	@Secured({"ROLE_MANAGER", "ROLE_ADMIN"})
	public List<User> getUsers() {
		return userRepository.findAll();
	}
	
	@GetMapping(path="/{matricule}")
	@Secured({"ROLE_MANAGER", "ROLE_EMPLOYE"})
	public User getUsersByMatricule(@PathVariable String matricule) {
		return userRepository.findByMatricule(matricule);
	}
	
	@PostMapping(path="/{matricule}/absences")
	@Secured({"ROLE_MANAGER", "ROLE_EMPLOYE"})
	public Absence createAbsence(@PathVariable String matricule, @RequestBody Absence absence){
		absence.setStatus(AbsenceStatus.INITIALE);
		User user = userRepository.findByMatricule(matricule);
		absence.setUser(user);
		
		absenceRepository.save(absence);
		
		return absence;
	}
	
	@DeleteMapping(path="/{matricule}/absences/{id}")
	@Secured({"ROLE_MANAGER", "ROLE_EMPLOYE"})
	public Absence deleteAbsence(@PathVariable String matricule, @PathVariable int id){
		Absence absence = absenceRepository.findOne(id);
		
		absenceRepository.delete(id);
		
		
		return absence;
	}
	
	
	
}
