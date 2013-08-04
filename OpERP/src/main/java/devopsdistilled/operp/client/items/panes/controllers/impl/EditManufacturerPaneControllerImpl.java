package devopsdistilled.operp.client.items.panes.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.items.exceptions.EntityNameExistsException;
import devopsdistilled.operp.client.items.exceptions.NullFieldException;
import devopsdistilled.operp.client.items.panes.EditManufacturerPane;
import devopsdistilled.operp.client.items.panes.controllers.EditManufacturerPaneController;
import devopsdistilled.operp.client.items.panes.models.EditManufacturerPaneModel;
import devopsdistilled.operp.server.data.entity.items.Manufacturer;

public class EditManufacturerPaneControllerImpl implements
		EditManufacturerPaneController {

	@Inject
	private EditManufacturerPane view;

	@Inject
	private EditManufacturerPaneModel model;

	@Override
	public void init(Manufacturer manufacturer) {
		view.init();
		// other model.registerObserver() here
		model.setEntity(manufacturer);
		model.registerObserver(view);
	}

	@Override
	public void validate(Manufacturer entity) throws NullFieldException,
			EntityNameExistsException {
		// TODO Auto-generated method stub

	}

	@Override
	public Manufacturer save(Manufacturer manufacturer) {
		// TODO Auto-generated method stub
		return null;
	}

}
