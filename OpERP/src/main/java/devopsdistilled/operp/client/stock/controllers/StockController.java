package devopsdistilled.operp.client.stock.controllers;

import devopsdistilled.operp.client.abstracts.EntityController;
import devopsdistilled.operp.server.data.entity.stock.Stock;

public interface StockController extends EntityController<Stock> {

	public void transfer();

}
