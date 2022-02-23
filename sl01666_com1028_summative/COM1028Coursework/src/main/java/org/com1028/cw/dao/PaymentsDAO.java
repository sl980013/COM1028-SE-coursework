/**
 * 
 */
package org.com1028.cw.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.com1028.cw.Payments;

/**
 * @author sl01666
 *
 */
public class PaymentsDAO extends DBConnection {
	private ArrayList<Payments> payments = new ArrayList<Payments>();

	public List<Payments> getPayments() {
		try {
			// This is our prepared query, that selects everything from book
			// table
			String query = "select * from payments";
			Statement s = con.createStatement();
			// Executes the query and stores the results.
			ResultSet rs = s.executeQuery(query);
			while (rs.next()) {
				/*
				 * Assign results from query to their own variable. We can reference columns by
				 * their name of index value e.g. 0
				 */
				int customerNumber = rs.getInt("customerNumber");
				String checkNumber = rs.getString("checkNumber");
				String paymentDate = rs.getString("paymentDate");
				double amount = rs.getDouble("amount");
				payments.add(new Payments(customerNumber, checkNumber, paymentDate, amount));
			}
		} catch (SQLException e) {
			System.out.println("SQLException happened while retrieving records- abort programmme");
			throw new RuntimeException(e);
		}

		return payments;
	}

	public String showPayments() {
		Map<String, Double> m1 = new HashMap<String, Double>();
		StringBuffer buffer = new StringBuffer();
		String date = null;
		double amount = 0;
		DecimalFormat format = new DecimalFormat("0.00");
		for (Payments p : this.getPayments()) {
			date = p.getPaymentDate();
			if (m1.containsKey(date)) {
				amount += p.getAmount();
				m1.put(date, amount);
			} else {
				amount = p.getAmount();
				m1.put(date, amount);
			}
		}

		// sort map
		Map<String, Double> sorted = new TreeMap<String, Double>(m1);

		Iterator<Map.Entry<String, Double>> itr = sorted.entrySet().iterator();
		while (itr.hasNext()) {
			Map.Entry<String, Double> entry = itr.next();
			buffer.append(
					"Payment date: " + entry.getKey() + " Total payment: " + format.format(entry.getValue()) + "\n");
		}

		return buffer.toString();
	}
}
