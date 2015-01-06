package mk.ukim.finki.emk.balloonshop.dao.impl;

import java.util.List;

import mk.ukim.finki.emk.balloonshop.dao.CategoryDao;
import mk.ukim.finki.emk.balloonshop.model.Category;
import mk.ukim.finki.emk.balloonshop.model.Product;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
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
		return (Category) getCurrentSession().createCriteria(Category.class)
				.add(Restrictions.idEq(id))
				.setFetchMode("products", FetchMode.JOIN).uniqueResult();
	}

	@Override
	public List<Category> getAllCategories() {
		return (List<Category>) getCurrentSession()
				.createQuery("from Category").list();
	}

	@Override
	public List<Product> getCategoryInRange(int category, int from, int max,
			String keyword) {
		Criteria criteria = getCurrentSession()
				.createCriteria(Product.class)
				.createAlias("categories", "category")
				.add(Restrictions.eq("category.id", category))
				.add(Restrictions.like("name", keyword, MatchMode.ANYWHERE))
				.setResultTransformer(
						CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		return criteria.setFirstResult(from).setMaxResults(max).list();
	}

}
