package devopsdistilled.operp.server.data.service;

import java.io.Serializable;

import devopsdistilled.operp.server.data.entity.items.Category;

public interface CategoryService extends Serializable {
	public Category createCategory();

	public void deleteCategory();
}
