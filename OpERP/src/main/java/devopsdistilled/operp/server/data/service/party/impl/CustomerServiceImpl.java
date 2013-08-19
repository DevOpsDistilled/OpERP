package devopsdistilled.operp.server.data.service.party.impl;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import devopsdistilled.operp.server.data.entity.party.Customer;
import devopsdistilled.operp.server.data.repo.party.CustomerRepository;
import devopsdistilled.operp.server.data.service.impl.AbstractEntityService;
import devopsdistilled.operp.server.data.service.party.CustomerService;

@Service
public class CustomerServiceImpl extends
		AbstractEntityService<Customer, Long, CustomerRepository> implements
		CustomerService {

	private static final long serialVersionUID = 7983273640225740161L;

	@Inject
	private CustomerRepository repo;

	@Override
	protected CustomerRepository getRepo() {
		return repo;
	}

	@Override
	protected Customer findByEntityName(String entityName) {
		return null;
	}

	@Override
	public <S extends Customer> S save(S entity) {
		entity.setRegisteredDate(new Date());
		return super.save(entity);
	}

}