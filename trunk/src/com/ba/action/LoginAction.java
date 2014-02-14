package com.ba.action;

import java.util.Map;

import com.ba.constants.Constants;
import com.ba.dao.impl.LoginDAO;
import com.ba.exception.BAException;
import com.ba.factory.GenericFactory;
import com.opensymphony.xwork2.ActionContext;

public class LoginAction {

	private String username;
	private String password;

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public String execute() throws Exception {
		/*try {
			LoginDAO dao = (LoginDAO) GenericFactory
					.buildObject(Constants.LOGIN_DAO);
			dao.userLogin(username, password);
		} catch (BAException e) {
			System.out.println(e);
		}*/
		if(getUsername() == null){
			return "logout";
		}
		Map<String, Object> session = ActionContext.getContext().getSession();
		if(session.get("username")!=null){
			return Constants.SUCCESS;
		}else{
			session.put("username", getUsername());	
		}
		
		return Constants.SUCCESS;
		
	}

}
