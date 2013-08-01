package devopsdistilled.operp.client.items.controllers.impl;

import javax.inject.Inject;

import org.springframework.context.ApplicationContext;

import devopsdistilled.operp.client.items.controllers.ProductController;
import devopsdistilled.operp.client.items.panes.controllers.CreateProductPaneController;
import devopsdistilled.operp.server.data.entity.items.Product;

public class ProductControllerImpl implements ProductController {

	@Inject
	private ApplicationContext context;

	@Override
	public void create() {
		CreateProductPaneController createProductPaneController = context
				.getBean(CreateProductPaneController.class);
		createProductPaneController.init();
	}

	@Override
	public void edit(Product entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void list() {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Product entity) {
		// TODO Auto-generated method stub

	}

}
