package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.sql.SQLException;

import model.NonPerishableProduct;
import model.PerishableProduct;
import model.Product;
import model.StockData;
import service.InventoryService;
import service.ProductService;
import service.StockAlertService;
import service.StockDataService;
import service.TransactionLogService;

public class InventoryController {
	
	private final InventoryService inventoryService;
	private final ProductService productService;
	private final StockAlertService stockAlertService;
	private final StockDataService stockDataService;
	private final TransactionLogService transactionLogService;
	private final BufferedReader br;
	
	public InventoryController() {
		super();
		this.inventoryService =new InventoryService();
		this.productService=new ProductService();
		this.stockAlertService= new StockAlertService();
		this.stockDataService= new StockDataService();
		this.transactionLogService= new TransactionLogService();
		this.br = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public void start() throws NumberFormatException, IOException, SQLException {
		boolean running=true;
		while(running)
		{
			displayMenu();
			int choice = Integer.parseInt(br.readLine());
			
			switch(choice) {
			case 0:
				running = false;
				break;
				
			case 1:
				addProduct();
				break;
				
			case 2:
				removeProduct();
				break;
				
			case 3:
				addInventory();
				break;
				
			case 4:
				removeInventory();
				break;
			
			case 5:
				addStock();
				break;
			
			case 6:
				removeStock();
				break;
			
			case 7:
				updateStock();
				break;
				
			case 8:
				viewInventory();
				break;
				
			case 9:
				viewStock();
				break;
			
			case 10:
				viewAlerts();
				break;
			
			case 11:
				viewTransactions();
				break;
				
			default:
				System.out.println("Invalid choice");
			}
			
		}
	}


	private void addProduct() throws NumberFormatException, IOException, SQLException {
		System.out.println("\n------------------------------------");
		System.out.println("CREATE PRODUCT");
		System.out.println("------------------------------------");

		System.out.println("Enter product name :");
		String name=br.readLine();

		System.out.println("Enter product price :");
		double price=Double.parseDouble(br.readLine());
		
		System.out.println("Enter the product type (P/NP) :");
		String productType = br.readLine();
		
		if("P".equalsIgnoreCase(productType)) {
			System.out.println("Enter the bestbefore (in months) :");
			int bestbefore=Integer.parseInt(br.readLine());
			
			int id= productService.addProduct(new Product(name,price,productType));
			productService.addPerishableProduct(new PerishableProduct(id ,name, price, productType, bestbefore));
			System.out.println("Adding a new Product - Success !");
		} 
		else if("NP".equalsIgnoreCase(productType)) {
			System.out.println("Enter the shelflife (in years):");
			int  warranty=Integer.parseInt(br.readLine());
			int id= productService.addProduct(new Product(name,price,productType));
			productService.addNonPerishableProduct(new NonPerishableProduct(id ,name, price, productType, warranty));
			System.out.println("Adding a new Product - Success !");
		}
		else {
			System.out.println("Invalid product type");
		}
		
	}
	
	 private void removeProduct() throws NumberFormatException, IOException, SQLException {
		 System.out.println("\n------------------------------------");
		 System.out.println("REMOVE PRODUCT");
		 System.out.println("------------------------------------");
			
		 System.out.println("Enter the product type (P/NP) :");
		 String productType = br.readLine();
		 System.out.println("Enter the product's id to remove:");
		 int id=Integer.parseInt(br.readLine());
		 
		 if("P".equalsIgnoreCase(productType)) {
			 productService.removePershableProduct(id);
		 }
		 else if("NP".equalsIgnoreCase(productType)) {
			 productService.removeNonPershableProduct(id);
		 }
		 
	}
	 
	private void addInventory() throws IOException, SQLException{
		System.out.println("\n------------------------------------");
		System.out.println("CREATE A NEW INVENTORY");
		System.out.println("------------------------------------");
		
		System.out.println("Enter the name of new Inventory :");
		String name =br.readLine();
		inventoryService.addInventory(name);
	}
	
	private void removeInventory() throws NumberFormatException, IOException, SQLException{
		System.out.println("\n------------------------------------");
		System.out.println("REMOVE AN INVENTORY");
		System.out.println("------------------------------------");
		
		System.out.println("Enter the inventory's id to remove :");
		int id=Integer.parseInt(br.readLine());
		inventoryService.removeInventory(id);
	}
	
	private void addStock() throws NumberFormatException, IOException{
		System.out.println("\n------------------------------------");
		System.out.println("ADD STOCK TO AN INVENTORY");
		System.out.println("------------------------------------");
		
		System.out.println("Enter product id :");
		int productID=Integer.parseInt(br.readLine());
		System.out.println("Enter inventory id :");
		int inventoryID=Integer.parseInt(br.readLine());
		System.out.println("Enter the initial stock level :");
		int stockCount=Integer.parseInt(br.readLine());
		System.out.println("Enter the threshold :");
		int threshold=Integer.parseInt(br.readLine());
		stockDataService.addStock(new StockData(productID, inventoryID, stockCount, threshold));
		
		
	}
	
	private void removeStock() throws NumberFormatException, IOException{
		System.out.println("\n------------------------------------");
		System.out.println("REMOVE STOCK TO AN INVENTORY");
		System.out.println("------------------------------------");
		
		System.out.println("Enter the stock's id to remove :");
		int stockId = Integer.parseInt(br.readLine());
		stockDataService.removeStock(stockId);
	}
	
	private void updateStock() throws NumberFormatException, IOException {
		System.out.println("\n------------------------------------");
		System.out.println("UPDATE STOCK IN AN INVENTORY");
		System.out.println("1. Add stocks ");
		System.out.println("2. Remove stocks ");
		System.out.println("------------------------------------");
		
		System.out.println("Enter the stock id :");
		int stockID = Integer.parseInt(br.readLine());
		System.out.println("Enter the no. of stocks :");
		int stockCount = Integer.parseInt(br.readLine());
		stockDataService.updateStock(stockID,stockCount);
		
		
		
	}

	
	private void viewInventory() throws NumberFormatException, IOException, SQLException{
		System.out.println("\n------------------------------------");
		System.out.println("VIEW AN INVENTORY");
		System.out.println("------------------------------------");
		
		System.out.println("Enter the inventory id :");
		int inventoryID = Integer.parseInt(br.readLine());
		inventoryService.viewInventory(inventoryID);
		
	}
	
	private void viewStock() throws NumberFormatException, IOException{
		System.out.println("\n------------------------------------");
		System.out.println("VIEW A STOCK STATUS");
		System.out.println("------------------------------------");
		
		System.out.println("Enter the stock id :");
		int stockID = Integer.parseInt(br.readLine());
		
		stockDataService.viewStock(stockID);
	}
	
	private void viewAlerts(){
		System.out.println("\n------------------------------------");
		System.out.println("VIEW STOCK ALERTS");
		System.out.println("------------------------------------");
		
		stockAlertService.viewAlerts();
	}
	
	private void viewTransactions() {
		System.out.println("\n------------------------------------");
		System.out.println("VIEW TRANSACTIONS");
		System.out.println("------------------------------------");
		
		transactionLogService.viewTransactions();
	}

	
	
	public void displayMenu() {
        System.out.println("\n--------------------------------------------");
        System.out.println("|---------- INVENTORY MANAGEMENT ----------|");
        System.out.println("--------------------------------------------");
        System.out.println("| 1. ADD PRODUCT                           |");
        System.out.println("| 2. REMOVE PRODUCT                        |");
        System.out.println("| 3. ADD INVENTORY                         |");
        System.out.println("| 4. REMOVE INVENTORY                      |");
        System.out.println("| 5. ADD STOCK                             |");
        System.out.println("| 6. REMOVE STOCK                          |");
        System.out.println("| 7. UPDATE STOCK                          |");
        System.out.println("| 8. VIEW INVENTORY                        |");
        System.out.println("| 9. VIEW STOCK AVAILABILITY               |");
        System.out.println("|10. VIEW STOCK ALERTS                     |");
        System.out.println("|11. VIEW TRANSACTIONS                     |");		
        System.out.println("| 0. EXIT                                  |");
        System.out.println("--------------------------------------------");
        System.out.println("|             ENTER A CHOICE               |");
        System.out.println("--------------------------------------------");
    }

	
}
