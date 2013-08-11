package devopsdistilled.operp.server.data.service.stock.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import devopsdistilled.operp.server.data.entity.stock.StockKeeper;
import devopsdistilled.operp.server.data.repo.stock.StockKeeperRepository;
import devopsdistilled.operp.server.data.service.impl.AbstractEntityService;
import devopsdistilled.operp.server.data.service.stock.StockKeeperService;

@Service
public class StockKeeperServiceImpl extends
		AbstractEntityService<StockKeeper, Long, StockKeeperRepository>
		implements StockKeeperService {

	private static final long serialVersionUID = -1311042040845285500L;

	@Inject
	private StockKeeperRepository repo;

	@Override
	protected StockKeeperRepository getRepo() {
		return repo;
	}

	@Override
	protected StockKeeper findByEntityName(String entityName) {
		// TODO Auto-generated method stub
		return null;
	}

}
