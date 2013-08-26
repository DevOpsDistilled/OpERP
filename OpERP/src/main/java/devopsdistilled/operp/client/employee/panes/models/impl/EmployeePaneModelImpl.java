package devopsdistilled.operp.client.employee.panes.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractEntityPaneModel;
import devopsdistilled.operp.client.employee.panes.models.EmployeePaneModel;
import devopsdistilled.operp.client.employee.panes.models.observers.EmployeePaneModelObserver;
import devopsdistilled.operp.server.data.entity.employee.Employee;

public class EmployeePaneModelImpl extends
		AbstractEntityPaneModel<Employee, EmployeePaneModelObserver> implements
		EmployeePaneModel {

	@Override
	public String getTitle() {
		return "Employee";
	}

}
