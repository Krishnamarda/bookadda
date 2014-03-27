package com.ba.action;

import java.util.List;
import java.util.Map;

import com.ba.constants.Constants;
import com.ba.dao.impl.OwnListDAO;
import com.ba.exception.BAException;
import com.ba.factory.GenericFactory;
import com.ba.pojo.Ownlist;
import com.opensymphony.xwork2.ActionContext;

public class OwnListAction {

	List<Ownlist> ownList =null;
	public List<Ownlist> getOwnList() {
		return ownList;
	}
	public void setOwnList(List<Ownlist> ownList) {
		this.ownList = ownList;
	}
	public String execute() {
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		String unm = (String)session.get("username");
		if(unm==null){
			return null;
		}
		try {
			OwnListDAO dao = (OwnListDAO) GenericFactory
					.buildObject(Constants.OWNLIST_DAO);
			ownList=dao.getOwnList(session.get(Constants.OWNLIST_ID).toString());
		} catch (BAException e) {
		
		}
		return Constants.SUCCESS;
	}
}
