package com.egen.customexceptions;

public class MovieException extends RuntimeException{

	
	private static final long serialVersionUID = -9067042822872567406L;

	public MovieException()
	{
		
	}
	
	public MovieException(String message)
	{
		super(message);
	}
	
}
