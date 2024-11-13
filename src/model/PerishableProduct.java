package model;

import java.util.Date;

public class PerishableProduct extends Product {

	private int bestbefore;
	private int productID;
	
	public PerishableProduct(int productID,String productName, double productPrice, String productType, int bestbefore) {
		super(productName, productPrice, productType);
		
		this.productID=productID;
		this.setBestbefore(bestbefore);
	}

	
	public int getProductId() {
		return productID;
	}


	public int getbestbefore() {
		return bestbefore;
	}


	public void setBestbefore(int bestbefore) {
		this.bestbefore = bestbefore;
	}

	
}
