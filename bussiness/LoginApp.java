package com.lab.bussiness;

import com.lab.dao.UserDao;
import com.lab.model.Allregister;


public class LoginApp {

	
	
	public static String  msg ;
	public static Allregister authenticate(int id,String name)
	{
		Allregister loginUser = new Allregister(id,name);
		Allregister authUser =UserDao.getUser(name);
		
		if(authUser==null)
		{
			System.out.println("got null in auth user");
			return null;
		}
		//boolean userflag = (authUser.getUserName()).equals(loginUser.getUserName());
		boolean passflag = (authUser.getName()).equals(loginUser.getName());
		boolean passflag1 =(authUser.getId() == loginUser.getId());
		
		
		//System.out.println("LoginApp auth user is "+authUser);
		//System.out.println("LoginApp login user is "+loginUser+" \n  "+passflag);
		if( !passflag  || !passflag1 ) 
		{
			UserDao.msg = "User Name or Password is Incorrect!";
		}
		else
		{
			System.out.println("authenitcation is successfull");
			return authUser;
		}
		System.out.println("auth failed");
		return null;
	}
	
	
	
	
}
