package devopsdistilled.operp.server.data.service.stock.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import devopsdistilled.operp.server.data.entity.stock.Warehouse;
import devopsdistilled.operp.server.data.repo.stock.WarehouseRepository;
import devopsdistilled.operp.server.data.service.impl.AbstractEntityService;
import devopsdistilled.operp.server.data.service.stock.WarehouseService;

@Service
public class WarehouseServiceImpl extends
		AbstractEntityService<Warehouse, Long, WarehouseRepository> implements
		WarehouseService {

	private static final long serialVersionUID = -460466203849182372L;

	@Inject
	private WarehouseRepository warehouseRepository;

	@Override
	protected WarehouseRepository getRepo() {
		return warehouseRepository;
	}

	@Override
	public boolean isWarehouseNameExists(String warehouseName) {
		Warehouse warehouse = warehouseRepository
				.findByWarehouseName(warehouseName);
		if (warehouse != null)
			return true;

		return false;
	}

	@Override
	public boolean isWarehouseNameValidForWarehouse(Long warehouseId,
			String warehouseName) {
		Warehouse warehouse = warehouseRepository
				.findByWarehouseName(warehouseName);
		if (warehouse == null) {
			return true;
		}
		if (warehouse.getWarehouseId().equals(warehouseId))
			return true;
		return false;
	}

	@Override
	protected Warehouse findByEntityName(String entityName) {
		return warehouseRepository.findByWarehouseName(entityName);
	}

}
