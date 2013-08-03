package devopsdistilled.operp.client.items.panes.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.items.panes.ListProductPane;
import devopsdistilled.operp.client.items.panes.controllers.ListProductPaneController;
import devopsdistilled.operp.client.items.panes.models.ListProductPaneModel;

public class ListProductPaneControllerImpl implements ListProductPaneController {

	@Inject
	private ListProductPane view;

	@Inject
	private ListProductPaneModel model;

	@Override
	public void init() {
		view.init();
		model.registerObserver(view);
	}

}
