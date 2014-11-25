package mk.ukim.finki.emk.balloonshop.service;

import java.util.List;

import mk.ukim.finki.emk.balloonshop.model.CartProduct;

public interface CartProductService {

	public void addCartProduct(CartProduct cp);

	public void deleteCartProduct(int id);

	public void updateCartProduct(CartProduct cp);

	public CartProduct getCartProduct(int id);

	public List<CartProduct> getAllCartProducts();
}
