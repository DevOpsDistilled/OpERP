package devopsdistilled.operp.client.items.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.items.controllers.CreateItemPaneController;
import devopsdistilled.operp.client.items.models.BrandModel;
import devopsdistilled.operp.client.items.models.ProductModel;
import devopsdistilled.operp.client.items.views.CreateItemPane;

public class CreateItemPaneControllerImpl implements CreateItemPaneController {

	@Inject
	private CreateItemPane view;

	@Inject
	private ProductModel productModel;

	@Inject
	private BrandModel brandModel;

	@Override
	public void init() {
		view.init();
		productModel.registerObserver(view);
		brandModel.registerObserver(view);
	}

}
