package model;

import java.util.Date;

public class PerishableProduct extends Product {

	private Date expirationDate;

	public PerishableProduct(String productName, double productPrice, String productType, Date expirationDate) {
		super(productName, productPrice, productType);
		this.setExpirationDate(expirationDate);
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	
}
