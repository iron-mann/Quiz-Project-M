package com.java.quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connection1 {
	public static void connection()
	{
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("JDBC:mysql://localhost:3306/studentdb","root","Dream@54321");
		Statement smt=con.createStatement();
		String q= "create table studentinfo(id varchar(255) not null,Fname varchar (200) not null,Lname varchar(200) not null,password varchar(200) not null)";
		smt.executeUpdate(q);
		System.out.println("Student info table created");
		
		smt.close();
		con.close();
		
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
}
}