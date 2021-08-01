package com.cg.serviceimpl;

import java.util.List;

import com.cg.dao.StudentDao;
import com.cg.daoimpl.StudentDetailsDao;
import com.cg.model.Student;

public class StudentDetailsService {

	StudentDetailsDao studDao = new StudentDetailsDao();
	
	
	public String addStudent(Student student) {
		String message = null;
		int i = studDao.addStuddent(student);
		if(i == 1) {
			message = "Student details are added successfully";
		}
		else {
			message = "Student details are not added";
		}
		return message;
		
	}

	public List<Student> displayStudentDetails(){
		return studDao.displayStudentDetails();
	}
	
	
}
