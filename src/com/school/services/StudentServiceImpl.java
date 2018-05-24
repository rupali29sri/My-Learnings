package com.school.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.school.beans.Student;
import com.school.dao.StudentDao;

public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentDao studentDao;
	public void insertStudentData(Student student) {
		studentDao.insertStudentData(student);
	}

	
	public List<Student> getStudentList() {
		return studentDao.getStudentList();
	}

	
	public void updateStudentData(Student student) {
		studentDao.updateStudentData(student);
		
	}

	
	public void deleteStudentData(String id) {
		studentDao.deleteStudentData(id);
	}

	
	public Student viewStudentData(int id) {
		return studentDao.viewStudentData(id);
	}

}
