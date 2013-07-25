package devopsdistilled.operp.client.items.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.items.controllers.CreateItemPaneController;
import devopsdistilled.operp.client.items.models.BrandModel;
import devopsdistilled.operp.client.items.models.CreateItemPaneModel;
import devopsdistilled.operp.client.items.models.ItemModel;
import devopsdistilled.operp.client.items.models.ProductModel;
import devopsdistilled.operp.client.items.views.CreateItemPane;
import devopsdistilled.operp.server.data.entity.items.Item;

public class CreateItemPaneControllerImpl implements CreateItemPaneController {

	@Inject
	private CreateItemPaneModel model;

	@Inject
	private CreateItemPane view;

	@Inject
	private ItemModel itemModel;

	@Inject
	private ProductModel productModel;

	@Inject
	private BrandModel brandModel;

	@Override
	public void init() {
		view.init();
		model.registerObserver(view);
		productModel.registerObserver(view);
		brandModel.registerObserver(view);
	}

	@Override
	public void validate(Item item) {
		// TODO Auto-generated method stub

	}

}
