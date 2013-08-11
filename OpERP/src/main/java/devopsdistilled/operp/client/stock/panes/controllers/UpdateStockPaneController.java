package devopsdistilled.operp.client.stock.panes.controllers;

import devopsdistilled.operp.client.abstracts.SubTaskPaneController;
import devopsdistilled.operp.client.exceptions.NullFieldException;
import devopsdistilled.operp.client.stock.panes.models.UpdateStockPaneModel;
import devopsdistilled.operp.server.data.entity.stock.StockKeeper;

public interface UpdateStockPaneController extends SubTaskPaneController {

	void validate(StockKeeper stockKeeper) throws NullFieldException;

	StockKeeper save(StockKeeper stockKeeper);

	public UpdateStockPaneModel getModel();
}
