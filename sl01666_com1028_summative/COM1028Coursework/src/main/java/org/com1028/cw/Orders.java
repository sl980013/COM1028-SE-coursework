/**
 * 
 */
package org.com1028.cw;

/**
 * @author sl01666
 *
 */
public class Orders {
	private int orderNumber;
	private String orderDate;
	private String requiredDate;
	private String shippedDate;
	private String status;
	private String comments;
	private int customerNumber;

	/**
	 * @param orderNumber
	 * @param orderDate
	 * @param requiredDate
	 * @param shippedDate
	 * @param status
	 * @param comments
	 * @param customerNumber
	 */
	public Orders(int orderNumber, String orderDate, String requiredDate, String shippedDate, String status,
			String comments, int customerNumber) {
		super();
		this.orderNumber = orderNumber;
		this.orderDate = orderDate;
		this.requiredDate = requiredDate;
		this.shippedDate = shippedDate;
		this.status = status;
		this.comments = comments;
		this.customerNumber = customerNumber;
	}

	/**
	 * @return the orderNumber
	 */
	public int getOrderNumber() {
		return this.orderNumber;
	}

	/**
	 * @return the orderDate
	 */
	public String getOrderDate() {
		return this.orderDate;
	}

	/**
	 * @return the requriedDate
	 */
	public String getRequiredDate() {
		return this.requiredDate;
	}

	/**
	 * @return the shippedDate
	 */
	public String getShippedDate() {
		return this.shippedDate;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return this.status;
	}

	/**
	 * @return the comments
	 */
	public String getComments() {
		return this.comments;
	}

	/**
	 * @return the customerNumber
	 */
	public int getCustomerNumber() {
		return this.customerNumber;
	}

}
