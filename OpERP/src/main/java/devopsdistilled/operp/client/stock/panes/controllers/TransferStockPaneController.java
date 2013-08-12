package devopsdistilled.operp.client.stock.panes.controllers;

import devopsdistilled.operp.client.abstracts.SubTaskPaneController;
import devopsdistilled.operp.client.exceptions.EntityValidationException;
import devopsdistilled.operp.client.stock.panes.models.TransferStockPaneModel;

public interface TransferStockPaneController extends SubTaskPaneController {

	public void validate() throws EntityValidationException;

	public void transfer();

	public TransferStockPaneModel getModel();

}
