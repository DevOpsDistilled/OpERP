package devopsdistilled.operp.client.items.panes.controllers.impl;

import javax.inject.Inject;
import devopsdistilled.operp.client.exceptions.NullFieldException;
import devopsdistilled.operp.client.items.exceptions.EntityNameExistsException;
import devopsdistilled.operp.client.items.exceptions.ProductBrandPairExistsException;
import devopsdistilled.operp.client.items.models.BrandModel;
import devopsdistilled.operp.client.items.models.ItemModel;
import devopsdistilled.operp.client.items.models.ProductModel;
import devopsdistilled.operp.client.items.panes.EditItemPane;
import devopsdistilled.operp.client.items.panes.controllers.EditItemPaneController;
import devopsdistilled.operp.client.items.panes.models.EditItemPaneModel;
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
	public void init(Item item) {
		view.init();
		productModel.registerObserver(view);
		brandModel.registerObserver(view);
		model.setEntity(item);
		model.registerObserver(view);
	}

	@Override
	public Item save(Item item) {
		return itemModel.saveAndUpdateModel(item);
	}

	@Override
	public void validate(Item item) throws ProductBrandPairExistsException,
			EntityNameExistsException, NullFieldException {

		if (item.getItemId() == null)
			throw new NullFieldException(
					"Item Id encountered, Contact Developer");

		if (item.getItemName().equalsIgnoreCase(""))
			throw new NullFieldException("Item Name can't be empty");

		if (item.getProduct() == null)
			throw new NullFieldException(
					"Item should be associated with a product");

		if (item.getBrand() == null)
			throw new NullFieldException(
					"Item should be associated with a brand");

		if (item.getPrice() == null)
			throw new NullFieldException("Item Price Null encountered");

		if (!itemModel.getService().isProductBrandPairValidForItem(
				item.getItemId(), item.getProduct(), item.getBrand()))
			throw new ProductBrandPairExistsException(
					"Product and Brand Pair already exists");

		if (!itemModel.getService().isItemNameValidForItem(item.getItemId(),
				item.getItemName()))
			throw new EntityNameExistsException("Item Name already exists");
	}
}
