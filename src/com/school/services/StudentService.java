package com.school.services;

import java.util.List;

import com.school.beans.Student;

public interface StudentService {

	public void insertStudentData(Student student);  
	 public List<Student> getStudentList();  
	 public void updateStudentData(Student student);  
	 public void deleteStudentData(String id);  
	 public Student viewStudentData(int id);  
}
