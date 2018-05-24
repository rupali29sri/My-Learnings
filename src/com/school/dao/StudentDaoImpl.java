package com.school.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.school.beans.Student;

public class StudentDaoImpl implements StudentDao{

	@Autowired
	DataSource dataSource;  
	
	 
	
	public void addingAndUpdateCommonOperation(Student student, String sql)
	{
		 JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  
		  String address=student.getPermanentAddress().getStreet()+","+student.getPermanentAddress().getCity()+","+
				  student.getPermanentAddress().getCountry()+"-"+student.getPermanentAddress().getPincode();
		  ArrayList<String> hobbies =student.getHobbies();
		  String hobbyList="";
		  Iterator<String> itr = hobbies.iterator();
	        while(itr.hasNext())
	        {
	        	hobbyList+=itr.next()+",";
	        }
	        if (hobbyList.length() > 0 && hobbyList.charAt(hobbyList.length()-1)==',') {
	        	hobbyList = hobbyList.substring(0, hobbyList.length()-1);
	          }
		  
		  jdbcTemplate.update(  
		    sql,  
		    new Object[] { student.getStudentName(), 
		    			   student.getFatherName(),
		    			   student.getMotherName(),
		    			   student.getDateOfBirth(),
		    			   student.getClassNumber(),			    			   
		    			   student.getCountOfSibling(),
		    			   student.getCategory(),
		    			   address,
		    			   student.getFatherEmployment(),
		    			   student.getMotherEmployment(),
		    			   student.getPreviousSchoolName(),
		    			   student.getContactNumber(),
		    			   student.getIdentityProof(),
		    			   student.getPhysicalDisability(),
		    			   hobbyList });  
	
	}
	public void insertStudentData(Student student) {
		String sql = "INSERT INTO student_profile "  
			    + "(student_name ,"
			    + "	father_name ,"
			    + "	mother_name ,"
			    + "	date_of_birth ,"
			    + "class_number ,"
			    + "count_of_sibling ,"
			    + "	category,"
				+ "permanent_address ,"
				+ "	father_employment ,"
				+ "mother_employment ,"
				+ "previous_school_name ,"
				+ "contact_number ,"
				+ "identity_proof ,"
				+ "physical_disability ,"
				+ "hobbies) VALUES (?, ?, ?,?,?,?,?,?,?,?,?,?,?,?,?)";  
			  System.out.println("sql="+sql);
			  addingAndUpdateCommonOperation(student,sql);
			  
			 /* JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  
			  String address=student.getPermanentAddress().getStreet()+","+student.getPermanentAddress().getCity()+","+
					  student.getPermanentAddress().getCountry()+"-"+student.getPermanentAddress().getPincode();
			  ArrayList<String> hobbies =student.getHobbies();
			  String hobbyList="";
			  Iterator<String> itr = hobbies.iterator();
		        while(itr.hasNext())
		        {
		        	hobbyList+=itr.next()+",";
		        }
		        if (hobbyList.length() > 0 && hobbyList.charAt(hobbyList.length()-1)==',') {
		        	hobbyList = hobbyList.substring(0, hobbyList.length()-1);
		          }
			  
			  jdbcTemplate.update(  
			    sql,  
			    new Object[] { student.getStudentName(), 
			    			   student.getFatherName(),
			    			   student.getMotherName(),
			    			   student.getDateOfBirth(),
			    			   student.getClassNumber(),			    			   
			    			   student.getCountOfSibling(),
			    			   student.getCategory(),
			    			   address,
			    			   student.getFatherEmployment(),
			    			   student.getMotherEmployment(),
			    			   student.getPreviousSchoolName(),
			    			   student.getContactNumber(),
			    			   student.getIdentityProof(),
			    			   student.getPhysicalDisability(),
			    			   hobbyList });  
		*/
	}

	
	public List<Student> getStudentList() {
		String sql = "SELECT * FROM student_profile";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
	    List<Student> listStudent = jdbcTemplate.query(sql, new RowMapper<Student>() {
	 
	       	@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				 Student aStudent = new Student();
				 //SimpleDateFormat formatter=new SimpleDateFormat();
				 	aStudent.setStudentId(rs.getInt("student_id"));
				 	aStudent.setStudentName(rs.getString("student_name"));
				 	aStudent.setDateOfBirth(rs.getDate("date_of_birth"));
				 	aStudent.setContactNumber(rs.getLong("contact_number"));
				 			 
		            return aStudent;
			}
	 
	    });
	 
	    return listStudent;
	}

	
	public void updateStudentData(Student student) {
		if (student.getStudentId() > 0) {
	        // UPDATE
			String sql = "UPDATE student_profile "  
				    + "SET student_name=? ,"
				    + "SET father_name=? ,"
				    + "SET mother_name=? ,"
				    + "SET date_of_birth=? ,"
				    + "SET class_number=? ,"
				    + "SET count_of_sibling=? ,"
				    + "SET category=?,"
					+ "SET permanent_address=? ,"
					+ "SET father_employment=? ,"
					+ "SET mother_employment=? ,"
					+ "SET previous_school_name=? ,"
					+ "SET contact_number=? ,"
					+ "SET identity_proof=? ,"
					+ "SET physical_disability=? ,"
					+ "SET hobbies=? WHERE student_id=?";  
	       
			addingAndUpdateCommonOperation(student,sql);
			
	    } else {
	        // insert
	    	insertStudentData(student);
	    }
	 
		
	}

	
	public void deleteStudentData(String studentId) {
		String sql = "DELETE FROM student_profile WHERE student_id=?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
	    jdbcTemplate.update(sql, studentId);
	}

	
	public Student viewStudentData(int studentId) {
		String sql = "SELECT * FROM student_profile WHERE student_id=" + studentId;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
	    return jdbcTemplate.query(sql, new ResultSetExtractor<Student>() {
	 
	        @Override
	        public Student extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	            	Student student = new Student();
	            	student.setStudentId(rs.getInt("student_id"));
				 	student.setStudentName(rs.getString("student_name"));
				 	student.setDateOfBirth(rs.getDate("date_of_birth"));
				 	student.setContactNumber(rs.getLong("contact_number"));				 	
				 	student.setFatherName(rs.getString("father_name"));
				 	student.setMotherName(rs.getString("mother_name"));				 	
				 	student.setClassNumber(rs.getString("class_number"));
				 	student.setCountOfSibling(rs.getString("count_of_sibling"));
				 	student.setCategory(rs.getString("category"));
				 	//student.setPermanentAddress(permanentAddress);(rs.getString("permanent_address"));
				 	student.setFatherEmployment(rs.getString("father_employment"));
				 	student.setMotherEmployment(rs.getString("mother_employment"));
				 	student.setPreviousSchoolName(rs.getString("previous_school_name"));				 	
				 	student.setIdentityProof(rs.getString("identity_proof"));
				 	student.setPhysicalDisability(rs.getString("physical_disability"));
				 	//student.setHobbies(rs.getString("hobbies")); 
	                return student;
	            }
	 
	            return null;
	        }
	 
	    });
	}

}
