package devopsdistilled.operp.server.data.service.stock.impl;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import devopsdistilled.operp.server.data.entity.items.Item;
import devopsdistilled.operp.server.data.entity.stock.Stock;
import devopsdistilled.operp.server.data.entity.stock.Warehouse;
import devopsdistilled.operp.server.data.repo.stock.StockRepository;
import devopsdistilled.operp.server.data.service.impl.AbstractEntityService;
import devopsdistilled.operp.server.data.service.stock.StockService;

@Service
public class StockServiceImpl extends
		AbstractEntityService<Stock, Long, StockRepository> 
		implements StockService{
	
private static final long serialVersionUID = -7737068540744137395L;
	
	@Inject
	private StockRepository stockRepository;

	@Override
	protected StockRepository getRepo() {
		return stockRepository;
	}

	@Override
	protected Stock findByEntityName(String entityName) {
		
		return null;
	}

	@Override
	public boolean isItemWarehousePairExists(Item item, Warehouse warehouse) {
		Stock stock=stockRepository.findByItemAndWarehouse(item, warehouse);
		if(stock!=null)
			return true;
		else
			return false;
	}

	
	



}
