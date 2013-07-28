package devopsdistilled.operp.server.data.service.items.impl;

import javax.inject.Inject;

import devopsdistilled.operp.server.data.entity.items.Category;
import devopsdistilled.operp.server.data.repo.items.CategoryRepository;
import devopsdistilled.operp.server.data.service.impl.AbstractEntityService;
import devopsdistilled.operp.server.data.service.items.CategoryService;

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

}
