package dev.attendancemanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@PostMapping(path="/{matricule}/absences")
	public Absence createAbsence(@PathVariable String matricule, @RequestBody Absence absence) {
		absence.setStatus(AbsenceStatus.INITIALE);
		User user = userRepository.findByMatricule(matricule);
		absence.setUser(user);
		
		absenceRepository.save(absence);
		
		return absence;
	}
	
	@DeleteMapping(path="/{matricule}/absences/{id}")
	public Absence deleteAbsence(@PathVariable String matricule, @PathVariable Integer id) {
		
		return null;
	}
}
