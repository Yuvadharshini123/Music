package com.musicalapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.musicalapp.Entity.Course;
import com.musicalapp.Entity.User;

public interface CourseRepository extends JpaRepository<Course, Long>{



}
