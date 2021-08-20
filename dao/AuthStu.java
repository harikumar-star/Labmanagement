package com.lab.dao;

public class AuthStu {
	
	
	int id;
	String name;
	
	public AuthStu(int id,String name)
	{
		this.id = id;
		this.name = name;
	}
	
	public void SetId(int id)
	{
		this.id = id;
	}
	
	public void SetName(String name)
	{
		this.name = name;
	}
	
	
	public int getId()
	{
		return id;
	}
	
	public String getName()
	{
		return name;
	}
	
	

}
