package com.ba.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ba.constants.Constants;
import com.ba.exception.BAException;
import com.ba.pojo.Ownlist;
import com.ba.pojo.UserDetails;
import com.ba.utils.ConnectionFactory;

public class ProfileDAO extends ConnectionFactory{
	private Connection con = null;
	private PreparedStatement pStmt = null;
	
	public UserDetails getProfileeDetails(String unm)throws BAException{
		int colCount = 1;
		ResultSet rSet = null;
		UserDetails userdetails = new UserDetails();
		try {
			con = getConnection(Constants.DATASOURCE);
			pStmt = con.prepareStatement(Constants.GET_PROFILE_DETAIL);
			pStmt.setString(1, unm);
			rSet = pStmt.executeQuery();
			if (rSet.next()) {
				//select email, fname, lname, gender, inst_id from user_info where email = ?
				userdetails.setEmail(rSet.getString("email"));
				userdetails.setFname(rSet.getString("fname"));
				userdetails.setLname(rSet.getString("lname"));
				userdetails.setGender(rSet.getString("gender"));
			}
		} catch (SQLException sqle) {
			throw new BAException(sqle,
					"Exception caught in UserDetails.userLogin()");
		}finally{
			 sqlCleanUp(con, pStmt, rSet);
		}
		return userdetails;
	}
	
}
