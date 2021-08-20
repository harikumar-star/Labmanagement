package com.lab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;

import com.lab.model.Allregister;
//import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.lab.model.FacRegis;



public class UserDao {
	public static String msg;
	
	//Studednt
	public static Allregister getUser(String name)
	{
		System.out.println("get user details from db for "+name);
		Connection conn=ConnectionManager.getConnection();
		Statement stmt=null;
		Allregister stureg = null;
		try {
			stmt= conn.createStatement();
			String getUserQuery= "SELECT * FROM student where name='"+name+"'";
			ResultSet rs = stmt.executeQuery(getUserQuery);
			while(rs.next()){
				//Retrieve by column name
				int id = rs.getInt("id");
				String names = rs.getString("name");
				String email = rs.getString("email");
				String department = rs.getString("department");
				String semester = rs.getString("semester");
				String year = rs.getString("year");
				
				


				stureg = new Allregister(id,names,email, department, semester,year);
			}
			//STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}finally{
			//finally block used to close resources
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
			}// nothing we can do
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}//end try

		return stureg;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Faculty
	
	public static FacRegis getUserf(String name)
	{
		System.out.println("get user details from db for "+name);
		Connection conn=ConnectionManager.getConnection();
		Statement stmt=null;
		FacRegis fac = null;
		try {
			stmt= conn.createStatement();
			String getUserQuery= "SELECT * FROM faculty where name='"+name+"'";
			ResultSet rs = stmt.executeQuery(getUserQuery);
			while(rs.next()){
				//Retrieve by column name
				int ids = rs.getInt("id");
				String names = rs.getString("name");
				String email = rs.getString("email");
				String mobno = rs.getString("mobno");
			
				
				


				fac = new FacRegis(ids,names,email, mobno);
			}
			//STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}finally{
			//finally block used to close resources
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
			}// nothing we can do
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}//end try

		return fac;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static boolean createUser(Allregister stureg)
	{
		Connection conn=ConnectionManager.getConnection();
		PreparedStatement pst;
		boolean flag=false;
System.out.println("DB");
		try {
			
			

			pst = conn.prepareStatement("select * from student where id =? "); 
			pst.setInt(1,stureg.getId());  
			
			
			ResultSet rs = pst.executeQuery();
			if(rs.next())
			{
				msg = "Id already exist Enter New ID";
			}
			
			
			else
			{
pst= conn.prepareStatement(Queries.addUser);
				
				pst.setInt(1, stureg.getId());
				pst.setString(2, stureg.getName());
				pst.setString(3,stureg.getEmail());
				pst.setString(4,stureg.getDepartment());
				pst.setString(5,stureg.getSemester());
				pst.setString(6,stureg.getYear());
				int rowUpdated = pst.executeUpdate();
				if(rowUpdated > 0)
					flag=true;
				conn.close();
			}				
		}
		catch(Exception icve)
		{
			//msg = "User Name is already Exist";
			icve.printStackTrace();
		}
		

		return flag;

	}

	
	
	
	
	
	
	
	
	
	
	
	
	public static boolean createFac(FacRegis fac)
	{
		Connection conn=ConnectionManager.getConnection();
		PreparedStatement pst;
		boolean flag=false;
System.out.println("DB");
		try {
			
			

			pst = conn.prepareStatement("select * from faculty where id =? "); 
			pst.setInt(1,fac.getId());  
			
			
			ResultSet rs = pst.executeQuery();
			if(rs.next())
			{
				msg = "Id already exist Enter New ID";
			}
			
			
			else
			{
               pst= conn.prepareStatement(Queries.addfac);
				
				pst.setInt(1, fac.getId());
				pst.setString(2, fac.getName());
				pst.setString(3,fac.getEmail());
				pst.setString(4,fac.getMobno());
				
				int rowUpdated = pst.executeUpdate();
				if(rowUpdated > 0)
					flag=true;
				conn.close();
			}				
		}
		catch(Exception icve)
		{
			//msg = "User Name is already Exist";
			icve.printStackTrace();
		}
		

		return flag;

	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
