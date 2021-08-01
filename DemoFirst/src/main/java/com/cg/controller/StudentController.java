package com.cg.controller;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cg.model.Student;
import com.cg.serviceimpl.StudentDetailsService;




@Path("/student")
public class StudentController {

StudentDetailsService studentService = new StudentDetailsService();
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String addStudent(Student student) {
		
		return studentService.addStudent(student);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> displayStudentDetails(){
		
		return studentService.displayStudentDetails();
	}
	
	
}
