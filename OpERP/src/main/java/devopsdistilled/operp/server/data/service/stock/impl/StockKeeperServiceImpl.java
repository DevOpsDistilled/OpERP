package devopsdistilled.operp.server.data.service.stock.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import devopsdistilled.operp.server.data.entity.stock.Stock;
import devopsdistilled.operp.server.data.entity.stock.StockKeeper;
import devopsdistilled.operp.server.data.repo.stock.StockKeeperRepository;
import devopsdistilled.operp.server.data.repo.stock.StockRepository;
import devopsdistilled.operp.server.data.service.impl.AbstractEntityService;
import devopsdistilled.operp.server.data.service.stock.StockKeeperService;

@Service
public class StockKeeperServiceImpl extends
		AbstractEntityService<StockKeeper, Long, StockKeeperRepository>
		implements StockKeeperService {

	private static final long serialVersionUID = -1311042040845285500L;

	@Inject
	private StockKeeperRepository repo;

	@Inject
	private StockRepository stockRepository;

	@Override
	protected StockKeeperRepository getRepo() {
		return repo;
	}

	@Override
	protected StockKeeper findByEntityName(String entityName) {
		return null;
	}

	@Override
	@Transactional
	public <S extends StockKeeper> S save(S stockKeeper) {
		Stock stock = stockRepository.findByItemAndWarehouse(stockKeeper
				.getStock().getItem(), stockKeeper.getStock().getWarehouse());

		if (stock != null) {
			stock.setQuantity(stock.getQuantity() + stockKeeper.getQuantity());
		} else {
			stock = stockKeeper.getStock();
			stock.setQuantity(stockKeeper.getQuantity());
		}
		stock = stockRepository.save(stock);
		stockKeeper.setStock(stock);

		return super.save(stockKeeper);

	}
}
