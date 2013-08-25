package devopsdistilled.operp.server.data.service.employee.impl;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import devopsdistilled.operp.server.data.entity.employee.Employee;
import devopsdistilled.operp.server.data.repo.employee.EmployeeRepository;
import devopsdistilled.operp.server.data.service.employee.EmployeeService;
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

	@Override
	public <S extends Employee> S save(S employee) {
		if (employee.getJoinedDate() == null)
			employee.setJoinedDate(new Date());
		return super.save(employee);
	}
}
