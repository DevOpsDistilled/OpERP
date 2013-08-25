package devopsdistilled.operp.client.employee.panes.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.employee.models.EmployeeModel;
import devopsdistilled.operp.client.employee.panes.ListEmployeePane;
import devopsdistilled.operp.client.employee.panes.controllers.ListEmployeePaneController;
import devopsdistilled.operp.client.employee.panes.models.ListEmployeePaneModel;

public class ListEmployeePaneControllerImpl implements
		ListEmployeePaneController {

	@Inject
	private ListEmployeePane view;

	@Inject
	private ListEmployeePaneModel model;

	@Inject
	private EmployeeModel employeeModel;

	@Override
	public void init() {
		view.init();
		model.registerObserver(view);
		employeeModel.registerObserver(view);
	}

}
