package devopsdistilled.operp.client.stock.panes.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.exceptions.NullFieldException;
import devopsdistilled.operp.client.items.models.ItemModel;
import devopsdistilled.operp.client.stock.models.StockModel;
import devopsdistilled.operp.client.stock.models.WarehouseModel;
import devopsdistilled.operp.client.stock.panes.UpdateStockPane;
import devopsdistilled.operp.client.stock.panes.controllers.UpdateStockPaneController;
import devopsdistilled.operp.client.stock.panes.models.UpdateStockPaneModel;
import devopsdistilled.operp.server.data.entity.stock.StockKeeper;

public class UpdateStockPaneControllerImpl implements UpdateStockPaneController {

	@Inject
	private UpdateStockPaneModel model;

	@Inject
	private UpdateStockPane view;

	@Inject
	private WarehouseModel warehouseModel;

	@Inject
	private StockModel stockModel;

	@Inject
	private ItemModel itemModel;

	@Override
	public void init() {
		view.init();
		model.registerObserver(view);
		warehouseModel.registerObserver(view);
		itemModel.registerObserver(view);

	}

	@Override
	public void validate(StockKeeper stockKeeper) throws NullFieldException {

		if (stockKeeper.getQuantity() == null)
			throw new NullFieldException("Quantity cant't be empty");

		if (stockKeeper.getItem() == null)
			throw new NullFieldException("Stock must be associated with Item");

		if (stockKeeper.getWarehouse() == null)
			throw new NullFieldException(
					"Stock must be associated with Warehouse");

		if (stockModel.getService().isItemWarehousePairExists(stockKeeper.getItem(),
				stockKeeper.getWarehouse())) {
			// TODO
		}

	}

	@Override
	public StockKeeper save(StockKeeper stockKeeper) {
		StockKeeper savedStock = stockModel.saveAndUpdateModel(stockKeeper);
		return savedStock;

	}

}
