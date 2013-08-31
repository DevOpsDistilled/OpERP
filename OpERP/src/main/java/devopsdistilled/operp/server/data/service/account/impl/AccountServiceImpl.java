package devopsdistilled.operp.server.data.service.account.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import devopsdistilled.operp.client.abstracts.EntityModel;
import devopsdistilled.operp.server.data.entity.account.Account;
import devopsdistilled.operp.server.data.service.impl.AbstractEntityService;

public abstract class AccountServiceImpl<A extends Account<?>, AR extends JpaRepository<A, Long>, AM extends EntityModel<A, ?, ?>>
		extends AbstractEntityService<A, Long, AR, AM> {

	private static final long serialVersionUID = 8694809412525181588L;

	@Override
	protected A findByEntityName(String entityName) {
		return null;
	}

}
