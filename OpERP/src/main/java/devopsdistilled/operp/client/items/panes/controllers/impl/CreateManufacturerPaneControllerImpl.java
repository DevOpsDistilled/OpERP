package devopsdistilled.operp.client.items.panes.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.exceptions.NullFieldException;
import devopsdistilled.operp.client.items.exceptions.EntityNameExistsException;
import devopsdistilled.operp.client.items.models.ManufacturerModel;
import devopsdistilled.operp.client.items.panes.CreateManufacturerPane;
import devopsdistilled.operp.client.items.panes.controllers.CreateManufacturerPaneController;
import devopsdistilled.operp.client.items.panes.models.CreateManufacturerPaneModel;
import devopsdistilled.operp.server.data.entity.items.Manufacturer;

public class CreateManufacturerPaneControllerImpl implements
		CreateManufacturerPaneController {

	@Inject
	private CreateManufacturerPane view;

	@Inject
	private CreateManufacturerPaneModel model;

	@Inject
	private ManufacturerModel manufacturerModel;

	@Override
	public void validate(Manufacturer manufacturer) throws NullFieldException,
			EntityNameExistsException {

		if (manufacturer.getManufacturerName().equalsIgnoreCase(""))
			throw new NullFieldException("Manufacturer Name can't be empty");

		if (manufacturerModel.getService().isManufacturerNameExists(
				manufacturer.getManufacturerName()))
			throw new EntityNameExistsException(
					"Manufacturer Name already exists");
	}

	@Override
	public Manufacturer save(Manufacturer manufacturer) {
		return manufacturerModel.saveAndUpdateModel(manufacturer);
	}

	@Override
	public void init() {
		view.init();
		model.registerObserver(view);
	}

}
