package devopsdistilled.operp.client.stock.panes.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.exceptions.EntityValidationException;
import devopsdistilled.operp.client.exceptions.NullFieldException;
import devopsdistilled.operp.client.items.models.ItemModel;
import devopsdistilled.operp.client.stock.models.StockKeeperModel;
import devopsdistilled.operp.client.stock.models.StockModel;
import devopsdistilled.operp.client.stock.models.WarehouseModel;
import devopsdistilled.operp.client.stock.panes.UpdateStockPane;
import devopsdistilled.operp.client.stock.panes.controllers.UpdateStockPaneController;
import devopsdistilled.operp.client.stock.panes.models.UpdateStockPaneModel;
import devopsdistilled.operp.server.data.entity.stock.Stock;
import devopsdistilled.operp.server.data.entity.stock.StockKeeper;

public class UpdateStockPaneControllerImpl implements UpdateStockPaneController {

	@Inject
	private UpdateStockPaneModel model;

	@Inject
	private UpdateStockPane view;

	@Inject
	private WarehouseModel warehouseModel;

	@Inject
	private ItemModel itemModel;

	@Inject
	private StockKeeperModel stockKeeperModel;

	@Inject
	private StockModel stockModel;

	@Override
	public void init() {
		view.init();
		model.registerObserver(view);
		warehouseModel.registerObserver(view);
		itemModel.registerObserver(view);
	}

	@Override
	public void validate() throws EntityValidationException {
		if (model.getItem() == null || model.getWarehouse() == null
				|| model.getQuantity() == null)
			throw new NullFieldException();

		if (model.getQuantity().compareTo(0L) == 0)
			throw new NullFieldException("O isn't a valid quantity");

		if (model.getQuantity().compareTo(0L) < 0) {
			if (!stockModel.getService().isItemExistsInWarehouse(
					model.getItem().getItemId(),
					model.getWarehouse().getWarehouseId())) {

				throw new EntityValidationException(model.getItem()
						+ " doesn't exists in " + model.getWarehouse());
			}

			Long stockQuantity = stockModel.getService()
					.getQuantityOfItemInWarehouse(model.getItem().getItemId(),
							model.getWarehouse().getWarehouseId());
			if (model.getQuantity().compareTo(stockQuantity * (-1)) < 0)
				throw new EntityValidationException("Only "
						+ stockQuantity.toString() + " " + model.getItem()
						+ " available in " + model.getWarehouse());
		}
	}

	@Override
	public StockKeeper save() {
		Stock stock = new Stock();
		stock.setItem(model.getItem());
		stock.setWarehouse(model.getWarehouse());
		StockKeeper stockKeeper = new StockKeeper();
		stockKeeper.setStock(stock);
		stockKeeper.setNote(model.getNote());
		stockKeeper.setQuantity(model.getQuantity());
		return stockKeeperModel.saveAndUpdateModel(stockKeeper);
	}

	@Override
	public UpdateStockPaneModel getModel() {
		return model;
	}

}
