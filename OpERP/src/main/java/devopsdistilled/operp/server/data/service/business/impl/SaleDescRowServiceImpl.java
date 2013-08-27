package devopsdistilled.operp.server.data.service.business.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import devopsdistilled.operp.server.data.entity.business.SaleDescRow;
import devopsdistilled.operp.server.data.repo.business.SaleDescRowRepository;
import devopsdistilled.operp.server.data.service.business.SaleDescRowService;

@Service
public class SaleDescRowServiceImpl extends
		BusinessDescRowServiceImpl<SaleDescRow, SaleDescRowRepository>
		implements SaleDescRowService {

	private static final long serialVersionUID = 3851649621319722826L;

	@Inject
	private SaleDescRowRepository repo;

	@Override
	protected SaleDescRowRepository getRepo() {
		return repo;
	}

}
