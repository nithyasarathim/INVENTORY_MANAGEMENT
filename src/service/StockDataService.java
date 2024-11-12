package service;

import dao.StockDataDAO;
import dao.StockDataDAOimpl;
import model.StockData;

public class StockDataService {
	
	private final StockDataDAO stockDataDAO;
	
	public StockDataService() {
		this.stockDataDAO=new StockDataDAOimpl();
	}

	public void addStock(StockData stockData) {
		stockDataDAO.addStock(stockData);	
	}
	
	public void removeStock(int id) {
		stockDataDAO.removeStock(id);
	}

}
