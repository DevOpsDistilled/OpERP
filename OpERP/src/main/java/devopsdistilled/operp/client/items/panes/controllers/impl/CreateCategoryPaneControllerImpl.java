package devopsdistilled.operp.client.items.panes.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.items.models.CategoryModel;
import devopsdistilled.operp.client.items.panes.CreateCategoryPane;
import devopsdistilled.operp.client.items.panes.controllers.CreateCategoryPaneController;
import devopsdistilled.operp.client.items.panes.models.CreateCategoryPaneModel;

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

}
