package dao;

import java.sql.SQLException;

import model.StockData;

public interface StockDataDAO {

	void addStock(StockData stockData) throws SQLException;

	void removeStock(int id);

	void viewStock(int stockID);

	void updateStock(int productId, int initStock, char option);

}
