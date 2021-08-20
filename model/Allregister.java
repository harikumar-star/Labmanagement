package com.lab.model;

public class Allregister {

	int id;
	String name;
	String email;
	String department;
	String semester;
	String year;

	
	public Allregister(int id,String name,String email,String department,String semester,String year)
	{
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.department = department;
		this.semester = semester;
		this.year = year;
		
	}
	
	
	public Allregister(int id,String name)
	{
		this.name= name;
		this.id = id;
	}
	
	
	public void setId(int id)
	{
		this.id = id;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void setEmail (String email)
	{
		this.email = email;
	}
	public void setDepartment (String department)
	{
		this.department = department;
	}
	public void setSemester(String semester)
	{
		this.semester = semester;
	}
	public void setYear(String year)
	{
		this.year = year;
	}
	
	
	
	
	
	
	
	
	public int getId()
	{
		return id;
	}
	public String getName()
	{
		return name;
	}
	public String getEmail()
	{
		return email;
	}
	public String getDepartment()
	{
		return department;
	}
	public String getSemester()
	{
		return semester;
	}
	public String getYear()
	{
		return year;
	}
	
}

	
	
	
	
	
	
	
	

