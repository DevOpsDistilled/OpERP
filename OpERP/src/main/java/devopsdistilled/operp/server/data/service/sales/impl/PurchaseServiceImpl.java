package devopsdistilled.operp.server.data.service.sales.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import devopsdistilled.operp.server.data.entity.business.Purchase;
import devopsdistilled.operp.server.data.repo.sales.PurchaseRepository;
import devopsdistilled.operp.server.data.service.sales.PurchaseService;

@Service
public class PurchaseServiceImpl extends
		BusinessServiceImpl<Purchase, PurchaseRepository> implements
		PurchaseService {

	private static final long serialVersionUID = -3850676611924720197L;

	@Inject
	private PurchaseRepository repo;

	@Override
	protected PurchaseRepository getRepo() {
		return repo;
	}

}
