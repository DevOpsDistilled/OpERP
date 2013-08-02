package devopsdistilled.operp.client.items.models.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.abstracts.AbstractEntityModel;
import devopsdistilled.operp.client.items.models.CategoryModel;
import devopsdistilled.operp.client.items.models.observers.CategoryModelObserver;
import devopsdistilled.operp.server.data.entity.items.Category;
import devopsdistilled.operp.server.data.service.items.CategoryService;

public class CategoryModelImpl extends
		AbstractEntityModel<Category, CategoryService, CategoryModelObserver>
		implements CategoryModel {

	@Inject
	private CategoryService service;

	@Override
	public CategoryService getService() {
		return service;
	}

}
