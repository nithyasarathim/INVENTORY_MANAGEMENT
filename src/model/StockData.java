package model;

public class StockData {
	       
	    private int productId;         
	    private int inventoryId; 
	    private int stockLevel;   
	    private int threshold;
	    
		public StockData( int productId, int inventoryId, int stockLevel, int threshold) {
			super();
			this.productId = productId;
			this.inventoryId = inventoryId;
			this.stockLevel = stockLevel;
			this.threshold = threshold;
		}

		public int getProductId() {
			return productId;
		}

		public void setProductId(int productId) {
			this.productId = productId;
		}

		public int getInventoryId() {
			return inventoryId;
		}

		public void setInventoryId(int inventoryId) {
			this.inventoryId = inventoryId;
		}

		public int getStockLevel() {
			return stockLevel;
		}

		public void setStockLevel(int stockLevel) {
			this.stockLevel = stockLevel;
		}

		public int getThreshold() {
			return threshold;
		}

		public void setThreshold(int threshold) {
			this.threshold = threshold;
		}
	    
		
}
