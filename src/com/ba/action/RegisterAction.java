package com.ba.action;

import java.util.Map;

import com.ba.constants.Constants;
import com.ba.pojo.RegisterBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private RegisterBean rb =new RegisterBean();
	

	
	public String execute() {
		/*try{
			RegisterDAO dao = (RegisterDAO)GenericFactory.buildObject(Constants.REGISTER_DAO);
			dao.registerUser(rb);
		}catch(BAException e){
			System.out.println(e);
		}*/
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("username", rb.getEmail());	
		return "success";
	}

	public RegisterBean getRb() {
		return rb;
	}

	public void setRb(RegisterBean rb) {
		this.rb = rb;
	}


	

}
