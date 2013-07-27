package devopsdistilled.operp.client.items.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.items.controllers.EditItemPaneController;
import devopsdistilled.operp.client.items.models.BrandModel;
import devopsdistilled.operp.client.items.models.EditItemPaneModel;
import devopsdistilled.operp.client.items.models.ItemModel;
import devopsdistilled.operp.client.items.models.ProductModel;
import devopsdistilled.operp.client.items.views.EditItemPane;
import devopsdistilled.operp.server.data.entity.items.Item;

public class EditItemPaneControllerImpl implements EditItemPaneController {

	@Inject
	private EditItemPane view;

	@Inject
	private EditItemPaneModel model;

	@Inject
	private ItemModel itemModel;

	@Inject
	private ProductModel productModel;

	@Inject
	private BrandModel brandModel;

	@Override
	public void init() {

	}

	@Override
	public void init(Item item) {
		view.init();
		model.setItem(item);
		model.registerObserver(view);
		productModel.registerObserver(view);
		brandModel.registerObserver(view);
	}

}
