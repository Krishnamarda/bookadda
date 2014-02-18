package com.ba.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import com.ba.constants.Constants;
import com.ba.exception.BAException;
import com.ba.pojo.RegisterBean;
import com.ba.pojo.UserDetails;
import com.ba.utils.ConnectionFactory;

public class RegisterDAO extends ConnectionFactory {
	
	public String registerUser(RegisterBean rb) throws BAException {
		Connection con = null;
		PreparedStatement pStmt = null;
		int colCount=1;
		UserDetails ud = UserDetails.getInstance();
		String isUserDuplicate = Constants.FALSE;
		try {
			con = getConnection(Constants.DATASOURCE);
			pStmt = con.prepareStatement(Constants.DUPLICATE_USER_CHECK);
			pStmt.setString(1, rb.getEmail());
			if(pStmt.executeQuery().next()){
				isUserDuplicate=Constants.TRUE;
			}else{
				pStmt = con.prepareStatement(Constants.REGISTER_USER);
				pStmt.setString(colCount++, rb.getEmail());
				pStmt.setString(colCount++, rb.getFname());
				pStmt.setString(colCount++, rb.getLname());
				pStmt.setString(colCount++, rb.getPassword());
				pStmt.setString(colCount++, "");
				pStmt.setString(colCount++, "");
				pStmt.setString(colCount++, "");
				pStmt.setInt(colCount++,0);
				pStmt.setDate(colCount++,new java.sql.Date(new java.util.Date().getTime()));
				pStmt.setDate(colCount++,new java.sql.Date(new java.util.Date().getTime()));
				pStmt.executeUpdate();
			}
			return isUserDuplicate;
		} catch (SQLException sqle) {
			throw new BAException(sqle, "Exception caught in RegisterDAO.registerUser()");
		}

	}

}
