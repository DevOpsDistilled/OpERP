package devopsdistilled.operp.client.items.panes.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.exceptions.NullFieldException;
import devopsdistilled.operp.client.items.exceptions.EntityNameExistsException;
import devopsdistilled.operp.client.items.models.CategoryModel;
import devopsdistilled.operp.client.items.panes.CreateCategoryPane;
import devopsdistilled.operp.client.items.panes.controllers.CreateCategoryPaneController;
import devopsdistilled.operp.client.items.panes.models.CreateCategoryPaneModel;
import devopsdistilled.operp.server.data.entity.items.Category;

public class CreateCategoryPaneControllerImpl implements
		CreateCategoryPaneController {

	@Inject
	private CreateCategoryPane view;

	@Inject
	private CreateCategoryPaneModel model;

	@Inject
	private CategoryModel categoryModel;

	@Override
	public void init() {
		view.init();
		model.registerObserver(view);
	}

	@Override
	public void validate(Category category) throws NullFieldException,
			EntityNameExistsException {
		if (category.getCategoryName().equalsIgnoreCase("")) {
			throw new NullFieldException("Category Name can't be empty");
		}

		if (categoryModel.getService().isCategoryNameExists(
				category.getCategoryName())) {
			throw new EntityNameExistsException("Category Name already exists");
		}
	}

	@Override
	public Category save(Category category) {
		return categoryModel.saveAndUpdateModel(category);
	}

}
