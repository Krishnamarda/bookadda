package com.ba.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ba.constants.Constants;
import com.ba.dao.BaseDAO;
import com.ba.exception.BAException;
import com.ba.pojo.RegisterBean;
import com.ba.pojo.UserDetails;
import com.ba.utils.ConnectionFactory;

public class RegisterDAO extends ConnectionFactory implements BaseDAO {

	public UserDetails registerUser(RegisterBean rb) throws BAException {
		Connection con = null;
		PreparedStatement cStmt = null;
		int colCount=1;
		ResultSet re = null;
		UserDetails ud = UserDetails.getInstance();
		try {
			con = getConnection(Constants.DATASOURCE);
			 cStmt = con.prepareStatement("select * from userinfo");
			    /*cStmt.setString(colCount++, rb.getFname());
			    cStmt.setString(colCount++, rb.getLname());
			    cStmt.setString(colCount++, rb.getEmail());
			    cStmt.setString(colCount++, rb.getPassword());*/
			    re = cStmt.executeQuery();
			    /*ud.setWishList(wishList);
			    ud.setOwnList(ownList);
			    ud.setItemsAvailable(itemsAvailable);
			    ud.setSearchHistory(searchHistory);
			     */
			 while(re.next()){
				 System.out.println(re.getString(1));
				 System.out.println(re.getString(2));
			 }

		} catch (SQLException sqle) {
			throw new BAException(sqle, "Exception caught in RegisterDAO.registerUser()");
		}
	    return ud;

	}

}
