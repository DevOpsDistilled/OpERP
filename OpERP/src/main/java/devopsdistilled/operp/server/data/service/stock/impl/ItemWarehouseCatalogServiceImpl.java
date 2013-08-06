package devopsdistilled.operp.server.data.service.stock.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import devopsdistilled.operp.server.data.entity.stock.ItemWarehouseCatalog;
import devopsdistilled.operp.server.data.repo.stock.ItemWarehouseCatalogRepository;
import devopsdistilled.operp.server.data.service.impl.AbstractEntityService;
import devopsdistilled.operp.server.data.service.stock.ItemWarehouseCatalogService;
@Service
public class ItemWarehouseCatalogServiceImpl extends 
		AbstractEntityService<ItemWarehouseCatalog,Long, ItemWarehouseCatalogRepository> 
	implements ItemWarehouseCatalogService{

	private static final long serialVersionUID = 7042615963007198686L;
	
	@Inject
	private ItemWarehouseCatalogRepository itemWarehouseCatalogRepository;
	
	
	@Override
	protected ItemWarehouseCatalogRepository getRepo() {
		return itemWarehouseCatalogRepository;
	}

	@Override
	protected ItemWarehouseCatalog findByEntityName(String entityName) {
	//TODO
		return null;
	}

}
