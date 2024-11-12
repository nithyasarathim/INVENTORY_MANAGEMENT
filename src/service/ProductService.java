package service;

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

	public void addPerishableProduct(PerishableProduct perishableProduct) {
		productDAO.addPerishableProduct(perishableProduct);
		
	}

	public void addNonPerishableProduct(NonPerishableProduct nonPerishableProduct) {
		productDAO.addNonPerishableProduct(nonPerishableProduct);
		
	}

	public void removePershableProduct(int id) {
		productDAO.removePershableProduct(id);
		
	}

	public void removeNonPershableProduct(int id) {
		productDAO.removeNonPershableProduct(id);
		
	}
}
