package devopsdistilled.operp.server.data.service.hr.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import devopsdistilled.operp.server.data.entity.hr.Employee;
import devopsdistilled.operp.server.data.repo.hr.EmployeeRepository;
import devopsdistilled.operp.server.data.service.hr.EmployeeService;
import devopsdistilled.operp.server.data.service.impl.AbstractEntityService;

@Service
public class EmployeeServiceImpl extends
		AbstractEntityService<Employee, Long, EmployeeRepository> implements
		EmployeeService {

	private static final long serialVersionUID = 2648525777561781085L;

	@Inject
	private EmployeeRepository repo;

	@Override
	protected EmployeeRepository getRepo() {
		return repo;
	}

	@Override
	protected Employee findByEntityName(String entityName) {
		return null;
	}

}
