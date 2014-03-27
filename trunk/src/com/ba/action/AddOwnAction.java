package com.ba.action;

import java.util.Map;

import com.ba.constants.Constants;
import com.ba.dao.impl.OwnListDAO;
import com.ba.exception.BAException;
import com.ba.factory.GenericFactory;
import com.opensymphony.xwork2.ActionContext;

public class AddOwnAction {
	private String bookName;
	private String author;
	private String availType;
	private int quantity;
	private String result;
	
	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		String unm = (String)session.get("username");
		if(unm==null){
			return null;
		}
		try {
			OwnListDAO dao = (OwnListDAO) GenericFactory
					.buildObject(Constants.OWNLIST_DAO);
			dao.addOwnList(unm, bookName, author, availType, quantity);
		} catch (BAException e) {
			System.out.println(e);
		}
		result=bookName+" successfully added to your Ownlist!!";
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

	public String getAvailType() {
		return availType;
	}

	public void setAvailType(String availType) {
		this.availType = availType;
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
