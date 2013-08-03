package devopsdistilled.operp.client.items.panes.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.items.exceptions.EntityNameExistsException;
import devopsdistilled.operp.client.items.exceptions.NullFieldException;
import devopsdistilled.operp.client.items.models.CategoryModel;
import devopsdistilled.operp.client.items.models.ProductModel;
import devopsdistilled.operp.client.items.panes.EditProductPane;
import devopsdistilled.operp.client.items.panes.controllers.EditProductPaneController;
import devopsdistilled.operp.client.items.panes.models.EditProductPaneModel;
import devopsdistilled.operp.server.data.entity.items.Product;

public class EditProductPaneControllerImpl implements EditProductPaneController {

	@Inject
	private EditProductPane view;

	@Inject
	private EditProductPaneModel model;

	@Inject
	private ProductModel productModel;

	@Inject
	private CategoryModel categoryModel;

	@Override
	public void init(Product entity) {
		view.init();
		model.registerObserver(view);
		categoryModel.registerObserver(view);
	}

	@Override
	public void validate(Product entity) throws NullFieldException,
			EntityNameExistsException {
		// TODO Auto-generated method stub

	}

	@Override
	public Product save(Product entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
