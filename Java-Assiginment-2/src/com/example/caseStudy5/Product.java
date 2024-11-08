package com.example.caseStudy5;

public class Product {
	private int productId;
	private String name;
	private String description;
	private double price;
	private int stackQuality;

	public Product(int productId, String name, String description, double price, int stackQuality) {
		super();
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stackQuality = stackQuality;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStackQuality() {
		return stackQuality;
	}

	public void setStackQuality(int stackQuality) {
		this.stackQuality = stackQuality;
	}

}
