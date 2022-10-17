package com.java.quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Login {
	
	public static void login()
	{
		System.out.println("Welcome to Quiz Competition");
		
		System.out.println("Are you already registered if Yes press 1 if No press 2, If Quiz is already completed press 3 ");
		System.out.println("To see result of All Student press 4");
		Scanner sc = new Scanner(System.in);
		
		int a= sc.nextInt();
		
		if (a==1)
		{
			alreadyUser();
			
		}
		if(a==2)
		{
			eUser();
			
		}
		if(a==3)
		{
			FinalResult.finalResult();
		}
		if(a==4)
		{
			AllResult.allResult();
		}
	}
public static void alreadyUser()
{
	System.out.println("PLease eneter your Id");
	Scanner sca=new Scanner(System.in);
	String id= sca.next();
	System.out.println();
	System.out.println("Please enter your password");
	String pas=sca.next();
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("JDBC:mysql://localhost:3306/studentdb","root","Dream@54321");
		Statement smt=con.createStatement();
	ResultSet set=	smt.executeQuery("select * from studentinfo ");
	boolean flag =true;
		 while(set.next())
		 {
			String id1 =set.getString(1);
			String pas1=set.getString(4);
			if(id.equals(id1)&& pas.equals(pas1))
			{
				System.out.println("Logged In Successfully");
				System.out.println("Test Started");
				Result.checkans();
				flag=false;
			}
			
		 }
		 if(flag)
			{
				System.out.println("Enter correct UserID & Password");
			}
		smt.close();
		con.close();
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
}
	

public static void eUser()
{
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("JDBC:mysql://localhost:3306/studentdb","root","Dream@54321");
		PreparedStatement psmt=con.prepareStatement("insert into studentinfo (id,Fname,Lname,password) values (?,?,?,?)");
		Scanner sce=new Scanner(System.in);
		System.out.println("PLease enter ID to be genarated");
		String id = sce.next();
		System.out.println("PLease enter First Name");
		String Fname = sce.next();
		System.out.println("PLease enter Last Name");
		String Lname = sce.next();
		System.out.println("PLease enter Password");
		String password = sce.next();
		
		psmt.setString(1, id);	
		psmt.setString(2, Fname);	
		psmt.setString(3, Lname);
		psmt.setString(4, password);	
		psmt.executeUpdate();
		
System.out.println("Registered Successfully");
System.out.println("Test Stared");
Result.checkans();

psmt.close();
con.close();
		
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
}
}
