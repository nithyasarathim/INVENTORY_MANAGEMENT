package service;

import java.sql.SQLException;

import dao.StockDataDAO;
import dao.StockDataDAOimpl;
import model.StockData;

public class StockDataService {
	
	private final StockDataDAO stockDataDAO;
	
	public StockDataService() {
		this.stockDataDAO=new StockDataDAOimpl();
	}

	public void addStock(StockData stockData) throws SQLException {
		stockDataDAO.addStock(stockData);	
	}
	
	public void removeStock(int id) {
		stockDataDAO.removeStock(id);
	}

	public void updateStock(int stockID, int stockCount,char option) {
		stockDataDAO.updateStock(stockID,stockCount,option);
	}
	
	public void viewStock(int stockID) {
		stockDataDAO.viewStock(stockID);
	}

}
