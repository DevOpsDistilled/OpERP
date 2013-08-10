package devopsdistilled.operp.client.stock.panes.controllers;

import devopsdistilled.operp.client.abstracts.SubTaskPaneController;
import devopsdistilled.operp.client.exceptions.EntityValidationException;
import devopsdistilled.operp.server.data.entity.stock.Warehouse;

public interface TransferStockPaneController extends SubTaskPaneController {

	public void validate(Warehouse fromWarehouse, Warehouse toWarehouse,
			Long quantity) throws EntityValidationException;

	public void transfer(Warehouse fromWarehouse, Warehouse toWarehouse,
			Long quantity);

}
