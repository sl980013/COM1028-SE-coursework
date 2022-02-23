/**
 * 
 */
package org.com1028.cw;

/**
 * @author sl01666
 *
 */
public class Payments {
	private int customerNumber;
	private String checkNumber;
	private String paymentDate;
	private double amount;

	/**
	 * @param customerNumber
	 * @param checkNumber
	 * @param paymentDate
	 * @param amount
	 */
	public Payments(int customerNumber, String checkNumber, String paymentDate, double amount) {
		super();
		this.customerNumber = customerNumber;
		this.checkNumber = checkNumber;
		this.paymentDate = paymentDate;
		this.amount = amount;
	}

	/**
	 * @return the customerNumber
	 */
	public int getCustomerNumber() {
		return this.customerNumber;
	}

	/**
	 * @return the checkNumber
	 */
	public String getCheckNumber() {
		return this.checkNumber;
	}

	/**
	 * @return the paymentDate
	 */
	public String getPaymentDate() {
		return this.paymentDate;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return this.amount;
	}

}
