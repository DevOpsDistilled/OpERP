package devopsdistilled.operp.server.data.service.items.impl;

import javax.inject.Inject;

import devopsdistilled.operp.server.data.repo.items.CategoryRepository;
import devopsdistilled.operp.server.data.service.items.CategoryService;

public class CategoryServiceImpl implements CategoryService {

	private static final long serialVersionUID = 7024824459392415034L;

	@Inject
	private CategoryRepository repo;

}
