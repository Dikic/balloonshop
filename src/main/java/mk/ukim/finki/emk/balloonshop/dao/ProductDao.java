package mk.ukim.finki.emk.balloonshop.dao;

import java.util.List;

import mk.ukim.finki.emk.balloonshop.model.Product;

public interface ProductDao {

	public void addProduct(Product p);

	public void deleteProduct(int id);

	public void updateProduct(Product p);

	public Product getProduct(int id);

	public List<Product> getAllProducts();
}
