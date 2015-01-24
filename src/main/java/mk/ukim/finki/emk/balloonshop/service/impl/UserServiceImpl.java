package mk.ukim.finki.emk.balloonshop.service.impl;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import mk.ukim.finki.emk.balloonshop.dao.CartDao;
import mk.ukim.finki.emk.balloonshop.dao.UserDao;
import mk.ukim.finki.emk.balloonshop.model.Cart;
import mk.ukim.finki.emk.balloonshop.model.User;
import mk.ukim.finki.emk.balloonshop.model.VerificationUser;
import mk.ukim.finki.emk.balloonshop.service.UserService;

import org.hibernate.usertype.UserVersionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	private static final int USERS_PER_PAGE = 5;

	@Autowired
	UserDao userDao;

	@Autowired
	CartDao cartDao;

	@Override
	public void addUser(User u) {
		VerificationUser verificationUser = new VerificationUser();
		verificationUser.setUser(u);
		verificationUser.setLink(UUID.randomUUID().toString());
		u.setVerificationUser(verificationUser);
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

	@Override
	public List<User> search(String keyword) {
		return userDao.search(keyword);
	}

	@Override
	public List<User> getUsersInRange(int page, String keyword) {
		int from = (page - 1) * USERS_PER_PAGE;
		return userDao.getUsersInRange(from, USERS_PER_PAGE, keyword);
	}

	@Override
	public int getUsersCount(String keyword) {
		return (int) Math.ceil((userDao.getUsersCount(keyword) * 1.0)
				/ USERS_PER_PAGE);
	}

	@Override
	public boolean verifyUser(String uuid) {
		User user = userDao.getUserByUUID(uuid);
		if (user != null) {
			user.setEnabled(true);
			userDao.updateUser(user);
			return true;
		}
		return false;
	}

}
