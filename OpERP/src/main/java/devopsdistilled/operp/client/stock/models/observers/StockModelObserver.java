package devopsdistilled.operp.client.stock.models.observers;

import java.util.List;

import devopsdistilled.operp.client.abstracts.EntityModelObserver;
import devopsdistilled.operp.server.data.entity.stock.Stock;

public interface StockModelObserver extends EntityModelObserver {
	public void updateStock(List<Stock> stocks);

}
