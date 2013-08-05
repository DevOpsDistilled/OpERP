package devopsdistilled.operp.client.items.panes.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.exceptions.NullFieldException;
import devopsdistilled.operp.client.items.exceptions.EntityNameExistsException;
import devopsdistilled.operp.client.items.models.ManufacturerModel;
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

	@Inject
	private ManufacturerModel manufacturerModel;

	@Override
	public void init(Manufacturer manufacturer) {
		view.init();
		// other model.registerObserver() here
		model.setEntity(manufacturer);
		model.registerObserver(view);
	}

	@Override
	public void validate(Manufacturer manufacturer) throws NullFieldException,
			EntityNameExistsException {

		if (manufacturer.getManufacturerName().equalsIgnoreCase(""))
			throw new NullFieldException("Manufacturer Name can't be empty");

		if (!manufacturerModel.getService().isEntityNameValidForTheEntity(
				manufacturer.getManufacturerId(),
				manufacturer.getManufacturerName())) {
			throw new EntityNameExistsException(
					"Manufacturer Name already exists");
		}
	}

	@Override
	public Manufacturer save(Manufacturer manufacturer) {
		return manufacturerModel.saveAndUpdateModel(manufacturer);
	}

}
