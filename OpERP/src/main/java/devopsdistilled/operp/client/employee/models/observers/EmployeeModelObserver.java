package devopsdistilled.operp.client.employee.models.observers;

import java.util.List;

import devopsdistilled.operp.client.abstracts.EntityModelObserver;
import devopsdistilled.operp.server.data.entity.employee.Employee;

public interface EmployeeModelObserver extends EntityModelObserver {

	public void updateEmployees(List<Employee> employees);

}
