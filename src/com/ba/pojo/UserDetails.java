package com.ba.pojo;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.dispatcher.SessionMap;

public class UserDetails{

	private String fname;
	private String lname;
	private String email;
	
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
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
