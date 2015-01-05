package mk.ukim.finki.emk.balloonshop.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import mk.ukim.finki.emk.balloonshop.dao.CartDao;
import mk.ukim.finki.emk.balloonshop.dao.UserDao;
import mk.ukim.finki.emk.balloonshop.model.Cart;
import mk.ukim.finki.emk.balloonshop.model.User;
import mk.ukim.finki.emk.balloonshop.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Autowired
	CartDao cartDao;

	@Override
	public void addUser(User u) {
		userDao.addUser(u);
		Cart cart = new Cart();
		cart.setUser(u);
		cartDao.addCart(cart);

	}

	@Override
	public void deleteUser(int id) {
		userDao.deleteUser(id);
	}

	@Override
	public void updateUser(User u) {
		userDao.updateUser(u);
	}

	@Override
	public User getUser(int id) {
		return userDao.getUser(id);
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public boolean signInUser(User user, HttpSession session) {
		User dbUser = userDao.checkCredentials(user.getEmail(),
				user.getPassword());

		session.setAttribute("customer", dbUser);
		return dbUser != null;
	}

	@Override
	public void addOrUpdateUser(User u) {
		User user = getUser(u.getId());
		if (user == null) {
			addUser(u);
			return;
		}
		updateUser(u);
	}

}
