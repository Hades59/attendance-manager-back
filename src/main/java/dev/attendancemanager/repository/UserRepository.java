package dev.attendancemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.attendancemanager.entite.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
