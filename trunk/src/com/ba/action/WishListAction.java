package com.ba.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class WishListAction {

	public String execute() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		String unm = (String)session.get("username");
		if(unm==null){
			return null;
		}
		return "success";
	}

}
