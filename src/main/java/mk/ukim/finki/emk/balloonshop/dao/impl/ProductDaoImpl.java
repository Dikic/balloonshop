package mk.ukim.finki.emk.balloonshop.dao.impl;

import java.util.List;

import mk.ukim.finki.emk.balloonshop.dao.ProductDao;
import mk.ukim.finki.emk.balloonshop.model.Product;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addProduct(Product p) {
		getCurrentSession().save(p);
	}

	@Override
	public void deleteProduct(int id) {
		Product p = getProduct(id);
		if (p != null) {
			getCurrentSession().delete(p);
		}
	}

	@Override
	public void updateProduct(Product p) {
		Product product = getProduct(p.getId());
		if (product != null) {
			product.setCartProduct(p.getCartProduct());
			product.setCategories(p.getCategories());
			product.setDescription(p.getDescription());
			product.setLargeImage(p.getLargeImage()); // treba da se napravi za
														// upload
			product.setName(p.getName());
			product.setOnPromotion(p.isOnPromotion());
			product.setPrice(p.getPrice());
			product.setPurchaseDetail(p.getPurchaseDetail());
			product.setSmallImage(p.getSmallImage()); // isto za upload
			getCurrentSession().update(product);
		}
	}

	@Override
	public Product getProduct(int id) {
		return (Product) getCurrentSession().get(Product.class, id);
	}

	@Override
	public List<Product> getAllProducts() {
		return (List<Product>) getCurrentSession().createQuery("from Product")
				.list();
	}
}
