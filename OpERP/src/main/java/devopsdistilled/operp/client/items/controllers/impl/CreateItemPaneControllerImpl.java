package devopsdistilled.operp.client.items.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.items.controllers.CreateItemPaneController;
import devopsdistilled.operp.client.items.models.ItemModel;
import devopsdistilled.operp.client.items.views.CreateItemPane;

public class CreateItemPaneControllerImpl implements CreateItemPaneController {

	@Inject
	private CreateItemPane view;

	@Inject
	private ItemModel itemModel;

	@Override
	public void init() {
		view.init();
		itemModel.registerObserver(view);

	}

}
