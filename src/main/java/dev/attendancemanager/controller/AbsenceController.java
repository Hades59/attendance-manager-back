package dev.attendancemanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}


