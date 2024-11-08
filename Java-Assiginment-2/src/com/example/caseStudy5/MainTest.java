package com.example.caseStudy5;

import java.util.Scanner;

public class MainTest {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Cart cart = new Cart();
		Order order = null;

		while (true) {
			System.out.println("\nWelcome to the Online Shoping System");
			System.out.println("1. Add Product to Cart");
			System.out.println("2. View Cart Total");
			System.out.println("3. Place Order");
			System.out.println("4. View Order Status");
			System.out.println("5. Update Order Status");
			System.out.println("6. Exit");
			System.out.print("Choose an option: ");

			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				// Add Product to Cart
				System.out.print("Enter Product ID: ");
				int productId = scanner.nextInt();
				scanner.nextLine(); // Consume newline
				System.out.print("Enter Product Name: ");
				String productName = scanner.nextLine();
				System.out.print("Enter Product Description: ");
				String productDescription = scanner.nextLine();
				System.out.print("Enter Product Price: ");
				double productPrice = scanner.nextDouble();
				System.out.print("Enter Product Quantity: ");
				int productQuantity = scanner.nextInt();

				Product product = new Product(productId, productName, productDescription, productPrice,
						productQuantity);
				cart.addProducts(product);
				System.out.println("Product added to cart successfully!");
				break;
			case 2:
				System.out.println("Total Price: $ : " + cart.getTotalPrice());
				break;
			case 3:
				if (order == null) {
					order = new Order(cart);
					System.out.println("Order placed successfully! Order ID: " + order.getOrderId());
				} else {
					System.out.println("Order has already been placed.");
				}
				break;
			case 4:
				if (order != null) {
					System.out.println("Order Status: " + order.getOrderStatus());
				} else {
					System.out.println("No order placed yet.");
				}
				break;
			case 5:
				if (order != null) {
					System.out.print("Enter new order status: ");
					scanner.nextLine();
					String newStatus = scanner.nextLine();
					order.setOrderStatus(newStatus);
					System.out.println("Order status updated to: " + order.getOrderStatus());
				} else {
					System.out.println("No order placed yet.");
				}
				break;
			case 6:
				// Exit
				System.out.println("Exiting the application. Thank you!");
				scanner.close();
				return;

			default:
				System.out.println("Invalid option. Please try again.");
			}
		}
	}

}
