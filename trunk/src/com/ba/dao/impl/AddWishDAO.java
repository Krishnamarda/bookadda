package com.ba.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.ba.constants.Constants;
import com.ba.exception.BAException;
import com.ba.utils.ConnectionFactory;

public class AddWishDAO extends ConnectionFactory {
	private Connection con = null;
	private PreparedStatement pStmt = null;
	
	public void addWishList(String unm, String bookName, String author, String wishtype,
			int quantity)throws BAException {
		try {
		int colCount=1;
		con = getConnection(Constants.DATASOURCE);
		pStmt = con.prepareStatement(Constants.ADD_WISH_LIST);
		pStmt.setString(colCount++, unm);
		pStmt.setString(colCount++, bookName);
		pStmt.setString(colCount++, author);
		pStmt.setString(colCount++, wishtype);
		pStmt.setInt(colCount++, quantity);
		
		pStmt.executeUpdate();
		}catch(Exception e){
			throw new BAException(e, "Exception Caught in AddWishDAO.addWishList()");
		}
	}

}
