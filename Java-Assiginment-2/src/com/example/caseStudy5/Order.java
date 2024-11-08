package com.example.caseStudy5;

import java.time.LocalDate;
import java.util.UUID;

public class Order {
	private String orderId;
	private Cart cart;
	private String orderStatus;
	private LocalDate localDate;

	public Order(Cart cart) {
		this.orderId = UUID.randomUUID().toString();
		this.cart = cart;
		this.orderStatus = "Pending";
		this.localDate = LocalDate.now();
	}

	public String getOrderId() {
		return orderId;
	}

	public Cart getCart() {
		return cart;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public LocalDate getLocalDate() {
		return localDate;
	}

}
