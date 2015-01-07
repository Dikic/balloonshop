package mk.ukim.finki.emk.balloonshop.service;

import java.util.List;

import mk.ukim.finki.emk.balloonshop.model.Product;

public interface ProductService {

	public void addProduct(Product p);

	public void deleteProduct(int id);

	public void updateProduct(Product p);

	public Product getProduct(int id);

	public List<Product> getAllProducts();

	public List<Product> search(String keyword);

	public List<Product> getProductsInRange(int category, int page, String keyword);

	public int getProductPageCount(String keyword, int category);

	public void addOrUpdateProduct(Product p);
}
