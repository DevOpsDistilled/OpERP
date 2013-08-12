package devopsdistilled.operp.client.stock.panes.controllers;

import java.util.List;

import devopsdistilled.operp.client.abstracts.SubTaskPaneController;
import devopsdistilled.operp.client.exceptions.EntityValidationException;
import devopsdistilled.operp.client.stock.panes.models.TransferStockPaneModel;
import devopsdistilled.operp.server.data.entity.stock.StockKeeper;

public interface TransferStockPaneController extends SubTaskPaneController {

	public void validate() throws EntityValidationException;

	public List<StockKeeper> transfer();

	public TransferStockPaneModel getModel();

}
