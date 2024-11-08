package com.example.caseStudy3;

public class Barrower {

	private int borrowerId;
	private String name;
	private String email;

	public Barrower(int borrowerId, String name, String email) {
		super();
		this.borrowerId = borrowerId;
		this.name = name;
		this.email = email;
	}

	public int getBorrowerId() {
		return borrowerId;
	}

	public void setBorrowerId(int borrowerId) {
		this.borrowerId = borrowerId;
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

	public void setEmail(String email) {
		this.email = email;
	}

}
