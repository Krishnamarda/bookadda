package com.ba.action;

import java.util.Map;

import com.ba.constants.Constants;
import com.ba.dao.impl.LoginDAO;
import com.ba.exception.BAException;
import com.ba.factory.GenericFactory;
import com.ba.pojo.UserDetails;
import com.opensymphony.xwork2.ActionContext;

public class LoginAction {

	private String username;
	private String password;
	private UserDetails ud;
	private String loginError = Constants.TRUE;
	private String loginType = Constants.LOGIN;

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
		try {
			Map<String, Object> session = ActionContext.getContext()
					.getSession();
			if (session.get(Constants.USERNAME) != null) {
				loginType = Constants.REGISTER;
				username=(String)session.get(Constants.USERNAME);
			}
			LoginDAO dao = (LoginDAO) GenericFactory
					.buildObject(Constants.LOGIN_DAO);
			ud = dao.userLogin(username, password, loginType);
			if (ud != null) {
				if (session.get(Constants.USERNAME) == null) {
					session.put(Constants.USERNAME, getUsername());
					session.put(Constants.WISHLIST_ID, ud.getWishlist_id());
					session.put(Constants.OWNLIST_ID, ud.getOwnlist_id());
				}
				loginError = Constants.FALSE;
			} else {
				return Constants.LOGIN_ERROR;
			}
		} catch (BAException e) {
			System.out.println(e);
		}
		return Constants.SUCCESS;
	}

	public UserDetails getUd() {
		return ud;
	}
	public void setUd(UserDetails ud) {
		this.ud=ud;
	}
	public String getLoginError() {
		return loginError;
	}

	public void setLoginError(String loginError) {
		this.loginError = loginError;
	}

}
