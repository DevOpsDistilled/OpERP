package devopsdistilled.operp.client.items.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.items.controllers.ListItemPaneController;
import devopsdistilled.operp.client.items.models.ItemModel;
import devopsdistilled.operp.client.items.models.ListItemPaneModel;
import devopsdistilled.operp.client.items.views.ListItemPane;

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
