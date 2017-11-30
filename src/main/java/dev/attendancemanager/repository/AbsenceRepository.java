package dev.attendancemanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dev.attendancemanager.entite.Absence;
import dev.attendancemanager.entite.AbsenceStatus;

public interface AbsenceRepository extends JpaRepository<Absence, Integer>{
	List<Absence> findByStatus(AbsenceStatus status);
	
	@Query("select a from Absence a where a.user.matricule=:matricule")
	List<Absence> findByMatricule(@Param("matricule") String matricule);

}
