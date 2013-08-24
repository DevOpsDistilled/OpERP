package devopsdistilled.operp.server.data.service.business.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import devopsdistilled.operp.server.data.entity.business.SaleDesc;
import devopsdistilled.operp.server.data.repo.business.SaleDescRepository;
import devopsdistilled.operp.server.data.service.business.SaleDescService;

@Service
public class SaleDescServiceImpl extends
		BusinessDescServiceImpl<SaleDesc, SaleDescRepository> implements
		SaleDescService {

	private static final long serialVersionUID = 2688393943868408691L;

	@Inject
	private SaleDescRepository repo;

	@Override
	protected SaleDescRepository getRepo() {
		return repo;
	}

	@Override
	public <S extends SaleDesc> S save(S entity) {
		return super.save(entity);
	}
}
