package devopsdistilled.operp.client.items.panes.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.items.exceptions.EntityNameExistsException;
import devopsdistilled.operp.client.items.exceptions.NullFieldException;
import devopsdistilled.operp.client.items.models.BrandModel;
import devopsdistilled.operp.client.items.models.ManufacturerModel;
import devopsdistilled.operp.client.items.panes.CreateBrandPane;
import devopsdistilled.operp.client.items.panes.controllers.CreateBrandPaneController;
import devopsdistilled.operp.client.items.panes.models.CreateBrandPaneModel;
import devopsdistilled.operp.server.data.entity.items.Brand;

public class CreateBrandPaneControllerImpl implements CreateBrandPaneController {

	@Inject
	private CreateBrandPane view;

	@Inject
	private CreateBrandPaneModel model;

	@Inject
	private ManufacturerModel manufacturerModel;

	@Inject
	private BrandModel brandModel;

	@Override
	public void init() {
		view.init();
		manufacturerModel.registerObserver(view);
		model.registerObserver(view);
	}

	@Override
	public void validate(Brand brand) throws NullFieldException,
			EntityNameExistsException {

		if (brand.getBrandName().equalsIgnoreCase(""))
			throw new NullFieldException("Brand Name can't be empty");

		if (brand.getManufacturer() == null)
			throw new NullFieldException(
					"Brand must be associated with a manufacturer");

		if (brandModel.getService().isEntityNameExists(brand.getBrandName()))
			throw new EntityNameExistsException("Brand Name already exists");

	}

	@Override
	public Brand save(Brand brand) {
		return brandModel.saveAndUpdateModel(brand);
	}

}
