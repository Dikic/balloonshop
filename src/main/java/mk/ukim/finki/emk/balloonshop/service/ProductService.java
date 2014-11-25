package mk.ukim.finki.emk.balloonshop.service;

import java.util.List;

import mk.ukim.finki.emk.balloonshop.model.Product;

public interface ProductService {

	public void addProduct(Product p);

	public void deleteProduct(int id);

	public void updateProduct(Product p);

	public Product getProduct(int id);

	public List<Product> getAllProducts();
}
