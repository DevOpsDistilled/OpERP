package devopsdistilled.operp.client.stock.models;

import java.util.List;

import devopsdistilled.operp.client.abstracts.EntityModel;
import devopsdistilled.operp.client.stock.models.observers.StockKeeperModelObserver;
import devopsdistilled.operp.server.data.entity.stock.StockKeeper;
import devopsdistilled.operp.server.data.service.stock.StockKeeperService;

public interface StockKeeperModel extends
		EntityModel<StockKeeper, StockKeeperService, StockKeeperModelObserver> {

	List<StockKeeper> saveAndUpdateModel(List<StockKeeper> stockKeepers);

}
