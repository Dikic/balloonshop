package mk.ukim.finki.emk.balloonshop.service;

import java.util.List;

import mk.ukim.finki.emk.balloonshop.model.Cart;
import mk.ukim.finki.emk.balloonshop.model.CartProduct;
import mk.ukim.finki.emk.balloonshop.model.User;

public interface CartProductService {

	public void addCartProduct(CartProduct cp);

	public void deleteCartProduct(int id, User user);

	public void updateCartProduct(CartProduct cp);

	public CartProduct getCartProduct(int id);

	public List<CartProduct> getAllCartProducts();

	public int getProductCount(int id);

	public List<CartProduct> getCartProductsFromCart(Cart cart);

	public void deleteCartProduct(int id);
}
