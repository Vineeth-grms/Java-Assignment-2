package com.example.caseStudy5;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<Product> products;

	public Cart() {
		products = new ArrayList<>();
	}

	public void addProducts(Product product) {
		products.add(product);
	}

	public void removeProducts(Product product) {
		products.remove(product);
	}

	public double getTotalPrice() {
		double total = 0;
		for (Product product : products) {
			total += product.getPrice();
		}
		return total;
	}

	public List<Product> getProducts() {
		return products;
	}
}
