package devopsdistilled.operp.client.items.panes.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.items.panes.CreateBrandPane;
import devopsdistilled.operp.client.items.panes.controllers.CreateBrandPaneController;
import devopsdistilled.operp.client.items.panes.models.CreateBrandPaneModel;

public class CreateBrandPaneControllerImpl implements CreateBrandPaneController {

	@Inject
	private CreateBrandPane view;

	@Inject
	private CreateBrandPaneModel model;

	@Override
	public void init() {
		view.init();
		model.registerObserver(view);
	}

}
