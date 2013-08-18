package devopsdistilled.operp.client.party.panes.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.party.panes.ListVendorPane;
import devopsdistilled.operp.client.party.panes.controllers.ListVendorPaneController;
import devopsdistilled.operp.client.party.panes.models.ListVendorPaneModel;

public class ListVendorPaneControllerImpl implements ListVendorPaneController {

	@Inject
	private ListVendorPane view;

	@Inject
	private ListVendorPaneModel model;

	@Override
	public void init() {
		view.init();
		model.registerObserver(view);
	}

}
