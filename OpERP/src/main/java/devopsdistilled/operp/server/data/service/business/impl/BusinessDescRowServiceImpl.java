package devopsdistilled.operp.server.data.service.business.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import devopsdistilled.operp.server.data.entity.business.BusinessDescRow;
import devopsdistilled.operp.server.data.service.business.BusinessDescRowService;
import devopsdistilled.operp.server.data.service.impl.AbstractEntityService;

public abstract class BusinessDescRowServiceImpl<D extends BusinessDescRow<?>, R extends JpaRepository<D, Long>>
		extends AbstractEntityService<D, Long, R> implements
		BusinessDescRowService<D> {

	private static final long serialVersionUID = 2019639925021618876L;

	@Override
	protected D findByEntityName(String entityName) {
		return null;
	}

}
