package org.cocome.productlist.data;

public interface IProduct {

	/**
	 * Gets identifier value
	 * 
	 * @return The id.
	 */
	long getId();

	/**
	 * @return The barcode of the product
	 */
	long getBarcode();

	/**
	 * @return The name of the product
	 */
	String getName();

	/**
	 * @return The purchase price of this product
	 */
	double getPurchasePrice();

}