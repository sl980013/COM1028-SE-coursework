package org.com1028.cw.dao;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class OrdersDAOTest {

	@Test
	public void test() throws SQLException {
		DBConnection db = new DBConnection();
		StringBuffer buffer = new StringBuffer();
		String query = "SELECT customerName FROM customers INNER JOIN orders USING (customerNumber) UNION SELECT orderNumber, SUM(quantityOrdered*priceEach) orderTotal FROM orderdetails INNER JOIN orders USING (orderNumber) GROUP BY orderNumber HAVING SUM(quantityOrdered*priceEach)>25000";
		Statement s = db.con.createStatement();
		ResultSet rs = s.executeQuery(query);
		while (rs.next()) {
			buffer.append(
					"Customer: " + rs.getString("customerName") + " (Order No. " + rs.getInt("orderNumber") + ") \n");
		}

		OrdersDAO order = new OrdersDAO();

		assertEquals(buffer, order.showCustomersOrder());
	}

}
