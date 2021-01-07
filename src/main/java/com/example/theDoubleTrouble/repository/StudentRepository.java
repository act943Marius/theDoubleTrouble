package com.example.theDoubleTrouble.repository;

import com.example.theDoubleTrouble.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByCourseId(Long courseId);
}
