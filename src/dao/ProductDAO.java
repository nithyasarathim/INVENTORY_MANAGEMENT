package dao;

import model.NonPerishableProduct;
import model.PerishableProduct;
import model.Product;

public interface ProductDAO {

	public void addProduct(Product product);
	public void removeProduct(int id);
	public void addPerishableProduct(PerishableProduct perishableProduct);
	public void addNonPerishableProduct(NonPerishableProduct nonPerishableProduct);
	public void removePershableProduct(int id);
	public void removeNonPershableProduct(int id);

}
