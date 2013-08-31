package devopsdistilled.operp.server.data.service.commons.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import devopsdistilled.operp.client.commons.models.AddressModel;
import devopsdistilled.operp.server.data.entity.commons.Address;
import devopsdistilled.operp.server.data.repo.commons.AddressRepository;
import devopsdistilled.operp.server.data.service.commons.AddressService;
import devopsdistilled.operp.server.data.service.impl.AbstractEntityService;

@Service
public class AddressServiceImpl extends
		AbstractEntityService<Address, Long, AddressRepository, AddressModel>
		implements AddressService {

	private static final long serialVersionUID = -8957185104379351117L;

	@Inject
	private AddressRepository repo;

	@Override
	protected AddressRepository getRepo() {
		return repo;
	}

	@Override
	protected Address findByEntityName(String entityName) {
		return null;
	}

}
