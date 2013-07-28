package devopsdistilled.operp.client.items.panes.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.items.models.ItemModel;
import devopsdistilled.operp.client.items.panes.ListItemPane;
import devopsdistilled.operp.client.items.panes.controllers.ListItemPaneController;
import devopsdistilled.operp.client.items.panes.model.ListItemPaneModel;

public class ListItemPaneControllerImpl implements ListItemPaneController {

	@Inject
	private ListItemPane view;

	@Inject
	private ListItemPaneModel model;

	@Inject
	private ItemModel itemModel;

	@Override
	public void init() {
		view.init();
		model.registerObserver(view);
		itemModel.registerObserver(view);
	}

}
