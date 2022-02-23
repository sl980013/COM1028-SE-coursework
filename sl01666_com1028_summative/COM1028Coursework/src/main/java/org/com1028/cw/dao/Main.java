/**
 * 
 */
package org.com1028.cw.dao;

import org.com1028.cw.dao.ProductsDAO;
import org.com1028.cw.dao.DAOFactory;

/**
 * @author sl01666
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 1st requirement
		ProductsDAO productsDAO = new ProductsDAO();
		try {
			productsDAO = DAOFactory.getProductsDAO();
			System.out.println(productsDAO.showProducts());
		} catch (Exception e) {
			// catch any exceptions and log them
			e.printStackTrace();
		} finally {
			// IMPORTANT : now close the connection to the database
			if (productsDAO != null) {
				productsDAO.closeConnection();
			}
		}

		// 2nd requirement
		PaymentsDAO paymentsDAO = new PaymentsDAO();
		try {
			paymentsDAO = DAOFactory.getPaymentsDAO();
			System.out.println(paymentsDAO.showPayments());
		} catch (Exception e) {
			// catch any exceptions and log them
			e.printStackTrace();
		} finally {
			// IMPORTANT : now close the connection to the database
			if (paymentsDAO != null) {
				paymentsDAO.closeConnection();
			}
		}

		// 3rd requirement
		OrdersDAO ordersDAO = new OrdersDAO();
		try {
			ordersDAO = DAOFactory.getOrdersDAO();
			System.out.println(ordersDAO.showCustomersOrder());
		} catch (Exception e) {
			// catch any exceptions and log them
			e.printStackTrace();
		} finally {
			// IMPORTANT : now close the connection to the database
			if (ordersDAO != null) {
				ordersDAO.closeConnection();
			}
		}

	}

}
