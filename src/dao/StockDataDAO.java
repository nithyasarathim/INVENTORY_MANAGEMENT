package dao;

import model.StockData;

public interface StockDataDAO {

	void addStock(StockData stockData);

	void removeStock(int id);

	void updateStock(int stockID, int stockCount);

	void viewStock(int stockID);

}
