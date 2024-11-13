package dao;

import java.sql.SQLException;

import model.NonPerishableProduct;
import model.PerishableProduct;
import model.Product;

public interface ProductDAO {

	public int addProduct(Product product) throws SQLException;
	public void removeProduct(int id) throws SQLException;
	public void addPerishableProduct(PerishableProduct perishableProduct) throws SQLException;
	public void addNonPerishableProduct(NonPerishableProduct nonPerishableProduct) throws SQLException;
	public void removePershableProduct(int id) throws SQLException;
	public void removeNonPershableProduct(int id) throws SQLException;

}
