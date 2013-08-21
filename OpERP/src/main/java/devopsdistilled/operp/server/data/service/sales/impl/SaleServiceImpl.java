package devopsdistilled.operp.server.data.service.sales.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import devopsdistilled.operp.server.data.entity.business.Sale;
import devopsdistilled.operp.server.data.repo.sales.SaleRepository;
import devopsdistilled.operp.server.data.service.sales.SaleService;

@Service
public class SaleServiceImpl extends BusinessServiceImpl<Sale, SaleRepository>
		implements SaleService {

	private static final long serialVersionUID = 2688393943868408691L;

	@Inject
	private SaleRepository repo;

	@Override
	protected SaleRepository getRepo() {
		return repo;
	}

}
