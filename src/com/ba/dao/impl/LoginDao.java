package com.ba.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ba.constants.Constants;
import com.ba.dao.BaseDAO;
import com.ba.vo.LoginVO;

public class LoginDao implements BaseDAO {
private String validateLoginSQL = "select 1 from userlogin where username=? and password=?";


protected boolean isUserValid(LoginVO loginVO){
	Connection con = null;
	PreparedStatement cStmt = null;
	ResultSet rSet = null;
	try{
		//con = getConnection(Constants.DATASOURCE);
	}catch(Exception sqle){
		sqle.printStackTrace();
	}
	
	return true;
	
}




}
