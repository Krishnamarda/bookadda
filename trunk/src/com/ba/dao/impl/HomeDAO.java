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
import com.ba.utils.ConnectionFactory;

public class HomeDAO extends ConnectionFactory{
	private Connection con = null;
	private PreparedStatement pStmt = null;
	
	public List<Ownlist> getHomeDetails(String unm)throws BAException{
		int colCount = 1;
		ResultSet rSet = null;
		List<Ownlist> homeData = new ArrayList<Ownlist>();
		try {
			con = getConnection(Constants.DATASOURCE);
			pStmt = con.prepareStatement(Constants.GET_HOME_DATA);
			pStmt.setString(1, unm);
			pStmt.setString(2, unm);
			rSet = pStmt.executeQuery();
			while (rSet.next()) {
				Ownlist ol = new Ownlist();
				ol.setOwnlist_id(rSet.getString(colCount++));
				ol.setBook_name(rSet.getString(colCount++));
				ol.setAuthor(rSet.getString(colCount++));
				ol.setAvailtype(rSet.getString(colCount++));
				ol.setQuantity(rSet.getInt(colCount++));
				homeData.add(ol);
				colCount=1;
			}
		} catch (SQLException sqle) {
			throw new BAException(sqle,
					"Exception caught in UserDetails.userLogin()");
		}finally{
			 sqlCleanUp(con, pStmt, rSet);
		}
		return homeData;
	}
	
}
