package model;

public class TransactionLog {
	
	    private int productId;        
	    private int inventoryId;       
	    private String transactionType;
	    private int quantity;
	    
		public TransactionLog(int productId, int inventoryId, String transactionType, int quantity) {
			super();
			this.productId = productId;
			this.inventoryId = inventoryId;
			this.transactionType = transactionType;
			this.quantity = quantity;
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
		public String getTransactionType() {
			return transactionType;
		}
		public void setTransactionType(String transactionType) {
			this.transactionType = transactionType;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}     
	   
	    
}
