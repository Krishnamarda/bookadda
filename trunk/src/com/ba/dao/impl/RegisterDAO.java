package com.ba.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ba.constants.Constants;
import com.ba.exception.BAException;
import com.ba.pojo.RegisterBean;
import com.ba.pojo.UserDetails;
import com.ba.utils.ConnectionFactory;

public class RegisterDAO extends ConnectionFactory {
	
	public UserDetails registerUser(RegisterBean rb) throws BAException {
		Connection con = null;
		PreparedStatement cStmt = null;
		int colCount=1;
		ResultSet rSet = null;
		UserDetails ud = UserDetails.getInstance();
		try {
			con = getConnection(Constants.DATASOURCE);
			cStmt = con.prepareCall(Constants.REGISTER_USER_PROC);
			cStmt.setString(colCount++, rb.getFname());
			cStmt.setString(colCount++, rb.getLname());
			cStmt.setString(colCount++, rb.getEmail());
			cStmt.setString(colCount++, rb.getPassword());
			rSet = cStmt.executeQuery();
			 while(rSet.next()){
				 
			 }

		} catch (SQLException sqle) {
			throw new BAException(sqle, "Exception caught in RegisterDAO.registerUser()");
		}
	    return ud;

	}

}
