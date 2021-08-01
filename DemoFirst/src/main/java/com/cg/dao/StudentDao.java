package com.cg.dao;

import java.util.List;

import com.cg.model.Student;

public interface StudentDao {
	
	
  public int addStuddent(Student student);
	
	public List<Student> displayStudentDetails();
	
	

}
