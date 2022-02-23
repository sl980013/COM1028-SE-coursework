/**
 * 
 */
package org.com1028.cw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author sl01666
 *
 */
public class DBConnection {
	protected Connection con;
	private final String db = "jdbc:mysql://localhost:3306/classicmodels?serverTimezone=UTC";

	public DBConnection() {
		try {
			// Class.forName("com.mysql.jdbc.Driver");
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			con = DriverManager.getConnection(db, "root", "password");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void openConnection() {
		try {
			if (this.con == null || this.con.isClosed()) {
				this.con = DriverManager.getConnection(db, "root", "password");
			}

		} catch (SQLException e) {
			System.out.println("ERROR - Failed to create a connection to the database");
			throw new RuntimeException(e);
		}
	}

	public void closeConnection() {

		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

			if (this.con != null) {
				this.con.close();
			}
			System.out.println("Closed the connection to the database");
		} catch (Exception e) {
			System.out.print("ERROR - Failed to close the connection to the database");
			throw new RuntimeException(e);
		}
	}

}
