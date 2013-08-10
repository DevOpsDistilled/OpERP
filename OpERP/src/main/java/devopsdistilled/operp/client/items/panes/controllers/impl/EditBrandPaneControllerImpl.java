package devopsdistilled.operp.client.items.panes.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.exceptions.NullFieldException;
import devopsdistilled.operp.client.items.exceptions.EntityNameExistsException;
import devopsdistilled.operp.client.items.models.BrandModel;
import devopsdistilled.operp.client.items.models.ManufacturerModel;
import devopsdistilled.operp.client.items.panes.EditBrandPane;
import devopsdistilled.operp.client.items.panes.controllers.EditBrandPaneController;
import devopsdistilled.operp.client.items.panes.models.EditBrandPaneModel;
import devopsdistilled.operp.server.data.entity.items.Brand;

public class EditBrandPaneControllerImpl implements EditBrandPaneController {

	@Inject
	private EditBrandPane view;

	@Inject
	private EditBrandPaneModel model;

	@Inject
	private ManufacturerModel manufacturerModel;

	@Inject
	private BrandModel brandModel;

	@Override
	public void init(Brand brand) {
		view.init();
		manufacturerModel.registerObserver(view);
		model.setEntity(brand);
		model.registerObserver(view);
	}

	@Override
	public void validate(Brand brand) throws NullFieldException,
			EntityNameExistsException {

		if (brand.getBrandID() == null)
			throw new NullFieldException("Brand ID not specified");

		if (brand.getBrandName().equalsIgnoreCase(""))
			throw new NullFieldException("Brand Name can't be empty");

		if (brand.getManufacturer() == null)
			throw new NullFieldException("Manufacturer should be specified");

		if (!brandModel.getService().isEntityNameValidForTheEntity(
				brand.getBrandID(), brand.getBrandName()))
			throw new EntityNameExistsException("Brand Name already exists");
	}

	@Override
	public Brand save(Brand brand) {
		return brandModel.saveAndUpdateModel(brand);
	}

}
