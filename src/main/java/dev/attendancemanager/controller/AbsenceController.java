package dev.attendancemanager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import dev.attendancemanager.entite.Absence;
import dev.attendancemanager.entite.AbsenceStatus;
import dev.attendancemanager.repository.AbsenceRepository;
/**
 * 
 * @author ETY23
 *
 */

@RestController
@RequestMapping("/absences")
@CrossOrigin(origins = "*")
public class AbsenceController {
	@Autowired
	AbsenceRepository absenceRepository;
	
	@GetMapping
	public List<Absence> getAbsences(@RequestParam Optional<AbsenceStatus> status) {
		if (status.isPresent()) {
			return absenceRepository.findByStatus(status.get());
		}
		return absenceRepository.findAll();
	}
}


