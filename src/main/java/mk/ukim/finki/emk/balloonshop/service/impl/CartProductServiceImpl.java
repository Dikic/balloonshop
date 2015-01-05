package mk.ukim.finki.emk.balloonshop.service.impl;

import java.util.List;

import mk.ukim.finki.emk.balloonshop.dao.CartProductDao;
import mk.ukim.finki.emk.balloonshop.model.Cart;
import mk.ukim.finki.emk.balloonshop.model.CartProduct;
import mk.ukim.finki.emk.balloonshop.service.CartProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CartProductServiceImpl implements CartProductService {

	@Autowired
	CartProductDao cartProductDao;

	@Override
	public void addCartProduct(CartProduct cp) {
		cartProductDao.addCartProduct(cp);
	}

	@Override
	public void deleteCartProduct(int id) {
		cartProductDao.deleteCartProduct(id);
	}

	@Override
	public void updateCartProduct(CartProduct cp) {
		cartProductDao.updateCartProduct(cp);
	}

	@Override
	public CartProduct getCartProduct(int id) {
		return cartProductDao.getCartProduct(id);
	}

	@Override
	public List<CartProduct> getAllCartProducts() {
		return cartProductDao.getAllCartProducts();
	}
	@Override
	public List<CartProduct> getCartProductsFromCart(Cart cart) {
		return cartProductDao.getCartProductsByCartId(cart.getId());
	}
	@Override
	public int getProductCount(int id) {
		return cartProductDao.getProductCount(id);
	}

}
