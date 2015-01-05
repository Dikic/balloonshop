package mk.ukim.finki.emk.balloonshop.service.impl;

import java.util.List;

import mk.ukim.finki.emk.balloonshop.dao.CategoryDao;
import mk.ukim.finki.emk.balloonshop.model.Category;
import mk.ukim.finki.emk.balloonshop.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDao categoryDao;

	@Override
	public void addCategory(Category c) {
		categoryDao.addCategory(c);
	}

	@Override
	public void deleteCategory(int id) {
		categoryDao.deleteCategory(id);
	}

	@Override
	public void updateCategory(Category c) {
		categoryDao.updateCategory(c);
	}

	@Override
	public Category getCategory(int id) {
		return categoryDao.getCategory(id);
	}

	@Override
	public List<Category> getAllCategories() {
		return categoryDao.getAllCategories();
	}

	@Override
	public void addOrUpdateCategory(Category c) {
		Category category = getCategory(c.getId());
		if (category == null) {
			addCategory(c);
			return;
		}
		updateCategory(c);
	}

}
