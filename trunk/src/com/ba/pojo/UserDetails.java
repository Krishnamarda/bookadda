package com.ba.pojo;

import java.util.ArrayList;
import java.util.List;

public class UserDetails {

	List wishList = new ArrayList();
	List ownList = new ArrayList();
	List itemsAvailable = new ArrayList();
	List searchHistory = new ArrayList();
	
	public List getWishList() {
		return wishList;
	}
	public void setWishList(List wishList) {
		this.wishList = wishList;
	}
	public List getOwnList() {
		return ownList;
	}
	public void setOwnList(List ownList) {
		this.ownList = ownList;
	}
	public List getItemsAvailable() {
		return itemsAvailable;
	}
	public void setItemsAvailable(List itemsAvailable) {
		this.itemsAvailable = itemsAvailable;
	}
	public List getSearchHistory() {
		return searchHistory;
	}
	public void setSearchHistory(List searchHistory) {
		this.searchHistory = searchHistory;
	}
	static UserDetails ud = null;
	private UserDetails(){
		
	}
	
	public static UserDetails getInstance(){
		if(ud==null){
			return new UserDetails();
		}else{
			return ud;
		}
	}
	
}
