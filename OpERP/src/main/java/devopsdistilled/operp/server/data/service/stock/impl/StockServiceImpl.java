package devopsdistilled.operp.server.data.service.stock.impl;

import javax.inject.Inject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import devopsdistilled.operp.server.data.entity.stock.Stock;
import devopsdistilled.operp.server.data.repo.stock.StockRepository;
import devopsdistilled.operp.server.data.service.impl.AbstractServiceImpl;

@Service
public class StockServiceImpl extends AbstractServiceImpl<Stock, Long>{
private static final long serialVersionUID = -7737068540744137395L;
	
	@Inject
	private StockRepository stockRepository;
	@Override
	protected JpaRepository<Stock, Long> getRepo() {
		return stockRepository;
	}



}
