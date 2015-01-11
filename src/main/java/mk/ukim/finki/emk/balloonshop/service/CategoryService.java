package mk.ukim.finki.emk.balloonshop.service;

import java.util.List;

import mk.ukim.finki.emk.balloonshop.model.Category;
import mk.ukim.finki.emk.balloonshop.model.User;

public interface CategoryService {

	public void addCategory(Category c);

	public void deleteCategory(int id);

	public void updateCategory(Category c);

	public Category getCategory(int id);

	public List<Category> getAllCategories();

	public void addOrUpdateCategory(Category c);
	
	public List<Category> search(String keyword);

	public List<Category> getCategoriesInRange(int page, String keyword);

	public int getCategoriesCount(String keyword);
}
