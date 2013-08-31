package devopsdistilled.operp.server.data.service.business.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import devopsdistilled.operp.client.abstracts.EntityModel;
import devopsdistilled.operp.server.data.entity.business.Business;
import devopsdistilled.operp.server.data.service.business.BusinessService;
import devopsdistilled.operp.server.data.service.impl.AbstractEntityService;

public abstract class BusinessServiceImpl<B extends Business<?, ?>, R extends JpaRepository<B, Long>, BM extends EntityModel<B, ?, ?>>
		extends AbstractEntityService<B, Long, R, BM> implements
		BusinessService<B> {

	private static final long serialVersionUID = 2019639925021618876L;

	@Override
	protected B findByEntityName(String entityName) {
		return null;
	}

}
