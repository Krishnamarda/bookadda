package com.ba.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ba.constants.Constants;
import com.ba.exception.BAException;
import com.ba.pojo.UserDetails;
import com.ba.utils.ConnectionFactory;

public class LoginDAO extends ConnectionFactory {
	

	public UserDetails userLogin(String unm, String pwd) throws BAException{
		Connection con = null;
		PreparedStatement cStmt = null;
		int colCount = 1;
		ResultSet rSet = null;
		UserDetails ud = UserDetails.getInstance();
		try {
			con = getConnection(Constants.DATASOURCE);
			cStmt = con.prepareStatement(Constants.LOGIN_USER);
			rSet = cStmt.executeQuery();
			rSet.next();
			ud.setEmail(rSet.getString(colCount++));
			ud.setFname(rSet.getString(colCount++));
			ud.setLname(rSet.getString(colCount++));
		} catch (Exception sqle) {
			throw new BAException(sqle, "Exception caught in UserDetails.userLogin()");
		}

		return ud;

	}

}
