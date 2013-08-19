package devopsdistilled.operp.client.party.panes.controllers.impl;

import javax.inject.Inject;
import javax.swing.JPanel;

import devopsdistilled.operp.client.abstracts.EntityOperation;
import devopsdistilled.operp.client.commons.panes.controllers.ContactInfoPaneController;
import devopsdistilled.operp.client.exceptions.EntityValidationException;
import devopsdistilled.operp.client.party.models.CustomerModel;
import devopsdistilled.operp.client.party.panes.CustomerPane;
import devopsdistilled.operp.client.party.panes.controllers.CustomerPaneController;
import devopsdistilled.operp.client.party.panes.models.CustomerPaneModel;
import devopsdistilled.operp.server.data.entity.account.ReceivableAccount;
import devopsdistilled.operp.server.data.entity.commons.ContactInfo;
import devopsdistilled.operp.server.data.entity.party.Customer;

public class CustomerPaneControllerImpl implements CustomerPaneController {

	@Inject
	private CustomerPane view;

	@Inject
	private CustomerPaneModel model;

	@Inject
	private ContactInfoPaneController contactInfoPaneController;

	@Inject
	private CustomerModel customerModel;

	@Override
	public CustomerPaneModel getModel() {
		return model;
	}

	@Override
	public void validate() throws EntityValidationException {
		contactInfoPaneController.validate();
		Customer customer = model.getEntity();

		if (customer.getPartyName().equalsIgnoreCase(""))
			throw new EntityValidationException("Customer Name can't be empty");
	}

	@Override
	public Customer save() {
		return customerModel.saveAndUpdateModel(model.getEntity());
	}

	@Override
	public CustomerPane getView() {
		return view;
	}

	@Override
	public void init(Customer customer, EntityOperation entityOperation) {

		if (EntityOperation.Create == entityOperation) {

			customer.setAccount(new ReceivableAccount());
			ContactInfo contactInfo = new ContactInfo();
			customer.setContactInfo(contactInfo);
			contactInfoPaneController.init(contactInfo, entityOperation);

		} else if (EntityOperation.Edit == entityOperation) {

			contactInfoPaneController.init(customer.getContactInfo(),
					entityOperation);

		} else if (EntityOperation.Details == entityOperation) {

			contactInfoPaneController.init(customer.getContactInfo(),
					entityOperation);

		}

		view.setContactInfopanel((JPanel) contactInfoPaneController.getView()
				.getPane());
		view.setController(this);
		view.resetComponents();

		model.registerObserver(view);
		model.setEntityAndEntityOperation(customer, entityOperation);

		view.init();
	}

}
