package com.ba.action;

import java.util.Map;

import com.ba.constants.Constants;
import com.opensymphony.xwork2.ActionContext;

public class HomeAction {

	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		String unm = (String)session.get("username");
		if(unm==null){
			return null;
		}
		/*try {
			HomeDAO dao = (HomeDAO) GenericFactory
					.buildObject(Constants.HOME_DAO);
			dao.getHomeDetails(username);
		} catch (BAException e) {
			System.out.println(e);
		}*/
		return Constants.SUCCESS;
	}
}
