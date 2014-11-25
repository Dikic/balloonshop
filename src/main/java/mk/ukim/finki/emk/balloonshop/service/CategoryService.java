package mk.ukim.finki.emk.balloonshop.service;

import java.util.List;

import mk.ukim.finki.emk.balloonshop.model.Category;

public interface CategoryService {

	public void addCategory(Category c);

	public void deleteCategory(int id);

	public void updateCategory(Category c);

	public Category getCategory(int id);

	public List<Category> getAllCategories();
}
