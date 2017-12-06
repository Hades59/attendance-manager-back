/**
 * 
 */
package dev.attendancemanager.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

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
	Optional<Ferie> findByDate(LocalDate date);
	Optional<Ferie> findById(int id);

}
