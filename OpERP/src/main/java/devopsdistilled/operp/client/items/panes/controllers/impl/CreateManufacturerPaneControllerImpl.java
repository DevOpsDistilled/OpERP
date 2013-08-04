package devopsdistilled.operp.client.items.panes.controllers.impl;

import devopsdistilled.operp.client.items.exceptions.EntityNameExistsException;
import devopsdistilled.operp.client.items.exceptions.NullFieldException;
import devopsdistilled.operp.client.items.panes.controllers.CreateManufacturerPaneController;
import devopsdistilled.operp.server.data.entity.items.Manufacturer;

public class CreateManufacturerPaneControllerImpl implements
		CreateManufacturerPaneController {

	@Override
	public void validate(Manufacturer entity) throws NullFieldException,
			EntityNameExistsException {
		// TODO Auto-generated method stub

	}

	@Override
	public Manufacturer save(Manufacturer entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

}
