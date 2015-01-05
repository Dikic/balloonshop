package mk.ukim.finki.emk.balloonshop.dao.impl;

import java.util.List;

import mk.ukim.finki.emk.balloonshop.dao.CartProductDao;
import mk.ukim.finki.emk.balloonshop.model.CartProduct;

import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CartProductDaoImpl implements CartProductDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addCartProduct(CartProduct cp) {
		getCurrentSession().save(cp);
	}

	@Override
	public void deleteCartProduct(int id) {
		CartProduct cp = getCartProduct(id);
		if (cp != null) {
			getCurrentSession().delete(cp);
		}
	}

	@Override
	public void updateCartProduct(CartProduct cp) {
		CartProduct cartProduct = getCartProduct(cp.getId());
		if (cartProduct != null) {
			cartProduct.setCart(cp.getCart());
			cartProduct.setProduct(cp.getProduct());
			cartProduct.setQuantity(cp.getQuantity());
			getCurrentSession().update(cartProduct);
		}

	}

	@Override
	public CartProduct getCartProduct(int id) {
		return (CartProduct) getCurrentSession().get(CartProduct.class, id);
	}

	@Override
	public List<CartProduct> getAllCartProducts() {
		return (List<CartProduct>) getCurrentSession().createQuery(
				"from CartProduct").list();
	}

	@Override
	public int getProductCount(int id) {
		long count = (long) getCurrentSession()
				.createCriteria(CartProduct.class)
				.add(Restrictions.eq("cart.id", id))
				.setProjection(Projections.count("cart.id")).uniqueResult();
		return (int) count;
	}

	@Override
	public List<CartProduct> getCartProductsByCartId(int id) {
		return getCurrentSession().createCriteria(CartProduct.class)
				.add(Restrictions.eq("cart.id", id))
				.setFetchMode("product", FetchMode.JOIN).list();
	}
}
