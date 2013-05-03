package devopsdistilled.operp.server.data.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import devopsdistilled.operp.server.data.entity.Manufacturer;
import devopsdistilled.operp.server.data.repo.ManufacturerRepository;
import devopsdistilled.operp.server.data.service.ManufacturerService;

@Service
public class ManufacturerServiceImpl extends
		AbstractServiceImpl<Manufacturer, Long> implements ManufacturerService {

	private static final long serialVersionUID = 3305398260136667908L;

	@Inject
	private ManufacturerRepository repo;

	public void printInfo() {
		System.out.println("super.repo Before\n" + super.repo);
		super.repo = repo;
		System.out.println("super.repo After\n" + super.repo);
		System.out.println("Repo\n" + repo);
	}

	@Override
	public Manufacturer createManufacturer() {
		return new Manufacturer();
	}
	
	

	/*
	 * @Override public <S extends Manufacturer> S save(S entity) { return
	 * super.save(entity); }
	 */
}
