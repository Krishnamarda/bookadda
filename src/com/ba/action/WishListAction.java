package com.ba.action;

import java.util.List;
import java.util.Map;

import com.ba.constants.Constants;
import com.ba.dao.impl.WishListDAO;
import com.ba.exception.BAException;
import com.ba.factory.GenericFactory;
import com.ba.pojo.Wishlist;
import com.opensymphony.xwork2.ActionContext;

public class WishListAction {
	List<Wishlist> wishList =null;
	public List<Wishlist> getWishList() {
		return wishList;
	}
	public void setWishList(List<Wishlist> wishList) {
		this.wishList = wishList;
	}
	public String execute() {
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		String unm = (String)session.get("username");
		if(unm==null){
			return null;
		}
		try {
			WishListDAO dao = (WishListDAO) GenericFactory
					.buildObject(Constants.WISHLIST_DAO);
			wishList=dao.getWishList(session.get(Constants.WISHLIST_ID).toString());
		} catch (BAException e) {
		
		}
		return Constants.SUCCESS;
	}

}
