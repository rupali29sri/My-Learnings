package com.school.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.school.beans.Student;
import com.school.services.StudentService;

/**
 * @author nihal
 *
 */
@Controller
public class StudentController {

	@Autowired  
	StudentService studentService;  
	
	@RequestMapping("/addStudentProfilePage")
	public ModelAndView addStudentProfile()
	{
		ModelAndView modelAndView=new ModelAndView("addStudentProfile");	
		Student student = new Student();		
		modelAndView.addObject("student", student);
		return modelAndView;		
	}
	
	@RequestMapping("/viewAllStudentProfilePage")
	public ModelAndView viewStudentProfile()
	{
		ModelAndView modelAndView=new ModelAndView("viewAllStudentProfile");
		List<Student> listStudent=studentService.getStudentList();
		modelAndView.addObject("listStudent",listStudent);
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/editStudentProfilePage", method = RequestMethod.GET)
	public ModelAndView editStudentProfile(HttpServletRequest request) {
		int studentId = Integer.parseInt(request.getParameter("id"));
		Student student = studentService.viewStudentData(studentId);
		ModelAndView modelAndView = new ModelAndView("addStudentProfile");
		modelAndView.addObject("student", student);

		return modelAndView;
	}
	
	@RequestMapping(value="/deleteStudentProfilePage", method=RequestMethod.GET)
	public ModelAndView deleteStudentProfile()
	{
		ModelAndView modelAndView=new ModelAndView("viewAllStudentProfile");
		List<Student> listStudent=studentService.getStudentList();
		modelAndView.addObject("listStudent",listStudent);
		return modelAndView;
	}
	
	@RequestMapping( value="/submitStudentProfilePage",method=RequestMethod.POST)
	public ModelAndView submitStudentProfile(@ModelAttribute("studentObject") Student student1,BindingResult result)
	{
		if(result.hasErrors() || student1==null)
		{
			ModelAndView modelAndView=new ModelAndView("addStudentProfile");			
			return modelAndView;
		}
		else
		{
			//studentService.insertStudentData(student1);  
			
			studentService.updateStudentData(student1);  // both insert or update/
			 
			ModelAndView modelAndView=new ModelAndView("submitStudentProfile");
			modelAndView.addObject("welcomeMessage","Success!!");
			return modelAndView;
			
		}
	}
}
