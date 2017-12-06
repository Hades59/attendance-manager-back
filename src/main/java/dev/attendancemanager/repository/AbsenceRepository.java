package dev.attendancemanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.attendancemanager.entite.Absence;
import dev.attendancemanager.entite.AbsenceStatus;

public interface AbsenceRepository extends JpaRepository<Absence, Integer>{
	List<Absence> findByStatus(AbsenceStatus status);
	
}
