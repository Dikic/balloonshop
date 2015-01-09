package mk.ukim.finki.emk.balloonshop.dao;

import java.util.List;

import mk.ukim.finki.emk.balloonshop.model.Category;
import mk.ukim.finki.emk.balloonshop.model.Product;
import mk.ukim.finki.emk.balloonshop.model.User;

public interface CategoryDao {

	public void addCategory(Category c);

	public void deleteCategory(int id);

	public void updateCategory(Category c);

	public Category getCategory(int id);

	public List<Category> getAllCategories();

	public List<Product> getCategoryInRange(int category, int from,
			int productsPerPage, String keyword);
	
	public List<Category> search(String keyword);

	public List<Category> getCategoriesInRange(int from, int max, String keyword); //for paging on admin page

	public int getCategoriesCount(String keyword);
}
