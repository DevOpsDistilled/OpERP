package devopsdistilled.operp.server.data.service.stock;

import java.util.List;

import devopsdistilled.operp.server.data.entity.stock.StockKeeper;
import devopsdistilled.operp.server.data.service.EntityService;

public interface StockKeeperService extends EntityService<StockKeeper, Long> {

	List<StockKeeper> saveTransfer(StockKeeper srcStockKeeper,
			StockKeeper destStockKeeper);

}
