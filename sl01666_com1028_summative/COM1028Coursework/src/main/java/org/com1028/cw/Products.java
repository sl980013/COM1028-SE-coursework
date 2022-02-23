/**
 * 
 */
package org.com1028.cw;

/**
 * @author sl01666
 *
 */
public class Products {
	private String productCode;
	private String productName;
	private String productLine;
	private String productScale;
	private String productVendor;
	private String productDescription;
	private int quantityInStock;
	private double buyPrice;
	private double msrp;

	/**
	 * @param productCode
	 * @param productName
	 * @param productLine
	 * @param productScale
	 * @param productVendor
	 * @param productDescription
	 * @param quantityInStock
	 * @param buyPrice
	 * @param mSRP
	 */
	public Products(String productCode, String productName, String productLine, String productScale,
			String productVendor, String productDescription, int quantityInStock, double buyPrice, double msrp) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productLine = productLine;
		this.productScale = productScale;
		this.productVendor = productVendor;
		this.productDescription = productDescription;
		this.quantityInStock = quantityInStock;
		this.buyPrice = buyPrice;
		this.msrp = msrp;
	}

	/**
	 * @return the productCode
	 */
	public String getProductCode() {
		return this.productCode;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return this.productName;
	}

	/**
	 * @return the productLine
	 */
	public String getProductLine() {
		return this.productLine;
	}

	/**
	 * @return the productScale
	 */
	public String getProductScale() {
		return this.productScale;
	}

	/**
	 * @return the productVendor
	 */
	public String getProductVendor() {
		return this.productVendor;
	}

	/**
	 * @return the productDescription
	 */
	public String getProductDescription() {
		return this.productDescription;
	}

	/**
	 * @return the quantityInStock
	 */
	public int getQuantityInStock() {
		return this.quantityInStock;
	}

	/**
	 * @return the buyPrice
	 */
	public double getBuyPrice() {
		return this.buyPrice;
	}

	/**
	 * @return the mSRP
	 */
	public double getMsrp() {
		return this.msrp;
	}

	@Override
	public String toString() {
		return "Code(" + this.getProductCode() + ") Name(" + this.getProductName() + ") Line(" + this.getProductLine()
				+ ") Scale(" + this.getProductScale() + ") Vendor(" + this.getProductVendor() + ") Description("
				+ this.getProductDescription() + ") Quantity In Stock(" + this.getQuantityInStock() + ") Buy Price("
				+ this.getBuyPrice() + ") MSRP(" + this.getMsrp() + ")\n";
	}

}
