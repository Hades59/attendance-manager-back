package dev.attendancemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.attendancemanager.entite.Absence;

public interface AbsenceRepository extends JpaRepository<Absence, Integer>{

}
