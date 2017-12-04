package dev.attendancemanager.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.attendancemanager.entite.Absence;
import dev.attendancemanager.entite.AbsenceStatus;
import dev.attendancemanager.repository.AbsenceRepository;
import dev.attendancemanager.util.Avis;
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
	public List<Absence> getAbsences(@RequestParam(value="status", required=false) AbsenceStatus status) {
		if (status != null) {
			return absenceRepository.findByStatus(status);
		}
		return absenceRepository.findAll();
	}
}