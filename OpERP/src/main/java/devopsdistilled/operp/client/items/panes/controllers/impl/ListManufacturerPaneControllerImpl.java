package devopsdistilled.operp.client.items.panes.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.items.panes.ListManufacturerPane;
import devopsdistilled.operp.client.items.panes.controllers.ListManufacturerPaneController;
import devopsdistilled.operp.client.items.panes.models.ListManufacturerPaneModel;

public class ListManufacturerPaneControllerImpl implements
		ListManufacturerPaneController {

	@Inject
	private ListManufacturerPane view;

	@Inject
	private ListManufacturerPaneModel model;

	@Override
	public void init() {
		view.init();
		model.registerObserver(view);
	}

}
