package devopsdistilled.operp.client.stock.models.observers;

import java.util.List;

import devopsdistilled.operp.client.abstracts.EntityModelObserver;
import devopsdistilled.operp.server.data.entity.stock.StockKeeper;

public interface StockKeeperModelObserver extends EntityModelObserver {
	public void updateStockActivities(List<StockKeeper> stockActivities);
}
