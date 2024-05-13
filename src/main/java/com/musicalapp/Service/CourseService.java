package com.musicalapp.Service;

import java.util.List;



import com.musicalapp.Entity.Course;


import com.musicalapp.Entity.TransactionDetails;


public interface CourseService {

	public List<Course> findAll();
	
	public TransactionDetails createTransaction(Double amount);

	public String deleteCourseById(Long courseId);

	public Course addCourse(Course course);


	public Course updateCourse(Course course);

}
