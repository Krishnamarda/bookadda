package com.ba.action;

import java.util.Map;

import com.ba.constants.Constants;
import com.ba.dao.impl.HomeDAO;
import com.ba.dao.impl.ProfileDAO;
import com.ba.exception.BAException;
import com.ba.factory.GenericFactory;
import com.ba.pojo.UserDetails;
import com.opensymphony.xwork2.ActionContext;


public class ProfileAction {

	private UserDetails userDetails;
	
	public String execute() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		String unm = (String)session.get("username");
		if(unm==null){
			return null;
		}
		
		try {
			ProfileDAO dao = (ProfileDAO) GenericFactory
					.buildObject(Constants.PROFILE_DAO);
			userDetails = dao.getProfileeDetails(unm);
		} catch (BAException e) {
		
		}
		
		return "success";
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	
}
