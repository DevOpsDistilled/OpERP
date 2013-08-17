package devopsdistilled.operp.client.commons.panes.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.commons.panes.CreateAddressPane;
import devopsdistilled.operp.client.commons.panes.controllers.CreateAddressPaneController;
import devopsdistilled.operp.client.commons.panes.models.CreateAddressPaneModel;
import devopsdistilled.operp.client.exceptions.EntityValidationException;
import devopsdistilled.operp.server.data.entity.commons.Address;

public class CreateAddressPaneControllerImpl implements
		CreateAddressPaneController {

	@Inject
	private CreateAddressPane view;

	@Inject
	private CreateAddressPaneModel model;

	@Override
	public CreateAddressPane getView() {
		return view;
	}

	@Override
	public CreateAddressPaneModel getModel() {
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
	public void init() {
		view.setController(this);
		model.registerObserver(view);
	}

}
