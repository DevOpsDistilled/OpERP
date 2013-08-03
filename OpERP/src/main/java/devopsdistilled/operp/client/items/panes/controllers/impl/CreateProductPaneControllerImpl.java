package devopsdistilled.operp.client.items.panes.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.items.models.CategoryModel;
import devopsdistilled.operp.client.items.panes.CreateProductPane;
import devopsdistilled.operp.client.items.panes.controllers.CreateProductPaneController;
import devopsdistilled.operp.client.items.panes.models.CreateProductPaneModel;

public class CreateProductPaneControllerImpl implements
		CreateProductPaneController {

	@Inject
	private CreateProductPane view;

	@Inject
	private CreateProductPaneModel model;

	@Inject
	private CategoryModel categoryModel;

	@Override
	public void init() {
		view.init();
		model.registerObserver(view);
		categoryModel.registerObserver(view);
	}

}
