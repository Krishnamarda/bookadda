package com.ba.constants;

public class Constants {

	// Global String Constants
	public static String SUCCESS = "success";
	public static String LOGIN_ERROR = "loginError";
	public static String LOGIN = "login";
	public static String REGISTER = "register";
	public static String TRUE = "true";
	public static String FALSE = "false";
	public static String USERNAME = "username";
	public static String DUPLICATE = "duplicate";
	public static String WISHLIST_ID = "wishlistID";
	public static String OWNLIST_ID = "ownlistID";
	public static String DUPLICATE_USER_REGISTRATION = "duplciateUser";

	// Context params
	public static String DATASOURCE = "java:comp/env/jdbc/BookAddaDS";
	public static String REGISTER_DAO = "java:comp/env/param/RegisterDAO";
	public static String LOGIN_DAO = "java:comp/env/param/LoginDAO";
	public static String HOME_DAO = "java:comp/env/param/HomeDAO";
	public static String OWNLIST_DAO = "java:comp/env/param/OwnListDAO";
	public static String WISHLIST_DAO = "java:comp/env/param/WishListDAO";

	// Stored Procedures, Functions and SQLs
	public static String REGISTER_USER = "insert into user_info values (?,?,?,?,?,?,?,?,?,?)";
	public static String DUPLICATE_USER_CHECK = "select 1 from user_info where UPPER(email) = UPPER(?)";
	public static String LOGIN_USER_1 = "select email, fname, lname, gender, inst_id from user_info where email=? and password=?";
	public static String LOGIN_USER_2 = "select email, fname, lname, gender, inst_id from user_info where email=?";
	public static String GET_HOME_DATA = "select * from ownlist where ownlist_id in" +
			"(select email from user_info where inst_id = " +
			"(select inst_id from user_info  where email=?) and email <> ?) ";
	public static String GET_WISH_LIST = "select * from wishlist where wishlist_id=?";
	public static String GET_OWN_LIST = "select * from ownlist where ownlist_id=?";
	public static String ADD_OWN_LIST = "insert into ownlist values (?,?,?,?,?)";
	public static String ADD_WISH_LIST = "insert into wishlist values (?,?,?,?,?)";

}
