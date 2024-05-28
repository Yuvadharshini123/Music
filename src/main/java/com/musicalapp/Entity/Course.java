package com.musicalapp.Entity;

import java.time.LocalDate;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name="course_tbl")
public class Course {
	@Id
	@Column(name="Course_id")
	  @GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;
	
	
	@Column(name="Course_Name")
	private String courseName;
	
	@Column(name="Course_Details")
	private String courseDetails;
	
	@Column(name="Course_Price")
	private String coursePrice;
	
	@Column(name="Course_Date")
	private LocalDate courseDate;
	



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDetails() {
		return courseDetails;
	}

	public void setCourseDetails(String courseDetails) {
		this.courseDetails = courseDetails;
	}

	public String getCoursePrice() {
		return coursePrice;
	}

	public void setCoursePrice(String coursePrice) {
		this.coursePrice = coursePrice;
	}

	public LocalDate getCourseDate() {
		return courseDate;
	}

	public void setCourseDate(LocalDate courseDate) {
		this.courseDate = courseDate;
	}
	
	
}
