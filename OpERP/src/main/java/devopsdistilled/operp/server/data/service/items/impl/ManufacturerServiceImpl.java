package devopsdistilled.operp.server.data.service.items.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import devopsdistilled.operp.server.data.entity.items.Manufacturer;
import devopsdistilled.operp.server.data.repo.items.ManufacturerRepository;
import devopsdistilled.operp.server.data.service.impl.AbstractEntityService;
import devopsdistilled.operp.server.data.service.items.ManufacturerService;

@Service
public class ManufacturerServiceImpl extends
		AbstractEntityService<Manufacturer, Long, ManufacturerRepository>
		implements ManufacturerService {

	private static final long serialVersionUID = -6005274349296129598L;

	@Inject
	private ManufacturerRepository repo;

	@Override
	protected ManufacturerRepository getRepo() {
		return repo;
	}

}
