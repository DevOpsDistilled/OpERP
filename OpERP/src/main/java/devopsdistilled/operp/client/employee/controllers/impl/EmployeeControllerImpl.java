package devopsdistilled.operp.client.employee.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.employee.controllers.EmployeeController;
import devopsdistilled.operp.client.employee.models.EmployeeModel;
import devopsdistilled.operp.server.data.entity.employee.Employee;

public class EmployeeControllerImpl implements EmployeeController {

	@Inject
	private EmployeeModel employeeModel;

	@Override
	public void create() {
		// TODO Auto-generated method stub

	}

	@Override
	public void edit(Employee entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void list() {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Employee employee) {
		employeeModel.deleteAndUpdateModel(employee);
	}

	@Override
	public void showDetails(Employee entity) {
		// TODO Auto-generated method stub

	}

}
