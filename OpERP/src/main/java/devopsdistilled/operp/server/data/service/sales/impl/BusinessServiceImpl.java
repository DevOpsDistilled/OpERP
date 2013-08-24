package devopsdistilled.operp.server.data.service.sales.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import devopsdistilled.operp.server.data.entity.business.Business;
import devopsdistilled.operp.server.data.service.impl.AbstractEntityService;
import devopsdistilled.operp.server.data.service.sales.BusinessService;

public abstract class BusinessServiceImpl<B extends Business<?, ?>, R extends JpaRepository<B, Long>>
		extends AbstractEntityService<B, Long, R> implements BusinessService<B> {

	private static final long serialVersionUID = 2019639925021618876L;

	@Override
	protected B findByEntityName(String entityName) {
		return null;
	}

}
