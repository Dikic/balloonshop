package mk.ukim.finki.emk.balloonshop.dao.impl;

import java.util.List;

import mk.ukim.finki.emk.balloonshop.dao.CategoryDao;
import mk.ukim.finki.emk.balloonshop.model.Category;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addCategory(Category c) {
		getCurrentSession().save(c);
	}

	@Override
	public void deleteCategory(int id) {
		Category c = getCategory(id);
		if (c != null) {
			getCurrentSession().delete(c);
		}
	}

	@Override
	public void updateCategory(Category c) {
		Category category = getCategory((int) c.getId());
		if (category != null) {
			category.setDescription(c.getDescription());
			category.setName(c.getName());
			category.setProducts(c.getProducts());
			getCurrentSession().update(category);
		}
	}

	@Override
	public Category getCategory(int id) {
		return (Category) getCurrentSession().get(Category.class, id);
	}

	@Override
	public List<Category> getAllCategories() {
		return (List<Category>) getCurrentSession()
				.createQuery("from Category").list();
	}

}
