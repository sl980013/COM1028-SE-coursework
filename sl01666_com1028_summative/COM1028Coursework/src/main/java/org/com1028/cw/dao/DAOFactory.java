/**
 * 
 */
package org.com1028.cw.dao;

/**
 * @author sl01666
 *
 */
public class DAOFactory {
	private static final ProductsDAO productsDAO = new ProductsDAO();

	public static ProductsDAO getProductsDAO() {
		return DAOFactory.productsDAO;
	}

	private static final PaymentsDAO paymentsDAO = new PaymentsDAO();

	public static PaymentsDAO getPaymentsDAO() {
		return DAOFactory.paymentsDAO;
	}

	private static final OrdersDAO ordersDAO = new OrdersDAO();

	public static OrdersDAO getOrdersDAO() {
		return DAOFactory.ordersDAO;
	}

}
