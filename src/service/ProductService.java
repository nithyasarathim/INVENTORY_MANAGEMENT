package service;

import java.sql.SQLException;

import dao.ProductDAO;
import dao.ProductDAOimpl;
import model.NonPerishableProduct;
import model.PerishableProduct;
import model.Product;

public class ProductService {
	
	private final ProductDAO productDAO;

	public ProductService(){
		this.productDAO =new ProductDAOimpl();
	}

	public void addPerishableProduct(PerishableProduct perishableProduct) throws SQLException {
		productDAO.addPerishableProduct(perishableProduct);
		
	}

	public void addNonPerishableProduct(NonPerishableProduct nonPerishableProduct) throws SQLException {
		productDAO.addNonPerishableProduct(nonPerishableProduct);
		
	}

	public void removePershableProduct(int id) throws SQLException {
		productDAO.removePershableProduct(id);
		
	}

	public void removeNonPershableProduct(int id) throws SQLException {
		productDAO.removeNonPershableProduct(id);
		
	}

	public int addProduct(Product product) throws SQLException {
		return productDAO.addProduct(product);
	}
}
