package devopsdistilled.operp.client.employee.models.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.abstracts.AbstractEntityModel;
import devopsdistilled.operp.client.employee.models.EmployeeModel;
import devopsdistilled.operp.client.employee.models.observers.EmployeeModelObserver;
import devopsdistilled.operp.server.data.entity.employee.Employee;
import devopsdistilled.operp.server.data.service.employee.EmployeeService;

public class EmployeeModelImpl extends
		AbstractEntityModel<Employee, EmployeeService, EmployeeModelObserver>
		implements EmployeeModel {

	@Inject
	private EmployeeService service;

	@Override
	public EmployeeService getService() {
		return service;
	}

}
