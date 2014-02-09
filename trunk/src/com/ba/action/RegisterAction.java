package com.ba.action;

import com.ba.constants.Constants;
import com.ba.dao.impl.RegisterDAO;
import com.ba.exception.BAException;
import com.ba.factory.GenericFactory;
import com.ba.pojo.RegisterBean;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private RegisterBean rb =new RegisterBean();
	
	public String execute() {
		try{
			
			RegisterDAO dao = (RegisterDAO)GenericFactory.buildObject(Constants.REGISTER_DAO);
			dao.registerUser(rb);
			
		}catch(BAException e){
			System.out.println(e);
		}
		return "success";
	}

	public RegisterBean getRb() {
		return rb;
	}

	public void setRb(RegisterBean rb) {
		this.rb = rb;
	}
	

}
