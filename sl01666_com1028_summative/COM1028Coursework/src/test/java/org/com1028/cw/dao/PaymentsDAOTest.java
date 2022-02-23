package org.com1028.cw.dao;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;

import org.junit.Test;

public class PaymentsDAOTest {
	@Test
	public void test() throws SQLException {
		DBConnection db = new DBConnection();
		StringBuffer buffer = new StringBuffer();
		DecimalFormat format = new DecimalFormat("0.00");
		String query = "SELECT paymentDate, SUM(amount), amount FROM payments group by paymentDate order by paymentDate";
		Statement s = db.con.createStatement();
		ResultSet rs = s.executeQuery(query);
		while (rs.next()) {
			buffer.append("Payment date: " + rs.getString("paymentDate") + " Total payment: "
					+ format.format(rs.getDouble("amount")) + "\n");
		}

		PaymentsDAO payment = new PaymentsDAO();

		assertEquals(buffer, payment.showPayments());
	}

}
