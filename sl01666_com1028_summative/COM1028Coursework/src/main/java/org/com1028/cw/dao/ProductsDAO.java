/**
 * 
 */
package org.com1028.cw.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.com1028.cw.Products;

/**
 * @author sl01666
 *
 */
public class ProductsDAO extends DBConnection {
	private ArrayList<Products> products = new ArrayList<Products>();

	public List<Products> getProducts() {
		try {
			// This is our prepared query, that selects everything from book
			// table
			String query = "select * from products ORDER BY productLine ASC";
			Statement s = con.createStatement();
			// Executes the query and stores the results.
			ResultSet rs = s.executeQuery(query);
			while (rs.next()) {
				/*
				 * Assign results from query to their own variable. We can reference columns by
				 * their name of index value e.g. 0
				 */
				String productCode = rs.getString("productCode");
				String productName = rs.getString("productName");
				String productLine = rs.getString("productLine");
				String productScale = rs.getString("productScale");
				String productVendor = rs.getString("productVendor");
				String productDescription = rs.getString("productDescription");
				int quantityInStock = rs.getInt("quantityInStock");
				double buyPrice = rs.getDouble("buyPrice");
				double msrp = rs.getDouble("MSRP");
				products.add(new Products(productCode, productName, productLine, productScale, productVendor,
						productDescription, quantityInStock, buyPrice, msrp));
			}
		} catch (SQLException e) {
			System.out.println("SQLException happened while retrieving records- abort programmme");
			throw new RuntimeException(e);
		}

		return products;
	}

	/**
	 * method showProducts shows products grouped in different product lines
	 * 
	 * @return buffer to show the list of products grouped according to the product
	 *         line
	 */
	public String showProducts() {
		// Creates new ArrayList of a class Products to group
		List<Products> classicCars = new ArrayList<Products>();
		List<Products> motorcycles = new ArrayList<Products>();
		List<Products> planes = new ArrayList<Products>();
		List<Products> ships = new ArrayList<Products>();
		List<Products> trains = new ArrayList<Products>();
		List<Products> trucksAndBuses = new ArrayList<Products>();
		List<Products> vintageCars = new ArrayList<Products>();

		// Loop through the whole database and separates and adds each products in each
		// product lines
		if (this.getProducts() != null) {
			for (Products pl : this.getProducts()) {
				if (pl.getProductLine().equals("Classic Cars")) {
					classicCars.add(pl);
				} else if (pl.getProductLine().equals("Motorcycles")) {
					motorcycles.add(pl);
				} else if (pl.getProductLine().equals("Planes")) {
					planes.add(pl);
				} else if (pl.getProductLine().equals("Ships")) {
					ships.add(pl);
				} else if (pl.getProductLine().equals("Trains")) {
					trains.add(pl);
				} else if (pl.getProductLine().equals("Trucks and Buses")) {
					trucksAndBuses.add(pl);
				} else if (pl.getProductLine().equals("Vintage Cars")) {
					vintageCars.add(pl);
				}
			}
		} else {
			throw new NullPointerException("Database for Products doesn't exist");
		}

		// Loop through each product line to call toString method from Product class and
		// print out each database
		StringBuffer buffer = new StringBuffer();

		buffer.append("Classic Cars \n");
		if (classicCars != null) {
			for (Products classic : classicCars) {
				buffer.append(classic + "\n");
			}
		}

		buffer.append("Motorcycles \n");
		if (motorcycles != null) {
			for (Products motor : motorcycles) {
				buffer.append(motor + "\n");
			}
		}

		buffer.append("Planes \n");
		if (planes != null) {
			for (Products plane : planes) {
				buffer.append(plane + "\n");
			}
		}

		buffer.append("Ships \n");
		if (ships != null) {
			for (Products ship : ships) {
				buffer.append(ship + "\n");
			}
		}

		buffer.append("Trains \n");
		if (trains != null) {
			for (Products train : trains) {
				buffer.append(train + "\n");
			}
		}

		buffer.append("Trucks and buses \n");
		if (trucksAndBuses != null) {
			for (Products tnb : trucksAndBuses) {
				buffer.append(tnb + "\n");
			}
		}

		buffer.append("Vintage cars \n");
		if (vintageCars != null) {
			for (Products vintage : vintageCars) {
				buffer.append(vintage + "\n");
			}
		}
		return buffer.toString();
	}
}
