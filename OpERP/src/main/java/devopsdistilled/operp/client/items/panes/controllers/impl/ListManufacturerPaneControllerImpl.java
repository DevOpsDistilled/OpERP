package devopsdistilled.operp.client.items.panes.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.items.models.ManufacturerModel;
import devopsdistilled.operp.client.items.panes.ListManufacturerPane;
import devopsdistilled.operp.client.items.panes.controllers.ListManufacturerPaneController;
import devopsdistilled.operp.client.items.panes.models.ListManufacturerPaneModel;

public class ListManufacturerPaneControllerImpl implements
		ListManufacturerPaneController {

	@Inject
	private ListManufacturerPane view;

	@Inject
	private ListManufacturerPaneModel model;

	@Inject
	private ManufacturerModel manufacturerModel;

	@Override
	public void init() {
		view.init();
		manufacturerModel.registerObserver(view);
		model.registerObserver(view);
	}

}
