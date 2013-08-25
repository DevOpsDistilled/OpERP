package devopsdistilled.operp.client.employee.panes.models;

import devopsdistilled.operp.client.abstracts.EntityPaneModel;
import devopsdistilled.operp.client.employee.panes.models.observers.EmployeePaneModelObserver;
import devopsdistilled.operp.server.data.entity.employee.Employee;

public interface EmployeePaneModel extends
		EntityPaneModel<Employee, EmployeePaneModelObserver> {

}
