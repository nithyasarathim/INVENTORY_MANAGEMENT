package service;

import dao.StockAlertDAO;
import dao.StockAlertDAOimpl;

public class StockAlertService {

	private final StockAlertDAO stockAlertDAO;
	
	public StockAlertService() {
		this.stockAlertDAO = new StockAlertDAOimpl();
	}
	
	public void viewAlerts() {
		stockAlertDAO.viewAlerts();
		
	}

}
