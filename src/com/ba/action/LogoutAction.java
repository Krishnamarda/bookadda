package com.ba.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class LogoutAction {

	public String execute() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		if(session.get("username")!=null){
			session.remove("username");
		}
		return "success";
	}

}
