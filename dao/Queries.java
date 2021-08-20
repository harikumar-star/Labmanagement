package com.lab.dao;

public class Queries {

	
	//public static String addUser="INSERT INTO `student`( `name`) VALUES (?)";
public static String addfac = "insert into faculty values (?,?,?,?)";
	public static String addUser="INSERT INTO `student`( `id`, `name`, `email`, `department`, `semester`, `year`) VALUES (?,?,?,?,?,?)";
}
