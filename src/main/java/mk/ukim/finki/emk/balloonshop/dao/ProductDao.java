package mk.ukim.finki.emk.balloonshop.dao;

import java.util.List;

import mk.ukim.finki.emk.balloonshop.model.Product;

public interface ProductDao {

	public void addProduct(Product p);

	public void deleteProduct(int id);

	public void updateProduct(Product p);

	public Product getProduct(int id);

	public List<Product> getAllProducts();
	
	public List<Product> search(String keyword);
	
	public List<Product> getProductsInRange(int from, int to, String keyword);
	
	public int getProductsCount(String keyword);

	public List<Product> getOnPromotion();
}
