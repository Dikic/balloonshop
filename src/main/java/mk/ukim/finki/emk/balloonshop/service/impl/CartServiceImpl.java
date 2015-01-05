package mk.ukim.finki.emk.balloonshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import mk.ukim.finki.emk.balloonshop.dao.CartDao;
import mk.ukim.finki.emk.balloonshop.dao.CartProductDao;
import mk.ukim.finki.emk.balloonshop.dao.ProductDao;
import mk.ukim.finki.emk.balloonshop.model.Cart;
import mk.ukim.finki.emk.balloonshop.model.CartProduct;
import mk.ukim.finki.emk.balloonshop.model.Product;
import mk.ukim.finki.emk.balloonshop.model.User;
import mk.ukim.finki.emk.balloonshop.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CartServiceImpl implements CartService {

	@Autowired
	CartDao cartDao;

	@Autowired
	ProductDao productDao;

	@Autowired
	CartProductDao cartProductDao;

	@Override
	public void addCart(Cart c) {
		cartDao.addCart(c);
	}

	@Override
	public void deleteCart(int id) {
		cartDao.deleteCart(id);
	}

	@Override
	public void updateCart(Cart c) {
		cartDao.updateCart(c);
	}

	@Override
	public Cart getCart(int id) {
		return cartDao.getCart(id);
	}

	@Override
	public List<Cart> getAllCarts() {
		return cartDao.getAllCarts();
	}

	@Override
	public boolean addToCart(int productId, User user) {
		CartProduct cartProduct = new CartProduct();
		cartProduct.setCart(user.getCart());
		cartProduct.setProduct(productDao.getProduct(productId));
		cartProductDao.addCartProduct(cartProduct);
		return true;
	}

}
