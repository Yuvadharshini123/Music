package com.musicalapp.Service;

import java.util.List;

import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musicalapp.Entity.Course;

import com.musicalapp.Entity.TransactionDetails;
import com.musicalapp.Entity.User;
import com.musicalapp.Exception.UserNotFoundException;
import com.musicalapp.Repository.CourseRepository;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;



@Service
public class CourseServiceImpl implements CourseService{

	private static final String ORDER_PLACED="Placed";
	private static final String KEY="rzp_test_wMRUuqNEymVxhe";
	private static final String KEY_SECRET="TYJbwk0CipDMaW6ddLEsbN4V";
	private static final String CURRENCY ="INR";
	
	
	 @Autowired 
	 private CourseRepository courseRepository;
	
	@Override
	public List<Course> findAll() {
		 List<Course> course=courseRepository.findAll();
		return course;
	}

	//AddCourse
	@Override
	public Course addCourse(Course course) {
		return courseRepository.save(course);
	}
	@Override
	public TransactionDetails createTransaction(Double amount) {
	
		
		
		try {
			
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("amount",(amount*100));
			jsonObject.put("currency",CURRENCY);
			
			RazorpayClient razorpayClient=new RazorpayClient(KEY,KEY_SECRET);
			
			Order order= razorpayClient.orders.create(jsonObject);
			
			TransactionDetails transactionDetails=prepareTransaction(order);
			return transactionDetails;
			//System.out.println(order);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
	        return null;
	}
	
		   private TransactionDetails prepareTransaction(Order order) {
			   String orderId=order.get("id");
			   String currency=order.get("currency");
			   Integer amount=order.get("amount");
			   
			   TransactionDetails transactionDetails=new TransactionDetails(orderId,currency,amount);
			   return transactionDetails;
					   }

		@Override
		public String deleteCourseById(Long courseId) {
			Optional<Course> optionalCourse = courseRepository.findById(courseId);
			if (optionalCourse.isEmpty()) {
				return "There is No User with Id:" + courseId;
			}
			
			//delete user
			courseRepository.deleteById(courseId);
			return "course with Id: " +courseId + " Delete Successfully";
		}

		@Override
		public Course updateCourse(Course course) {
			//First find whether the user is existed to update if not throw exception
			Optional<Course> course1 = courseRepository.findById(course.getId());
			if (course1.isEmpty()) {
				throw new UserNotFoundException("There is no user existed with id: " + course.getId());
			}
			Course course2 = new Course();
			return courseRepository.save(course2);
		}
		
	

	
	}


	
	


            

