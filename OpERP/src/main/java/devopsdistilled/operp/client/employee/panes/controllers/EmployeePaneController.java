package devopsdistilled.operp.client.employee.panes.controllers;

import devopsdistilled.operp.client.abstracts.EntityPaneController;
import devopsdistilled.operp.client.employee.panes.EmployeePane;
import devopsdistilled.operp.client.employee.panes.models.EmployeePaneModel;
import devopsdistilled.operp.server.data.entity.employee.Employee;

public interface EmployeePaneController extends
		EntityPaneController<Employee, EmployeePaneModel, EmployeePane> {

}
