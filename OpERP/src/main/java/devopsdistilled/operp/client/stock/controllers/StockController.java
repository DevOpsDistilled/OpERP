package devopsdistilled.operp.client.stock.controllers;

import devopsdistilled.operp.client.abstracts.EntityController;
import devopsdistilled.operp.server.data.entity.stock.StockKeeper;

public interface StockController extends EntityController<StockKeeper> {

	public void transfer();

}
