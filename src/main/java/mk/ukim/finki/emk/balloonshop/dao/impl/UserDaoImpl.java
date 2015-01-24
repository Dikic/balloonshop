package mk.ukim.finki.emk.balloonshop.dao.impl;

import java.util.List;

import mk.ukim.finki.emk.balloonshop.dao.UserDao;
import mk.ukim.finki.emk.balloonshop.model.Product;
import mk.ukim.finki.emk.balloonshop.model.User;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
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
		getCurrentSession().save(u.getVerificationUser());
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
			user.setCity(u.getCity());
			user.setCountry(u.getCountry());
			user.setZip(u.getZip());
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

	@Override
	public List<User> search(String keyword) {
		return (List<User>) getCurrentSession()
				.createQuery(
						"from User where name LIKE :keyword or surname LIKE :keyword or email LIKE :keyword")
				.setParameter("keyword", "%" + keyword + "%").list();
	}

	@Override
	public List<User> getUsersInRange(int from, int max, String keyword) {
		Criteria query = getCurrentSession().createCriteria(User.class)
				.add(Restrictions.like("name", "%" + keyword + "%"))
				.add(Restrictions.like("surname", "%" + keyword + "%"))
				.add(Restrictions.like("email", "%" + keyword + "%"));

		return query.setFirstResult(from).setMaxResults(max).list();
	}

	@Override
	public int getUsersCount(String keyword) {
		String count = getCurrentSession()
				.createQuery(
						"select count(*) from User where name LIKE :keyword or surname LIKE :keyword or email LIKE :keyword")
				.setParameter("keyword", "%" + keyword + "%").uniqueResult()
				.toString();

		return Integer.parseInt(count);
	}

	@Override
	public User getUserByUUID(String uuid) {
		return (User) getCurrentSession().createCriteria(User.class,"user")
				.createAlias("user.verificationUser", "verification")
				.add(Restrictions.eq("verification.link", uuid))
				.uniqueResult();
	}
}
