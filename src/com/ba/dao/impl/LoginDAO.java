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
import com.ba.pojo.Wishlist;
import com.ba.utils.ConnectionFactory;

public class LoginDAO extends ConnectionFactory {

	private Connection con = null;
	private PreparedStatement pStmt = null;

	public UserDetails userLogin(String unm, String pwd, String loginType) throws BAException {

		int colCount = 1;
		ResultSet rSet = null;
		UserDetails ud = null;
		try {
			con = getConnection(Constants.DATASOURCE);
			if(Constants.LOGIN.equals(loginType)){
				pStmt = con.prepareStatement(Constants.LOGIN_USER_1);
				pStmt.setString(1, unm);
				pStmt.setString(2, pwd);
			}else{
				pStmt = con.prepareStatement(Constants.LOGIN_USER_2);
				pStmt.setString(1, unm);
			}
			
			rSet = pStmt.executeQuery();
			if (rSet.next()) {
				ud = new UserDetails();
				ud.setEmail(rSet.getString(colCount++));
				ud.setFname(rSet.getString(colCount++));
				ud.setLname(rSet.getString(colCount++));
				ud.setGender(rSet.getString(colCount++));
				ud.setWishlist_id(rSet.getString(colCount++));
				ud.setOwnlist_id(rSet.getString(colCount++));
				ud.setInst_id(rSet.getString(colCount++));
				ud.setWishList(getWishList(ud.getWishlist_id()));
				ud.setOwnList(getOwnList(ud.getOwnlist_id()));
			}

		} catch (SQLException sqle) {
			throw new BAException(sqle,
					"Exception caught in LoginDAO.userLogin()");
		}

		return ud;

	}

	private List<Wishlist> getWishList(String wishlist_id) throws BAException {
		List<Wishlist> wishlist = new ArrayList<Wishlist>();
		try {
			pStmt = con.prepareStatement(Constants.GET_WISH_LIST);
			pStmt.setString(1, wishlist_id);
			ResultSet rSet = null;
			rSet = pStmt.executeQuery();
			int colCount = 1;

			while (rSet.next()) {
				Wishlist wl = new Wishlist();
				wl.setWishlist_id(rSet.getString(colCount++));
				wl.setBook_name(rSet.getString(colCount++));
				wl.setAuthor(rSet.getString(colCount++));
				wl.setWishtype(rSet.getString(colCount++));
				wl.setQuantity(rSet.getInt(colCount++));
				wishlist.add(wl);
				colCount = 1;
			}
		} catch (SQLException sqle) {
			throw new BAException(sqle,
					"Exception caught in LoginDAO.getWishList()");
		}
		return wishlist;
	}

	private List<Ownlist> getOwnList(String ownlist_id) throws BAException {
		List<Ownlist> ownlist = new ArrayList<Ownlist>();
		try {
			pStmt = con.prepareStatement(Constants.GET_WISH_LIST);
			pStmt.setString(1, ownlist_id);
			ResultSet rSet = null;
			rSet = pStmt.executeQuery();
			int colCount = 1;

			while (rSet.next()) {
				Ownlist ol = new Ownlist();
				ol.setOwnlist_id(rSet.getString(colCount++));
				ol.setBook_name(rSet.getString(colCount++));
				ol.setAuthor(rSet.getString(colCount++));
				ol.setAvailtype(rSet.getString(colCount++));
				ol.setQuantity(rSet.getInt(colCount++));
				ownlist.add(ol);
				colCount = 1;
			}
		} catch (SQLException sqle) {
			throw new BAException(sqle,
					"Exception caught in LoginDAO.getOwnList()");
		}
		return ownlist;
	}
}
