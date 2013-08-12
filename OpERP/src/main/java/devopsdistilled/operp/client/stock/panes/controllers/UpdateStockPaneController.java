package devopsdistilled.operp.client.stock.panes.controllers;

import devopsdistilled.operp.client.abstracts.SubTaskPaneController;
import devopsdistilled.operp.client.exceptions.EntityValidationException;
import devopsdistilled.operp.client.stock.panes.models.UpdateStockPaneModel;
import devopsdistilled.operp.server.data.entity.stock.StockKeeper;

public interface UpdateStockPaneController extends SubTaskPaneController {

	void validate() throws EntityValidationException;

	StockKeeper save();

	public UpdateStockPaneModel getModel();
}
