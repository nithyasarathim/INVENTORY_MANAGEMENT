package main;

import java.io.IOException;
import java.sql.SQLException;

import controller.InventoryController;

public class InventoryApp {

	public static void main(String[] args) throws NumberFormatException, IOException, SQLException {
		
		InventoryController ic =new InventoryController();
		ic.start();

	}

}
