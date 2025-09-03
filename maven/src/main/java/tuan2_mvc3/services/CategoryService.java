package tuan2_mvc3.services;

import java.util.List;

import tuan2_mvc3.models.Category;


public interface CategoryService {
	void insert(Category category);

	void edit(Category category);

	void delete(int id);

	Category get(int id);

	Category get(String name);

	List<Category> getAll();

	List<Category> search(String keyword);
}