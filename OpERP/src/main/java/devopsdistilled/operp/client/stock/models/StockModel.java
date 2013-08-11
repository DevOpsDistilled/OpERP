package devopsdistilled.operp.client.stock.models;

import devopsdistilled.operp.client.abstracts.EntityModel;
import devopsdistilled.operp.client.stock.models.observers.StockModelObserver;
import devopsdistilled.operp.server.data.entity.stock.StockKeeper;
import devopsdistilled.operp.server.data.service.stock.StockService;

public interface StockModel extends
		EntityModel<StockKeeper, StockService, StockModelObserver> {

}
