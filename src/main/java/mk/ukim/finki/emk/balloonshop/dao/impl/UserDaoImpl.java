package mk.ukim.finki.emk.balloonshop.dao.impl;

import java.util.List;

import mk.ukim.finki.emk.balloonshop.dao.UserDao;
import mk.ukim.finki.emk.balloonshop.model.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addUser(User u) {
		getCurrentSession().save(u);
	}

	@Override
	public void deleteUser(int id) {
		User u = getUser(id);
		if (u != null) {
			getCurrentSession().delete(u);
		}
	}

	@Override
	public void updateUser(User u) {
		User user = getUser(u.getId());
		if (user != null) {
			user.setAddress(u.getAddress());
			user.setAuthority(u.getAuthority());
			user.setCart(u.getCart());
			user.setEmail(u.getEmail());
			user.setName(u.getName());
			user.setPassword(u.getPassword());
			user.setSurname(u.getSurname());
			getCurrentSession().update(user);
		}
	}

	@Override
	public User getUser(int id) {
		return (User) getCurrentSession().get(User.class, id);
	}

	@Override
	public List<User> getAllUsers() {
		return (List<User>) getCurrentSession().createQuery("from User").list();
	}

	@Override
	public User getUserByEmail(String email) {
		return (User) getCurrentSession().createCriteria(User.class)
				.add(Restrictions.eq("email", email)).uniqueResult();
	}

	@Override
	public User checkCredentials(String email, String password) {
		return (User) getCurrentSession().createCriteria(User.class)
				.add(Restrictions.eq("email", email))
				.add(Restrictions.eq("password", password)).uniqueResult();
	}
}
