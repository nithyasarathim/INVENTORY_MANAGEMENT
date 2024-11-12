package model;

public class NonPerishableProduct extends Product {

	private int shelfLife;

	public int getShelfLife() {
		return shelfLife;
	}

	public void setShelfLife(int shelfLife) {
		this.shelfLife = shelfLife;
	}

	public NonPerishableProduct(String productName, double productPrice, String productType, int shelfLife) {
		super(productName, productPrice, productType);
		this.shelfLife = shelfLife;
	}
	
}
