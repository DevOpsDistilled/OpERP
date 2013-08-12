package devopsdistilled.operp.client.stock.models.impl;

import java.util.List;

import javax.inject.Inject;

import devopsdistilled.operp.client.abstracts.AbstractEntityModel;
import devopsdistilled.operp.client.stock.models.StockKeeperModel;
import devopsdistilled.operp.client.stock.models.observers.StockKeeperModelObserver;
import devopsdistilled.operp.server.data.entity.stock.StockKeeper;
import devopsdistilled.operp.server.data.service.stock.StockKeeperService;

public class StockKeeperModelImpl
		extends
		AbstractEntityModel<StockKeeper, StockKeeperService, StockKeeperModelObserver>
		implements StockKeeperModel {

	@Inject
	private StockKeeperService service;

	@Override
	public StockKeeperService getService() {
		return service;
	}

	@Override
	public List<StockKeeper> saveAndUpdateModel(List<StockKeeper> stockKeepers) {
		List<StockKeeper> savedStockKeepers = getService().save(stockKeepers);
		update();
		return savedStockKeepers;
	}

}
