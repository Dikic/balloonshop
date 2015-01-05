package mk.ukim.finki.emk.balloonshop.dao;

import java.util.List;

import mk.ukim.finki.emk.balloonshop.model.Cart;

public interface CartDao {

	public void addCart(Cart c);

	public void deleteCart(int id);

	public void updateCart(Cart c);

	public Cart getCart(int id);

	public List<Cart> getAllCarts();

	public Cart getByUserId(int id);
}
