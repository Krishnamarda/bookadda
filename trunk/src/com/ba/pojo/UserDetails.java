package com.ba.pojo;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.dispatcher.SessionMap;

public class UserDetails{
	
	private String email;
	private String fname;
	private String lname;
	private String gender;
	private String wishlist_id;
	private String ownlist_id;
	private String inst_id;
	
	
	private List<Wishlist> wishList = new ArrayList<Wishlist>();
	private List<Ownlist> ownList = new ArrayList<Ownlist>();
	private List<String> searchHistory = new ArrayList<String>();
	
	public List<Wishlist> getWishList() {
		return wishList;
	}
	public void setWishList(List<Wishlist> wishList) {
		this.wishList = wishList;
	}
	public List<Ownlist> getOwnList() {
		return ownList;
	}
	public void setOwnList(List<Ownlist> ownList) {
		this.ownList = ownList;
	}
	
	public List<String> getSearchHistory() {
		return searchHistory;
	}
	public void setSearchHistory(List<String> searchHistory) {
		this.searchHistory = searchHistory;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	/*private static UserDetails userDetails = null;
	private UserDetails(){
		
	}
	
	public static UserDetails getInstance(){
		if(userDetails==null){
			return new UserDetails();
		}else{
			return userDetails;
		}
	}*/
	public String getWishlist_id() {
		return wishlist_id;
	}
	public void setWishlist_id(String wishlist_id) {
		this.wishlist_id = wishlist_id;
	}
	public String getOwnlist_id() {
		return ownlist_id;
	}
	public void setOwnlist_id(String ownlist_id) {
		this.ownlist_id = ownlist_id;
	}
	public String getInst_id() {
		return inst_id;
	}
	public void setInst_id(String inst_id) {
		this.inst_id = inst_id;
	}
}
