package com.springboot.example.springBootrestServices.service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.springboot.example.springBootrestServices.model.Course;
import com.springboot.example.springBootrestServices.model.Student;

@Component
public class StudentService {

	
	private static List<Student> students=new ArrayList<>();
	private static SecureRandom random;
	static {
		//Initialize Data
		Course course1=new Course("Course1","Spring","10 Steps",
				Arrays.asList("Learn Maven","Import project","First Example","Second Example"));
		
		Course course2=new Course("Course2","Spring MVC","10 Examples",
				Arrays.asList("Learn Maven","Import project","First Example","Second Example"));
		
		Course course3=new Course("Course3","Spring Boot","6k Students",
				Arrays.asList("Learn Maven","Import project","First Example","Second Example"));
		
		Course course4=new Course("Course4","Maven","Most Popular maven course on internet",
				Arrays.asList("Learn Maven","Import project","First Example","Second Example"));
		
		Student ranga=new Student("Student1","Ranga Karanam",
				"Hiker, Programmer and architect",new ArrayList<>(Arrays.asList(course1,course2,course3,course4)));
		
		Student satish=new Student("Student2","Satish T",
				"Hiker, Programmer and architect",new ArrayList<>(Arrays.asList(course1,course2,course3,course4)));
		
		  random=new SecureRandom();
		
		students.add(ranga);
 		students.add(satish);
	}
	
	public List<Student> retrieveAllStudents(){
		
		return students;
	}
	
	public Student retrieveStudent(String studentId)
	{
		for(Student student : students) {
			if(student.getId().equals(studentId))
					return student;
		}
		return null;
	}
	
	public List<Course> retrieveCourses(String studentId)
	{
		Student student=retrieveStudent(studentId);
		if(student==null)
		{
			return null;
		}		
		return student.getCourses();
	}
	public Course retrieveCourse(String studentId,String courseId) {
		
		Student student=retrieveStudent(studentId);
		if(student==null)
		{
			return null;
		}	
		
		for(Course course:student.getCourses()) {
			if(course.getId().equals(courseId))
				return course;
		}
		return null;
	}
	
	
	
	public Course addCourse(String studentId,Course course)
	{
		Student student=retrieveStudent(studentId);
		if(student==null)
		{
			return null;
		}
		String randomId=new BigInteger(130,random).toString(32);
		course.setId(randomId);
		student.getCourses().add(course);
		return course;
	}
	
	
	
	
	
	
	
	
}

