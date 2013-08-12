package devopsdistilled.operp.client.stock.panes.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.exceptions.EntityValidationException;
import devopsdistilled.operp.client.exceptions.NullFieldException;
import devopsdistilled.operp.client.stock.models.StockModel;
import devopsdistilled.operp.client.stock.models.WarehouseModel;
import devopsdistilled.operp.client.stock.panes.TransferStockPane;
import devopsdistilled.operp.client.stock.panes.controllers.TransferStockPaneController;
import devopsdistilled.operp.client.stock.panes.models.TransferStockPaneModel;

public class TransferStockPaneControllerImpl implements
		TransferStockPaneController {

	@Inject
	private TransferStockPane view;

	@Inject
	private WarehouseModel warehouseModel;

	@Inject
	private TransferStockPaneModel model;

	@Inject
	private StockModel stockModel;

	@Override
	public void init() {
		view.init();
		warehouseModel.registerObserver(view);
		model.registerObserver(view);
	}

	@Override
	public void validate() throws EntityValidationException {
		if (model.getFromWarehouse() == null)
			throw new NullFieldException("Source Warehouse should be selected");

		if (model.getItemToTransfer() == null)
			throw new NullFieldException("Select Item to transfer");

		if (model.getToWarehouse() == null)
			throw new NullFieldException(
					"Destinatino Warehouse shouldn't be empty");

		if (model.getQuantity() == null || model.getQuantity().equals(0L))
			throw new NullFieldException("Quantity can't be zero");

		Long srcQuantity = stockModel.getService()
				.getQuantityOfItemInWarehouse(
						model.getItemToTransfer().getItemId(),
						model.getFromWarehouse().getWarehouseId());

		if (model.getQuantity().compareTo(0L) < 0)
			throw new EntityValidationException(
					"Can't transfer negative number of items");

		if (srcQuantity.compareTo(model.getQuantity()) < 0)
			throw new EntityValidationException("Only "
					+ srcQuantity.toString() + " " + model.getItemToTransfer()
					+ " available in " + model.getFromWarehouse());

	}

	@Override
	public void transfer() {
		// TODO Auto-generated method stub

	}

	@Override
	public TransferStockPaneModel getModel() {
		return model;
	}

}
