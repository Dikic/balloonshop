package mk.ukim.finki.emk.balloonshop.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import mk.ukim.finki.emk.balloonshop.dao.UserDao;
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

	@Override
	public void addUser(User u) {
		userDao.addUser(u);
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
		System.out.println(String.format("id: %s", dbUser.getId()));
		return dbUser != null;
	}

}
