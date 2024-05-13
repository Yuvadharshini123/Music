package com.musicalapp.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import com.musicalapp.Entity.Course;
import com.musicalapp.Entity.TransactionDetails;
import com.musicalapp.Entity.User;
import com.musicalapp.Service.CourseService;



@RestController
@CrossOrigin("*")
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	
	@GetMapping("/getCourse")
    public List<Course> getAllCourses(){
    	List<Course> course=courseService.findAll();
    	return course;
	}  
	@GetMapping("/getCourselevel2")
    public List<Course> getAllCourses2(){
    	List<Course> course=courseService.findAll();
    	return course;
	}  
	@GetMapping("/getCourselevel3")
    public List<Course> getAllCourses3(){
    	List<Course> course=courseService.findAll();
    	return course;
	}  
	
	//AddCourse
	@PostMapping("/addNewCourse")
	public Course registerNewUser(@RequestBody Course course) {
	
		return courseService.addCourse(course);
	}
	
	@PutMapping("UpdateCourseDetails")
	public ResponseEntity<Course> modifyUser(@RequestBody Course course) {
		Course course1 = courseService.updateCourse(course);
		ResponseEntity<Course> responseEntity = new ResponseEntity<>(course1, HttpStatus.OK);
		return responseEntity;
	}
	
	//Delete User 
 	@DeleteMapping("DeleteCourse/{courseId}")
	public ResponseEntity<String> deleteUser(@PathVariable("courseId") Long courseId) {
		String response = courseService.deleteCourseById(courseId);
		ResponseEntity<String> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
		return responseEntity;

	}
 	@GetMapping({"/createTransaction/{amount}"})
    public TransactionDetails createTransaction(@PathVariable(name="amount") Double amount) {
	   return courseService.createTransaction(amount);
	}
}
