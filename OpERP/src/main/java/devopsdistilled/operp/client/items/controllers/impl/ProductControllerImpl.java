package devopsdistilled.operp.client.items.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.items.controllers.ProductController;
import devopsdistilled.operp.client.items.models.ProductModel;
import devopsdistilled.operp.client.items.panes.controllers.CreateProductPaneController;
import devopsdistilled.operp.client.items.panes.controllers.ListProductPaneController;
import devopsdistilled.operp.server.data.entity.items.Product;

public class ProductControllerImpl implements ProductController {

	@Inject
	private ProductModel productModel;

	@Inject
	private CreateProductPaneController createProductPaneController;

	@Inject
	private ListProductPaneController listProductPaneController;

	@Override
	public void create() {
		createProductPaneController.init();
	}

	@Override
	public void edit(Product product) {
		// TODO Auto-generated method stub

	}

	@Override
	public void list() {
		listProductPaneController.init();
	}

	@Override
	public void delete(Product product) {
		productModel.deleteAndUpdateModel(product);
	}

}
