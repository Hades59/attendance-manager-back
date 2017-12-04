/**
 * 
 */
package dev.attendancemanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.attendancemanager.entite.Absence;
import dev.attendancemanager.entite.AbsenceStatus;
import dev.attendancemanager.entite.Ferie;
import dev.attendancemanager.entite.FerieType;
import dev.attendancemanager.repository.AbsenceRepository;
import dev.attendancemanager.repository.FerieRepository;

/**
 * @author ETY8
 *
 */
@RestController
@RequestMapping("/feries")
@CrossOrigin(origins = "*")
public class FerieController {
	
	
		
		@Autowired
		FerieRepository ferieRepository;

		@GetMapping
		public List<Ferie> getAbsences(@RequestParam(value="type", required=false) FerieType type) {
			if (type != null) {
				return ferieRepository.findByType(type);
			}
			return ferieRepository.findAll();
		}
	
}
