package com.ba.action;

import java.util.Map;

import com.ba.constants.Constants;
import com.ba.dao.impl.AddWishDAO;
import com.ba.exception.BAException;
import com.ba.factory.GenericFactory;
import com.opensymphony.xwork2.ActionContext;

public class AddWishAction {
	private String bookName;
	private String author;
	private String wishType;
	private int quantity;
	private String result;
	
	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		String unm = (String)session.get("username");
		if(unm==null){
			return null;
		}
		try {
			AddWishDAO dao = (AddWishDAO) GenericFactory
					.buildObject(Constants.ADD_WISH_DAO);
			dao.addWishList(unm, bookName, author, wishType, quantity);
		} catch (BAException e) {
			System.out.println(e);
		}
		result=bookName+" successfully added to your Wishlist!!";
		return Constants.SUCCESS;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getWishType() {
		return wishType;
	}

	public void setWishType(String wishType) {
		this.wishType = wishType;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
