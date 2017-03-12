package org.cocome.productlist.data;

import java.io.Serializable;

import javax.enterprise.context.Dependent;

/**
 * This class represents a Product in the database
 * 
 * @author Stephan Engelmann (stephan-engelmann@gmx.de)
 */

@Dependent
public
class Product implements Serializable, IProduct {
	private static final long serialVersionUID = -2577328715744776645L;

	private long id;

	private long barcode;

	private double purchasePrice;

	private String name;
	
	public Product(long id, long barcode, String name, double purchasePrice) {
		super();
		this.id = id;
		this.barcode = barcode;
		this.purchasePrice = purchasePrice;
		this.name = name;
	}

	@Override
	public long getId() {
		return id;
	}

	@Override
	public long getBarcode() {
		return barcode;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getPurchasePrice() {
		return purchasePrice;
	}
}
