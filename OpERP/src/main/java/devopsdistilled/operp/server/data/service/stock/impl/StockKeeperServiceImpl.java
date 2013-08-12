package devopsdistilled.operp.server.data.service.stock.impl;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

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
		stockKeeper.setStockUpdateDate(new Date());

		return super.save(stockKeeper);

	}

	@Override
	@Transactional
	public void delete(StockKeeper stockKeeper) {
		Stock stock = stockKeeper.getStock();
		stock.setQuantity(stock.getQuantity() - stockKeeper.getQuantity());
		stock = stockRepository.save(stock);
		stockKeeper.setStock(stock);

		super.delete(stockKeeper);
	}

	@Override
	@Transactional
	public List<StockKeeper> saveTransfer(StockKeeper srcStockKeeper,
			StockKeeper destStockKeeper) {
		List<StockKeeper> savedStockKeepers = new LinkedList<>();
		srcStockKeeper = save(srcStockKeeper);
		destStockKeeper = save(destStockKeeper);

		srcStockKeeper.setTransferStockKeeper(destStockKeeper);
		destStockKeeper.setTransferStockKeeper(srcStockKeeper);

		savedStockKeepers.add(srcStockKeeper);
		savedStockKeepers.add(destStockKeeper);

		return savedStockKeepers;
	}

	@Override
	@Transactional
	public void delete(StockKeeper srcStockKeeper, StockKeeper destStockKeeper) {
		delete(srcStockKeeper);
		delete(destStockKeeper);
	}
}
