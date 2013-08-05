package devopsdistilled.operp.client.items.panes.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.items.models.BrandModel;
import devopsdistilled.operp.client.items.panes.ListBrandPane;
import devopsdistilled.operp.client.items.panes.controllers.ListBrandPaneController;
import devopsdistilled.operp.client.items.panes.models.ListBrandPaneModel;

public class ListBrandPaneControllerImpl implements ListBrandPaneController {

	@Inject
	private ListBrandPane view;

	@Inject
	private ListBrandPaneModel model;

	@Inject
	private BrandModel brandModel;

	@Override
	public void init() {
		view.init();
		brandModel.registerObserver(view);
		model.registerObserver(view);
	}

}
