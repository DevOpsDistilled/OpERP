package devopsdistilled.operp.server.data.service.stock.impl;

import javax.inject.Inject;

import org.springframework.data.jpa.repository.JpaRepository;

import devopsdistilled.operp.server.data.entity.stock.Warehouse;
import devopsdistilled.operp.server.data.repo.stock.WarehouseRepository;
import devopsdistilled.operp.server.data.service.impl.AbstractEntityService;
import devopsdistilled.operp.server.data.service.stock.WarehouseService;

public class WarehouseServiceImpl extends 
		AbstractEntityService<Warehouse, Long>
		implements WarehouseService{
	
	private static final long serialVersionUID = -460466203849182372L;
	
	@Inject
	private WarehouseRepository warehouseRepository;
	
	@Override
	protected JpaRepository<Warehouse, Long> getRepo() {
		// TODO Auto-generated method stub
		return null;
	}

}
