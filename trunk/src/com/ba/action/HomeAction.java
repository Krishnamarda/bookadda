package com.ba.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.omg.CORBA.Request;

import com.ba.constants.Constants;
import com.ba.dao.impl.HomeDAO;
import com.ba.exception.BAException;
import com.ba.factory.GenericFactory;
import com.ba.pojo.Ownlist;
import com.opensymphony.xwork2.ActionContext;

public class HomeAction {
	List<Ownlist> homeData =null;
	public List<Ownlist> getHomeData() {
		return homeData;
	}
	public void setHomeData(List<Ownlist> homeData) {
		this.homeData = homeData;
	}
	public String execute() {
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		String unm = (String)session.get("username");
		if(unm==null){
			return null;
		}
		try {
			HomeDAO dao = (HomeDAO) GenericFactory
					.buildObject(Constants.HOME_DAO);
			homeData=dao.getHomeDetails(unm);
		} catch (BAException e) {
		
		}
		return Constants.SUCCESS;
	}
}
