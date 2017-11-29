/**
 * 
 */
package dev.attendancemanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.attendancemanager.entite.Absence;
import dev.attendancemanager.repository.AbsenceRepository;

/**
 * @author ETY8
 *
 */
@RestController
@RequestMapping("/absences")
@CrossOrigin(origins = "*")
public class AbsenceController {
	@Autowired
	AbsenceRepository absenceRepository;
	
	@GetMapping
	public List<Absence> absenceList(){
		return absenceRepository.findAll();
	}

}
