package devopsdistilled.operp.server.data.service.items.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import devopsdistilled.operp.server.data.entity.items.Category;
import devopsdistilled.operp.server.data.repo.items.CategoryRepository;
import devopsdistilled.operp.server.data.service.impl.AbstractEntityService;
import devopsdistilled.operp.server.data.service.items.CategoryService;

@Service
public class CategoryServiceImpl extends
		AbstractEntityService<Category, Long, CategoryRepository> implements
		CategoryService {

	private static final long serialVersionUID = 7024824459392415034L;

	@Inject
	private CategoryRepository repo;

	@Override
	protected CategoryRepository getRepo() {
		return repo;
	}

	@Override
	public boolean isCategoryNameExists(String categoryName) {
		Category category = repo.findByCategoryName(categoryName);
		if (category != null)
			return true;

		return false;
	}

	@Override
	public boolean isCategoryNameValidForCategory(Long categoryId,
			String categoryName) {

		Category category = repo.findByCategoryName(categoryName);

		if (category == null)
			return true;

		if (category.getCategoryId().equals(categoryId))
			return true;

		return false;
	}

	@Override
	protected Category findByEntityName(String entityName) {
		return repo.findByCategoryName(entityName);
	}

}
