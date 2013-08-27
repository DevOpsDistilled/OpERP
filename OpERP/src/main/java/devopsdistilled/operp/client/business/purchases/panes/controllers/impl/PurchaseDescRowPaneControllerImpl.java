package devopsdistilled.operp.client.business.purchases.panes.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.abstracts.EntityOperation;
import devopsdistilled.operp.client.business.purchases.panes.PurchaseDescRowPane;
import devopsdistilled.operp.client.business.purchases.panes.controllers.PurchaseDescRowPaneController;
import devopsdistilled.operp.client.business.purchases.panes.models.PurchaseDescRowPaneModel;
import devopsdistilled.operp.client.exceptions.EntityValidationException;
import devopsdistilled.operp.client.items.models.ItemModel;
import devopsdistilled.operp.client.stock.models.WarehouseModel;
import devopsdistilled.operp.server.data.entity.business.PurchaseDescRow;

public class PurchaseDescRowPaneControllerImpl implements
		PurchaseDescRowPaneController {

	@Inject
	private PurchaseDescRowPane view;

	@Inject
	private PurchaseDescRowPaneModel model;

	@Inject
	private ItemModel itemModel;

	@Inject
	private WarehouseModel warehouseModel;

	@Override
	public void validate() throws EntityValidationException {
		// TODO Auto-generated method stub

	}

	@Override
	public PurchaseDescRow save() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PurchaseDescRowPaneModel getModel() {
		return model;
	}

	@Override
	public PurchaseDescRowPane getView() {
		return view;
	}

	@Override
	public void init(PurchaseDescRow purchaseDescRow,
			EntityOperation entityOperation) {

		view.setController(this);
		view.resetComponents();

		model.registerObserver(view);
		model.setEntityAndEntityOperation(purchaseDescRow, entityOperation);

		itemModel.registerObserver(view);
		warehouseModel.registerObserver(view);
	}

}
