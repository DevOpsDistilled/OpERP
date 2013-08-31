package devopsdistilled.operp.server.data.service.party.impl;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import devopsdistilled.operp.client.party.models.VendorModel;
import devopsdistilled.operp.server.data.entity.party.Vendor;
import devopsdistilled.operp.server.data.repo.party.VendorRepository;
import devopsdistilled.operp.server.data.service.impl.AbstractEntityService;
import devopsdistilled.operp.server.data.service.party.VendorService;

@Service
public class VendorServiceImpl extends
		AbstractEntityService<Vendor, Long, VendorRepository, VendorModel>
		implements VendorService {

	private static final long serialVersionUID = 7983273640225740161L;

	@Inject
	private VendorRepository repo;

	@Override
	protected VendorRepository getRepo() {
		return repo;
	}

	@Override
	protected Vendor findByEntityName(String entityName) {
		return null;
	}

	@Override
	public <S extends Vendor> S save(S vendor) {
		if (vendor.getRegisteredDate() == null)
			vendor.setRegisteredDate(new Date());
		return super.save(vendor);
	}
}
