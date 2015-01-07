package mk.ukim.finki.emk.balloonshop.service.impl;

import java.util.List;

import mk.ukim.finki.emk.balloonshop.dao.CategoryDao;
import mk.ukim.finki.emk.balloonshop.dao.ProductDao;
import mk.ukim.finki.emk.balloonshop.model.Product;
import mk.ukim.finki.emk.balloonshop.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	private static final int PRODUCTS_PER_PAGE = 8;

	@Autowired
	ProductDao productDao;

	@Autowired
	CategoryDao categoryDao;

	@Override
	public void addProduct(Product p) {
		productDao.addProduct(p);
	}

	@Override
	public void deleteProduct(int id) {
		productDao.deleteProduct(id);
	}

	@Override
	public void updateProduct(Product p) {
		productDao.updateProduct(p);
	}

	@Override
	public Product getProduct(int id) {
		return productDao.getProduct(id);
	}

	@Override
	public List<Product> getAllProducts() {
		return productDao.getAllProducts();
	}

	@Override
	public List<Product> search(String keyword) {
		return productDao.search(keyword);
	}

	@Override
	public List<Product> getProductsInRange(int category, int page,
			String keyword) {
		int from = (page - 1) * PRODUCTS_PER_PAGE;
		if (category != 0) {
			return categoryDao.getCategoryInRange(category, from,
					PRODUCTS_PER_PAGE, keyword);
		}
		return productDao.getProductsInRange(from, PRODUCTS_PER_PAGE, keyword);
	}

	@Override
	public int getProductPageCount(String keyword, int category) {
		int total;
		if (category != 0) {
			total = categoryDao.getCategory(category).getProducts().size();
		} else {
			total = productDao.getProductsCount(keyword);
		}
		return (int) Math.ceil((total * 1.0) / PRODUCTS_PER_PAGE);
	}

	@Override
	public void addOrUpdateProduct(Product p) {
		Product product = getProduct(p.getId());
		if (product == null) {
			addProduct(p);
			return;
		}
		updateProduct(p);
	}

}
