package devopsdistilled.operp.client.employee.panes.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractPaneModel;
import devopsdistilled.operp.client.employee.panes.models.ListEmployeePaneModel;
import devopsdistilled.operp.client.employee.panes.models.observers.ListEmployeePaneModelObserver;

public class ListEmployeePaneModelImpl extends
		AbstractPaneModel<ListEmployeePaneModelObserver> implements
		ListEmployeePaneModel {

	@Override
	public String getTitle() {
		return "Employee List";
	}

}
