package com.cg.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc {
	
	
	


		public static void main(String[] args) {
			
			String url="jdbc:oracle:thin:@//localhost:1521/XE" ;
			String user="system";
			String pass="database";
			
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				System.out.println("driver is loaded");
				
				Connection con=DriverManager.getConnection(url, user, pass);
				System.out.println("connection is succesfully=="+con);
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select * from shani");
				while(rs.next())
				{
					System.out.println("name:="+rs.getString(1)+"---age="+rs.getInt(2));
				}
				
				
				
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			

		}

	}


