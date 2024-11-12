package model;

public class StockAlert {
        
	    private int productId;       
	    private int inventoryId;     
	    private String alertType;    
	    private String status;
	    
		public StockAlert(int productId, int inventoryId, String alertType, String status) {
			super();
			this.productId = productId;
			this.inventoryId = inventoryId;
			this.alertType = alertType;
			this.status = status;
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

		public String getAlertType() {
			return alertType;
		}

		public void setAlertType(String alertType) {
			this.alertType = alertType;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}       
}
