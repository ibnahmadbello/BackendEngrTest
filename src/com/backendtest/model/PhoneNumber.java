package com.backendtest.model;

import java.util.Date;
import java.util.regex.Pattern;

public class PhoneNumber {
	private String name;
	private String email;
	private Date dateCreated;

	public PhoneNumber(String name, String email, Date dateCreated) throws Exception {
		super();
		this.name = name;
		validateEmail(email);
		this.dateCreated = dateCreated;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws Exception {
		validateEmail(email);
	}

	private void validateEmail(String email) throws Exception {
		Pattern pattern = Pattern.compile("^(.+)@(.+)$");
		if(email != null)
		if(!pattern.matcher(email).matches())
			throw new Exception("Invalid email format");
		else
			this.email = email.toLowerCase();
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated() {
		this.dateCreated = new Date();
	}
}
