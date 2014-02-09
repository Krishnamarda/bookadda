package com.ba.exception;

public class BAException extends Throwable{

	public BAException(Exception e, String message){
		System.out.println(message);
		System.out.println(e);
	}

}
