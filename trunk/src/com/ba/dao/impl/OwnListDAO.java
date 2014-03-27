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

public class OwnListDAO extends ConnectionFactory {
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
			throw new BAException(e, "Exception Caught in OwnListDAO.addOwnList()");
		}
	}
	
	public List<Ownlist> getOwnList(String oid)throws BAException{
		int colCount = 1;
		ResultSet rSet = null;
		List<Ownlist> ownlist = new ArrayList<Ownlist>();
		try {
			con = getConnection(Constants.DATASOURCE);
			pStmt = con.prepareStatement(Constants.GET_OWN_LIST);
			pStmt.setString(1, oid);
			rSet = pStmt.executeQuery();
			while (rSet.next()) {
				Ownlist ol = new Ownlist();
				ol.setOwnlist_id(rSet.getString(colCount++));
				ol.setBook_name(rSet.getString(colCount++));
				ol.setAuthor(rSet.getString(colCount++));
				ol.setAvailtype(rSet.getString(colCount++));
				ol.setQuantity(rSet.getInt(colCount++));
				ownlist.add(ol);
				colCount=1;
			}
		} catch (SQLException sqle) {
			throw new BAException(sqle,
					"Exception caught in OwnListDAO.getOwnList()");
		}finally{
			 sqlCleanUp(con, pStmt, rSet);
		}
		return ownlist;
	}

}
