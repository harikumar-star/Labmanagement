package com.lab.bussiness;

import com.lab.dao.UserDao;
import com.lab.model.FacRegis;

public class LoginApp2 {

	
	
	
	
	
	public static FacRegis authenticate(int id,String name)
	{
		
		FacRegis loginuser = new FacRegis(id,name);
		FacRegis authUser = UserDao.getUserf(name);
		
		if(authUser==null)
		{
			System.out.println("got null in auth user");
			return null;
		}
		//boolean userflag = (authUser.getUserName()).equals(loginUser.getUserName());
		boolean passflag = (authUser.getName()).equals(loginuser.getName());
		boolean passflag1 =(authUser.getId() == loginuser.getId());
		
		
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
