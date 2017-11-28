package dev.attendancemanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.attendancemanager.entite.Absence;
import dev.attendancemanager.repository.AbsenceRepository;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired private AbsenceRepository repoAbsence;
	
	@PostMapping(path="/{matricule}/absences")
	public Absence createAbsence(@PathVariable String matricule, @RequestBody Absence data){
		repoAbsence.save(data);
		return data;
	}
}
