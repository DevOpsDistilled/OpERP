package devopsdistilled.operp.client.items.panes.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.items.models.CategoryModel;
import devopsdistilled.operp.client.items.panes.ListCategoryPane;
import devopsdistilled.operp.client.items.panes.controllers.ListCategoryPaneController;
import devopsdistilled.operp.client.items.panes.models.ListCategoryPaneModel;

public class ListCategoryPaneControllerImpl implements
		ListCategoryPaneController {

	@Inject
	private ListCategoryPane view;

	@Inject
	private CategoryModel categoryModel;

	@Inject
	private ListCategoryPaneModel model;

	@Override
	public void init() {
		view.init();
		model.registerObserver(view);
		categoryModel.registerObserver(view);
	}

}
