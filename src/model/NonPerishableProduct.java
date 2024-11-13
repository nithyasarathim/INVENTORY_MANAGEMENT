package model;

public class NonPerishableProduct extends Product {

	private int shelfLife;
	private int productID;

	public int getShelfLife() {
		return shelfLife;
	}

	public void setShelfLife(int shelfLife) {
		this.shelfLife = shelfLife;
	}

	public NonPerishableProduct(int productID,String productName, double productPrice, String productType, int shelfLife) {
		super(productName, productPrice, productType);
		this.shelfLife = shelfLife;
		this.productID=productID;
	}

	public int getproductID() {
		return this.productID;
	}
	
}
