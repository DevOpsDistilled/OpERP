package devopsdistilled.operp.server.data.service.sales.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import devopsdistilled.operp.server.data.entity.business.PurchaseDesc;
import devopsdistilled.operp.server.data.repo.business.PurchaseDescRepository;
import devopsdistilled.operp.server.data.service.sales.PurchaseDescService;

@Service
public class PurchaseDescServiceImpl extends
		BusinessDescServiceImpl<PurchaseDesc, PurchaseDescRepository> implements
		PurchaseDescService {

	private static final long serialVersionUID = 2688393943868408691L;

	@Inject
	private PurchaseDescRepository repo;

	@Override
	protected PurchaseDescRepository getRepo() {
		return repo;
	}

	@Override
	public <S extends PurchaseDesc> S save(S entity) {
		return super.save(entity);
	}
}
