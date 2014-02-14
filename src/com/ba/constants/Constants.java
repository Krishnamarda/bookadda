package com.ba.constants;

public class Constants {
	
	
	//Global String Constants
	public static String SUCCESS = "success";
	
	//Context params
	public static String DATASOURCE ="java:comp/env/jdbc/BookAddaDS";
	public static String REGISTER_DAO ="java:comp/env/param/RegisterDAO";
	public static String LOGIN_DAO ="java:comp/env/param/LoginDAO";
	
	//Stored Procedures, Functions and SQLs
	public static String REGISTER_USER_PROC = "call p_register_user(?,?,?,?)";
	public static String LOGIN_USER = "select email, first_name, last_name from userlogin where username=? and password=?";
	

	
}
