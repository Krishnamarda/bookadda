package com.ba.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ba.constants.Constants;
import com.ba.exception.BAException;
import com.ba.pojo.Wishlist;
import com.ba.utils.ConnectionFactory;

public class WishListDAO extends ConnectionFactory {
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
			throw new BAException(e, "Exception Caught in WishListDAO.addWishList()");
		}
	}
	
	
	public List<Wishlist> getWishList(String wid)throws BAException{
		int colCount = 1;
		ResultSet rSet = null;
		List<Wishlist> wishlist = new ArrayList<Wishlist>();
		try {
			con = getConnection(Constants.DATASOURCE);
			pStmt = con.prepareStatement(Constants.GET_WISH_LIST);
			pStmt.setString(1, wid);
			rSet = pStmt.executeQuery();
			while (rSet.next()) {
				Wishlist wl = new Wishlist();
				wl.setWishlist_id(rSet.getString(colCount++));
				wl.setBook_name(rSet.getString(colCount++));
				wl.setAuthor(rSet.getString(colCount++));
				wl.setWishtype(rSet.getString(colCount++));
				wl.setQuantity(rSet.getInt(colCount++));
				wishlist.add(wl);
				colCount=1;
			}
		} catch (SQLException sqle) {
			throw new BAException(sqle,
					"Exception caught in WishListDAO.getWishList()");
		}finally{
			 sqlCleanUp(con, pStmt, rSet);
		}
		return wishlist;
	}

}
