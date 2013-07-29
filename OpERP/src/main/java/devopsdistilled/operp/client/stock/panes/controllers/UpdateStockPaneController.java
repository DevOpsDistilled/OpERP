package devopsdistilled.operp.client.stock.panes.controllers;

import devopsdistilled.operp.client.abstracts.SubTaskPaneController;
import devopsdistilled.operp.client.items.exceptions.NullFieldException;
import devopsdistilled.operp.server.data.entity.stock.Stock;

public interface UpdateStockPaneController extends SubTaskPaneController {

		void validateStock(Stock stock) throws NullFieldException;
		
		Stock update(Stock stock);
}
