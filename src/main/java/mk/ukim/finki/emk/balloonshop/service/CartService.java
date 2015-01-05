package mk.ukim.finki.emk.balloonshop.service;

import java.util.List;

import mk.ukim.finki.emk.balloonshop.model.Cart;
import mk.ukim.finki.emk.balloonshop.model.User;

public interface CartService {

	public void addCart(Cart c);

	public void deleteCart(int id);

	public void updateCart(Cart c);

	public Cart getCart(int id);

	public List<Cart> getAllCarts();

	public boolean addToCart(int productId, User user);
}
