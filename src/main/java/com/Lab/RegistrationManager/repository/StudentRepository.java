package com.Lab.RegistrationManager.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Lab.RegistrationManager.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}