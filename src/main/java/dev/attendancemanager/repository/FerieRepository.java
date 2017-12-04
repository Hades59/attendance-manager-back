/**
 * 
 */
package dev.attendancemanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.attendancemanager.entite.Absence;
import dev.attendancemanager.entite.AbsenceStatus;
import dev.attendancemanager.entite.Ferie;
import dev.attendancemanager.entite.FerieType;

/**
 * @author ETY8
 *
 */
public interface FerieRepository extends JpaRepository<Ferie, Integer>{

	/**
	 * @param type
	 * @return
	 */
	List<Ferie> findByType(FerieType type);

}
