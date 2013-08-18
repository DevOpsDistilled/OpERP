package devopsdistilled.operp.client.commons.panes.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.abstracts.EntityOperation;
import devopsdistilled.operp.client.commons.panes.AddressPane;
import devopsdistilled.operp.client.commons.panes.controllers.AddressPaneController;
import devopsdistilled.operp.client.commons.panes.models.AddressPaneModel;
import devopsdistilled.operp.client.exceptions.EntityValidationException;
import devopsdistilled.operp.server.data.entity.commons.Address;

public class AddressPaneControllerImpl implements AddressPaneController {

	@Inject
	private AddressPane view;

	@Inject
	private AddressPaneModel model;

	@Override
	public AddressPane getView() {
		return view;
	}

	@Override
	public AddressPaneModel getModel() {
		return model;
	}

	@Override
	public void validate() throws EntityValidationException {

	}

	@Override
	public Address save() {
		return null;
	}

	@Override
	public void init(Address address, EntityOperation entityOperation) {
		view.setController(this);
		model.registerObserver(view);
		model.setEntityAndEntityOperation(address, entityOperation);
		// view.init(); // Not required as dialog isn't required

	}

}
