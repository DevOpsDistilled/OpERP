package devopsdistilled.operp.client.stock.panes.controllers;

import devopsdistilled.operp.client.abstracts.SubTaskPaneController;
import devopsdistilled.operp.client.exceptions.NullFieldException;
import devopsdistilled.operp.server.data.entity.stock.Stock;

public interface CreateStockPaneController extends SubTaskPaneController {

		void validate(Stock stock) throws NullFieldException;

		Stock save(Stock stock);
}
