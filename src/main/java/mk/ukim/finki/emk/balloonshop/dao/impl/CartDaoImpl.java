package mk.ukim.finki.emk.balloonshop.dao.impl;

import java.util.List;

import mk.ukim.finki.emk.balloonshop.dao.CartDao;
import mk.ukim.finki.emk.balloonshop.model.Cart;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CartDaoImpl implements CartDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addCart(Cart c) {
		getCurrentSession().save(c);
	}

	@Override
	public void deleteCart(int id) {
		Cart cart = getCart(id);
		if (cart != null) {
			getCurrentSession().delete(cart);
		}

	}

	@Override
	public void updateCart(Cart c) {
		Cart cart = getCart(c.getId());
		if (cart != null) {
			cart.setCartProduct(c.getCartProduct());
			cart.setUser(c.getUser());
			getCurrentSession().update(cart);
		}

	}

	@Override
	public Cart getCart(int id) {
		return (Cart) getCurrentSession().get(Cart.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cart> getAllCarts() {
		return (List<Cart>) getCurrentSession().createQuery("from Cart").list();
	}

}
