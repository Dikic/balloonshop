package mk.ukim.finki.emk.balloonshop.dao;

import java.util.List;

import mk.ukim.finki.emk.balloonshop.model.CartProduct;

public interface CartProductDao {

	public void addCartProduct(CartProduct cp);

	public void deleteCartProduct(int id);

	public void updateCartProduct(CartProduct cp);

	public CartProduct getCartProduct(int id);

	public List<CartProduct> getAllCartProducts();

	public int getProductCount(int id);

	public List<CartProduct> getCartProductsByCartId(int id);

}
