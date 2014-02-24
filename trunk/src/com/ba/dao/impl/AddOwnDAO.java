package com.ba.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.ba.constants.Constants;
import com.ba.exception.BAException;
import com.ba.utils.ConnectionFactory;

public class AddOwnDAO extends ConnectionFactory {
	private Connection con = null;
	private PreparedStatement pStmt = null;
	
	public void addOwnList(String unm, String bookName, String author, String availType,
			int quantity)throws BAException {
		try {
		int colCount=1;
			con = getConnection(Constants.DATASOURCE);
		pStmt = con.prepareStatement(Constants.ADD_OWN_LIST);
		pStmt.setString(colCount++, unm);
		pStmt.setString(colCount++, bookName);
		pStmt.setString(colCount++, author);
		pStmt.setString(colCount++, availType);
		pStmt.setInt(colCount++, quantity);
		
		pStmt.executeUpdate();
		}catch(Exception e){
			throw new BAException(e, "Exception Caught in AddOwnDAO.addOwnList()");
		}
	}

}
