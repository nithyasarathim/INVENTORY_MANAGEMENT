package model;

public class Inventory {
	
		private String inventory_name;

		public String getInventory_name() {
			return inventory_name;
		}

		public void setInventory_name(String inventory_name) {
			this.inventory_name = inventory_name;
		}

		public Inventory(String inventory_name) {
			super();
			this.inventory_name = inventory_name;
		}
}
