package devopsdistilled.operp.client.employee.panes.controllers.impl;

import javax.inject.Inject;
import javax.swing.JPanel;

import devopsdistilled.operp.client.abstracts.EntityOperation;
import devopsdistilled.operp.client.commons.panes.controllers.ContactInfoPaneController;
import devopsdistilled.operp.client.employee.models.EmployeeModel;
import devopsdistilled.operp.client.employee.panes.EmployeePane;
import devopsdistilled.operp.client.employee.panes.controllers.EmployeePaneController;
import devopsdistilled.operp.client.employee.panes.models.EmployeePaneModel;
import devopsdistilled.operp.client.exceptions.EntityValidationException;
import devopsdistilled.operp.server.data.entity.account.PayableAccount;
import devopsdistilled.operp.server.data.entity.commons.ContactInfo;
import devopsdistilled.operp.server.data.entity.employee.Employee;

public class EmployeePaneControllerImpl implements EmployeePaneController {

	@Inject
	private EmployeePane view;

	@Inject
	private EmployeePaneModel model;

	@Inject
	private ContactInfoPaneController contactInfoPaneController;

	@Inject
	private EmployeeModel employeeModel;

	@Override
	public EmployeePaneModel getModel() {
		return model;
	}

	@Override
	public void validate() throws EntityValidationException {
		contactInfoPaneController.validate();
		Employee employee = model.getEntity();

		if (employee.getEmployeeName().equalsIgnoreCase(""))
			throw new EntityValidationException("Employee Name can't be empty");
	}

	@Override
	public Employee save() {
		return employeeModel.saveAndUpdateModel(model.getEntity());
	}

	@Override
	public EmployeePane getView() {
		return view;
	}

	@Override
	public void init(Employee employee, EntityOperation entityOperation) {

		if (EntityOperation.Create == entityOperation) {

			employee.setAccount(new PayableAccount());
			ContactInfo contactInfo = new ContactInfo();
			employee.setContactInfo(contactInfo);
			contactInfoPaneController.init(contactInfo, entityOperation);

		} else if (EntityOperation.Edit == entityOperation) {

			contactInfoPaneController.init(employee.getContactInfo(),
					entityOperation);

		} else if (EntityOperation.Details == entityOperation) {

			contactInfoPaneController.init(employee.getContactInfo(),
					entityOperation);

		}

		view.setContactInfopanel((JPanel) contactInfoPaneController.getView()
				.getPane());
		view.setController(this);
		view.resetComponents();

		model.registerObserver(view);
		model.setEntityAndEntityOperation(employee, entityOperation);

		view.init();
	}

}
