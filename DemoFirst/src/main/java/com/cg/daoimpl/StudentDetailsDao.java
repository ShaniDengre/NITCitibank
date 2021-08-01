package com.cg.daoimpl;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import com.cg.model.Student;

public class StudentDetailsDao {

	
	
	List<Student> studentList = new ArrayList<Student>();
	
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@//localhost:1521/XE";
	String username = "system";
	String query;
	

	Connection con = null;
	// create reference var. of Statement type
	Statement stmt = null;
	// create a result set for the executed query to parse through it
	ResultSet result = null;	

	public int addStuddent(Student student) {
		int i = 0;
		try {
			
			Class.forName(driver);

			Connection con = DriverManager.getConnection(url, username, "database");
			PreparedStatement pstmt;
			
			String sql = "insert into students values(?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, student.getRollNo());
			pstmt.setString(2, student.getName());
			pstmt.setInt(3, student.getAge());
			pstmt.setString(4, student.getPhoneNum());
			i = pstmt.executeUpdate();
			System.out.println("Record inserted successfully");
			
		}catch(Exception e) {
			System.out.println("driver not found " +e.getMessage());
		}
		return i;
	}
	
	
	/**
	public void deleteStudent(int rollNo) {
		try {
			Class.forName(driver);

			Connection con = DriverManager.getConnection(url, username, "");
			
			String sql = "delete from student where rollNo=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, rollNo);
			int i = pstmt.executeUpdate();
			if (i > 0) {
				System.out.println("student deleted successfully");
			} else {
				System.out.println("Id not present");
			}

		}catch(Exception e) {
			System.out.println("driver not found " +e.getMessage());
		}
		
	}**/
	
	
	
	public List<Student> displayStudentDetails(){
		try {
			Class.forName(driver);

			Connection con = DriverManager.getConnection(url, username, "database");
			
			String sql = "select * from students";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setRollNo(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setAge(rs.getInt(3));
				student.setPhoneNum(rs.getString(4));
				studentList.add(student);
				
			}
		}catch(Exception e) {
			System.out.println("driver not found " +e.getMessage());
		}
		return studentList;
			
		
		
	}

	
}
