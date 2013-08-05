package devopsdistilled.operp.client.items.panes.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.items.models.ManufacturerModel;
import devopsdistilled.operp.client.items.panes.CreateBrandPane;
import devopsdistilled.operp.client.items.panes.controllers.CreateBrandPaneController;
import devopsdistilled.operp.client.items.panes.models.CreateBrandPaneModel;

public class CreateBrandPaneControllerImpl implements CreateBrandPaneController {

	@Inject
	private CreateBrandPane view;

	@Inject
	private CreateBrandPaneModel model;

	@Inject
	private ManufacturerModel manufacturerModel;

	@Override
	public void init() {
		view.init();
		manufacturerModel.registerObserver(view);
		model.registerObserver(view);
	}

}
