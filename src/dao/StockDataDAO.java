package dao;

import model.StockData;

public interface StockDataDAO {

	void addStock(StockData stockData);

	void removeStock(int id);

}
