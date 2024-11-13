package dao;

import model.NonPerishableProduct;
import model.PerishableProduct;
import model.Product;
import utility.DBconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductDAOimpl implements ProductDAO {

    @Override
    public int addProduct(Product product) throws SQLException {
        String sql = "INSERT INTO product (product_name, product_price, product_type) VALUES (?, ?, ?)";
        
        try (Connection con = DBconnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, product.getProductName());
            ps.setDouble(2, product.getProductPrice());
            ps.setString(3, product.getProductType());
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int productId = rs.getInt(1);
                product.setProductId(productId);
                System.out.println("Product added successfully with ID: " + productId);
                return productId;
            }
        }
		return 0;
    }

    @Override
    public void removeProduct(int id) throws SQLException {
        String sql = "DELETE FROM product WHERE product_id = ?";
        
        try (Connection con = DBconnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            int result = ps.executeUpdate();
            if (result > 0) {
                System.out.println("Product removed successfully.");
            } else {
                System.out.println("No product found with the given ID.");
            }
        }
    }

    @Override
    public void addPerishableProduct(PerishableProduct perishableProduct) throws SQLException {
        
        String sql = "INSERT INTO perishable_product (product_id, best_before) VALUES (?, ?)";
        
        try (Connection con = DBconnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, perishableProduct.getProductId());
            ps.setInt(2, perishableProduct.getbestbefore());
            ps.executeUpdate();
            System.out.println("Perishable product added successfully with bestbefore (in months): " + perishableProduct.getbestbefore());
        }
    }

    @Override
    public void addNonPerishableProduct(NonPerishableProduct nonPerishableProduct) throws SQLException {
        
        String sql = "INSERT INTO nonperishable_product (product_id, shelf_life) VALUES (?, ?)";
        
        try (Connection con = DBconnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, nonPerishableProduct.getproductID());
            ps.setInt(2, nonPerishableProduct.getShelfLife());
            ps.executeUpdate();
            System.out.println("Non-perishable product added successfully with shelflife (in years): " + nonPerishableProduct.getShelfLife());
        }
    }

    @Override 
    public void removePershableProduct(int id) throws SQLException {
        String sqlDeletePerishable = "DELETE FROM perishable_product WHERE product_id = ?";
        String sqlDeleteProduct = "DELETE FROM product WHERE product_id = ?";

        try (Connection con = DBconnection.getConnection(); 
             PreparedStatement psPerishable = con.prepareStatement(sqlDeletePerishable);
             PreparedStatement psProduct = con.prepareStatement(sqlDeleteProduct)) {

            // Delete from perishable_product table
            psPerishable.setInt(1, id);
            int resultPerishable = psPerishable.executeUpdate();
            
            // Check if perishable product was removed, then delete from product table
            if (resultPerishable > 0) {
                psProduct.setInt(1, id);
                psProduct.executeUpdate();
                System.out.println("Perishable product and corresponding product entry removed successfully.");
            } else {
                System.out.println("No perishable product found with the given ID.");
            }
        }
    }

    @Override
    public void removeNonPershableProduct(int id) throws SQLException {
        String sqlDeleteNonPerishable = "DELETE FROM nonperishable_product WHERE product_id = ?";
        String sqlDeleteProduct = "DELETE FROM product WHERE product_id = ?";

        try (Connection con = DBconnection.getConnection(); 
             PreparedStatement psNonPerishable = con.prepareStatement(sqlDeleteNonPerishable);
             PreparedStatement psProduct = con.prepareStatement(sqlDeleteProduct)) {

            // Delete from nonperishable_product table
            psNonPerishable.setInt(1, id);
            int resultNonPerishable = psNonPerishable.executeUpdate();

            // Check if non-perishable product was removed, then delete from product table
            if (resultNonPerishable > 0) {
                psProduct.setInt(1, id);
                psProduct.executeUpdate();
                System.out.println("Non-perishable product and corresponding product entry removed successfully.");
            } else {
                System.out.println("No non-perishable product found with the given ID.");
            }
        }
    }

}
