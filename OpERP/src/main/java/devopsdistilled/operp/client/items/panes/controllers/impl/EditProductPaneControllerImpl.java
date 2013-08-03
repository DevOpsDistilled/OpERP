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
	public void init(Product product) {
		view.init();
		categoryModel.registerObserver(view);

		// Respective Models are to be registered at last.
		model.setEntity(product);
		model.registerObserver(view);
	}

	@Override
	public void validate(Product product) throws NullFieldException,
			EntityNameExistsException {

		if (product.getProductName().equalsIgnoreCase(""))
			throw new NullFieldException("Product Name can't be empty");

		if (product.getCategories().size() == 0)
			throw new NullFieldException(
					"Product should be of atleast 1 category");

		if (!productModel.getService().isProductNameValidForProduct(
				product.getProductId(), product.getProductName()))
			throw new EntityNameExistsException("Product Name already exists");

	}

	@Override
	public Product save(Product product) {
		return productModel.saveAndUpdateModel(product);
	}

}
