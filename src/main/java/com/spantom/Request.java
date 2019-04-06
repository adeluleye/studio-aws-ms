package com.spantom;


public class Request {
	
	private String httpMethod;
	private int id;
	private Studio studio;
	private String queryString;
	
	public String getQueryString() {
		return queryString;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	public String getHttpMethod() {
		return httpMethod;
	}
	
	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Studio getStudio() {
		return studio;
	}
	
	public void setStudio(Studio studio) {
		this.studio = studio;
	}

}
