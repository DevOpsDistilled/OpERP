package devopsdistilled.operp.client.items.panes.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.exceptions.EntityNameExistsException;
import devopsdistilled.operp.client.exceptions.NullFieldException;
import devopsdistilled.operp.client.items.models.CategoryModel;
import devopsdistilled.operp.client.items.panes.EditCategoryPane;
import devopsdistilled.operp.client.items.panes.controllers.EditCategoryPaneController;
import devopsdistilled.operp.client.items.panes.models.EditCategoryPaneModel;
import devopsdistilled.operp.server.data.entity.items.Category;

public class EditCategoryPaneControllerImpl implements
		EditCategoryPaneController {

	@Inject
	private EditCategoryPane view;

	@Inject
	private EditCategoryPaneModel model;

	@Inject
	private CategoryModel categoryModel;

	@Override
	public void init(Category category) {
		view.init();
		model.setEntity(category);
		model.registerObserver(view);
	}

	@Override
	public void validate(Category category) throws EntityNameExistsException,
			NullFieldException {

		if (category.getCategoryName().equalsIgnoreCase(""))
			throw new NullFieldException("Category Name can't be empty");

		if (!categoryModel.getService().isCategoryNameValidForCategory(
				category.getCategoryId(), category.getCategoryName()))
			throw new EntityNameExistsException("Category Name already exists");

	}

	@Override
	public Category save(Category category) {
		return categoryModel.saveAndUpdateModel(category);
	}

}
