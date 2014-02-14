package com.ba.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;


public class ProfileAction {

	private String fname;
	private String lname;
	
	public String execute() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		String unm = (String)session.get("username");
		if(unm==null){
			return null;
		}
		return "success";
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
}
