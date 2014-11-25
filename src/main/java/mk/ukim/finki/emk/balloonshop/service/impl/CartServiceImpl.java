package mk.ukim.finki.emk.balloonshop.service.impl;

import java.util.List;

import mk.ukim.finki.emk.balloonshop.dao.CartDao;
import mk.ukim.finki.emk.balloonshop.model.Cart;
import mk.ukim.finki.emk.balloonshop.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CartServiceImpl implements CartService {

	@Autowired
	CartDao cartDao;

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

}
