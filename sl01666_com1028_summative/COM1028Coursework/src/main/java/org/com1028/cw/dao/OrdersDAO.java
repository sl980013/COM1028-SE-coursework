/**
 * 
 */
package org.com1028.cw.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.com1028.cw.Customers;
import org.com1028.cw.Orderdetails;
import org.com1028.cw.Orders;

/**
 * @author sl01666
 *
 */
public class OrdersDAO extends DBConnection {
	private ArrayList<Customers> customers = new ArrayList<Customers>();

	public List<Customers> getCustomers() {
		try {
			// This is our prepared query, that selects everything from book
			// table
			String query = "select * from customers";
			Statement s = con.createStatement();
			// Executes the query and stores the results.
			ResultSet rs = s.executeQuery(query);
			while (rs.next()) {
				/*
				 * Assign results from query to their own variable. We can reference columns by
				 * their name of index value e.g. 0
				 */
				int customerNumber = rs.getInt("customerNumber");
				String customerName = rs.getString("customerName");
				String contactLastName = rs.getString("contactLastName");
				String contactFirstName = rs.getString("contactFirstName");
				String phone = rs.getString("phone");
				String addressLine1 = rs.getString("addressLine1");
				String addressLine2 = rs.getString("addressLine2");
				String city = rs.getString("city");
				String state = rs.getString("state");
				String postalCode = rs.getString("postalCode");
				String country = rs.getString("country");
				int salesRepEmployeeNumber = rs.getInt("salesRepEmployeeNumber");
				double creditLimit = rs.getDouble("creditLimit");
				customers.add(new Customers(customerNumber, customerName, contactLastName, contactFirstName, phone,
						addressLine1, addressLine2, city, state, postalCode, country, salesRepEmployeeNumber,
						creditLimit));
			}
		} catch (SQLException e) {
			System.out.println("SQLException happened while retrieving records- abort programmme");
			throw new RuntimeException(e);
		}

		return customers;
	}

	private ArrayList<Orders> orders = new ArrayList<Orders>();

	public List<Orders> getOrders() {
		try {
			// This is our prepared query, that selects everything from book
			// table
			String query = "select * from orders";
			Statement s = con.createStatement();
			// Executes the query and stores the results.
			ResultSet rs = s.executeQuery(query);
			while (rs.next()) {
				/*
				 * Assign results from query to their own variable. We can reference columns by
				 * their name of index value e.g. 0
				 */
				int orderNumber = rs.getInt("orderNumber");
				String orderDate = rs.getString("orderDate");
				String requiredDate = rs.getString("requiredDate");
				String shippedDate = rs.getString("shippedDate");
				String status = rs.getString("status");
				String comments = rs.getString("comments");
				int customerNumber = rs.getInt("customerNumber");
				orders.add(new Orders(orderNumber, orderDate, requiredDate, shippedDate, status, comments,
						customerNumber));
			}
		} catch (SQLException e) {
			System.out.println("SQLException happened while retrieving records- abort programmme");
			throw new RuntimeException(e);
		}

		return orders;
	}

	private ArrayList<Orderdetails> orderdetails = new ArrayList<Orderdetails>();

	public List<Orderdetails> getOrderdetails() {
		try {
			// This is our prepared query, that selects everything from book
			// table
			String query = "select * from orderdetails";
			Statement s = con.createStatement();
			// Executes the query and stores the results.
			ResultSet rs = s.executeQuery(query);
			while (rs.next()) {
				/*
				 * Assign results from query to their own variable. We can reference columns by
				 * their name of index value e.g. 0
				 */
				int orderNumber = rs.getInt("orderNumber");
				String productCode = rs.getString("productCode");
				int quantityOrdered = rs.getInt("quantityOrdered");
				double priceEach = rs.getDouble("priceEach");
				int orderLineNumber = rs.getInt("orderLineNumber");
				orderdetails
						.add(new Orderdetails(orderNumber, productCode, quantityOrdered, priceEach, orderLineNumber));
			}
		} catch (SQLException e) {
			System.out.println("SQLException happened while retrieving records- abort programmme");
			throw new RuntimeException(e);
		}

		return orderdetails;
	}

	public String showCustomersOrder() {

		StringBuffer buffer = new StringBuffer();

		Map<Integer, Double> orderDetail = new HashMap<Integer, Double>();
		double price = 0;
		for (Orderdetails o : this.getOrderdetails()) {
			if (orderDetail.containsKey(o.getOrderNumber())) {
				price += o.getPriceEach() * o.getQuantityOrdered();
				orderDetail.put(o.getOrderNumber(), price);
			} else {
				price = o.getPriceEach() * o.getQuantityOrdered();
				orderDetail.put(o.getOrderNumber(), price);
			}
		}

		List<Orders> orders = new ArrayList<Orders>();
		for (Orders o : this.getOrders()) {
			orders.add(o);
		}

		List<Customers> customers = new ArrayList<Customers>();
		for (Customers c : this.getCustomers()) {
			customers.add(c);
		}

		for (Customers c : customers) {
			for (Orders o : orders) {
				if (c.getCustomerNumber() == o.getCustomerNumber()) {
					for (Map.Entry<Integer, Double> e : orderDetail.entrySet()) {
						// checks if the total price of the order is greater than $25,000
						if (o.getOrderNumber() == e.getKey() && e.getValue() > 25000) {
							buffer.append(
									"Customer: " + c.getCustomerName() + " (Order No. " + o.getOrderNumber() + ") \n");
						}
					}
				}
			}
		}

		return buffer.toString();

	}

}
