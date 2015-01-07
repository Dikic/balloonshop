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

<<<<<<< HEAD
	public void addOrUpdateProduct(Product p);
=======
	public List<Product> getOnPromotion();
>>>>>>> 262ec316a8cdc8b0f1218dfc7526f14c48efc073
}
