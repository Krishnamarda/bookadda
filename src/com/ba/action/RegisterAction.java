package com.ba.action;

import java.util.Map;

import com.ba.constants.Constants;
import com.ba.dao.impl.RegisterDAO;
import com.ba.exception.BAException;
import com.ba.factory.GenericFactory;
import com.ba.pojo.RegisterBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private RegisterBean rb =new RegisterBean();
	private String isUserDuplicate;
	public String execute() {
		try{
			RegisterDAO dao = (RegisterDAO)GenericFactory.buildObject(Constants.REGISTER_DAO);
			isUserDuplicate = dao.registerUser(rb);
			if(Constants.TRUE.equals(isUserDuplicate)){
				return Constants.DUPLICATE_USER_REGISTRATION;
			}
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put(Constants.USERNAME, rb.getEmail());	
		}catch(BAException e){
			System.out.println(e);
		}
		return Constants.SUCCESS;
	}

	public RegisterBean getRb() {
		return rb;
	}

	public void setRb(RegisterBean rb) {
		this.rb = rb;
	}

	public String getIsUserDuplicate() {
		return isUserDuplicate;
	}


	

}
