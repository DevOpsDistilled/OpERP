package devopsdistilled.operp.server.data.service.business.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import devopsdistilled.operp.server.data.entity.business.BusinessDesc;
import devopsdistilled.operp.server.data.service.business.BusinessDescService;
import devopsdistilled.operp.server.data.service.impl.AbstractEntityService;

public abstract class BusinessDescServiceImpl<B extends BusinessDesc<?, ?>, R extends JpaRepository<B, Long>>
		extends AbstractEntityService<B, Long, R> implements
		BusinessDescService<B> {

	private static final long serialVersionUID = 2019639925021618876L;

	@Override
	protected B findByEntityName(String entityName) {
		return null;
	}

}
