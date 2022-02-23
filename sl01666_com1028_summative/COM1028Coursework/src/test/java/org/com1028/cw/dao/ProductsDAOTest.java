package org.com1028.cw.dao;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class ProductsDAOTest {

	@Test
	public void test() throws SQLException {
		DBConnection db = new DBConnection();
		StringBuffer buffer = new StringBuffer();
		String query = "select productLine,group_concat(productCode, productName, productLine, productScale, productVendor, productDescription, quantityInStock, buyPrice, MSRP) as productCode, productName, productLine, productScale, productVendor, productDescription, quantityInStock, buyPrice, MSRP from products group by productLine";
		Statement s = db.con.createStatement();
		ResultSet rs = s.executeQuery(query);
		while (rs.next()) {
			buffer.append("Code(" + rs.getString("productCode") + ") Name(" + rs.getString("productName") + ") Line("
					+ rs.getString("productLine") + ") Scale(" + rs.getString("productScale") + ") Vendor("
					+ rs.getString("productVendor") + ") Description(" + rs.getString("productDescription")
					+ ") Quantity In Stock(" + rs.getInt("quantityInStock") + ") Buy Price(" + rs.getDouble("buyPrice")
					+ ") MSRP(" + rs.getDouble("MSRP") + ")\n");
		}
		ProductsDAO product = new ProductsDAO();

		assertEquals(buffer, product.showProducts());
	}

}
