package model;

public class Product {

		private int productId;
	    private String productName;   
	    private double productPrice; 
	    private String productType;
	    
		public Product(String productName, double productPrice, String productType) {
			super();
			this.productName = productName;
			this.productPrice = productPrice;
			this.productType = productType;
		}    
	    
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public double getProductPrice() {
			return productPrice;
		}
		public void setProductPrice(double productPrice) {
			this.productPrice = productPrice;
		}
		public String getProductType() {
			return productType;
		}
		public void setProductType(String productType) {
			this.productType = productType;
		}

		public void setProductId(int productId) {
			// TODO Auto-generated method stub
			
		}
}
