package devopsdistilled.operp.client.employee.models;

import devopsdistilled.operp.client.abstracts.EntityModel;
import devopsdistilled.operp.client.employee.models.observers.EmployeeModelObserver;
import devopsdistilled.operp.server.data.entity.employee.Employee;
import devopsdistilled.operp.server.data.service.employee.EmployeeService;

public interface EmployeeModel extends
		EntityModel<Employee, EmployeeService, EmployeeModelObserver> {

}
