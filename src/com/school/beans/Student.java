/**
 * 
 */
package com.school.beans;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author nihal
 *
 */
public class Student {
 
	private int studentId;
	private String studentName ;
	private String fatherName ;
	private String motherName ;
	private Date dateOfBirth ;
	private String classNumber ;
	private String countOfSibling; 
	private String category ;
	private Address permanentAddress; 
	private String fatherEmployment ;
	private String motherEmployment ;
	private String previousSchoolName; 
	private Long contactNumber;
	private String identityProof ;
	private String physicalDisability;
	private ArrayList<String> hobbies;
	
	
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getStudentId() {
		return studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getClassNumber() {
		return classNumber;
	}
	public void setClassNumber(String classNumber) {
		this.classNumber = classNumber;
	}
	public String getCountOfSibling() {
		return countOfSibling;
	}
	public void setCountOfSibling(String countOfSibling) {
		this.countOfSibling = countOfSibling;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Address getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(Address permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	public String getFatherEmployment() {
		return fatherEmployment;
	}
	public void setFatherEmployment(String fatherEmployment) {
		this.fatherEmployment = fatherEmployment;
	}
	public String getMotherEmployment() {
		return motherEmployment;
	}
	public void setMotherEmployment(String motherEmployment) {
		this.motherEmployment = motherEmployment;
	}
	public String getPreviousSchoolName() {
		return previousSchoolName;
	}
	public void setPreviousSchoolName(String previousSchoolName) {
		this.previousSchoolName = previousSchoolName;
	}
	public String getIdentityProof() {
		return identityProof;
	}
	public void setIdentityProof(String identityProof) {
		this.identityProof = identityProof;
	}
	public String getPhysicalDisability() {
		return physicalDisability;
	}
	public void setPhysicalDisability(String physicalDisability) {
		this.physicalDisability = physicalDisability;
	}
	public ArrayList<String> getHobbies() {
		return hobbies;
	}
	public void setHobbies(ArrayList<String> hobbies) {
		this.hobbies = hobbies;
	}
	public Long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	
}
