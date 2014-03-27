package com.ba.action;

import java.util.Map;

import com.ba.constants.Constants;
import com.opensymphony.xwork2.ActionContext;

public class LogoutAction {

	public String execute() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		if(session.get(Constants.USERNAME)!=null){
			session.remove(Constants.USERNAME);
			session.remove(Constants.WISHLIST_ID);
			session.remove(Constants.OWNLIST_ID);
		}
		return "success";
	}

}
