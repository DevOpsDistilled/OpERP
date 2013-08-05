package devopsdistilled.operp.client.items.panes.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.items.exceptions.EntityNameExistsException;
import devopsdistilled.operp.client.items.exceptions.NullFieldException;
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

	@Override
	public void init(Brand brand) {
		view.init();
		manufacturerModel.registerObserver(view);
		model.setEntity(brand);
		model.registerObserver(view);
	}

	@Override
	public void validate(Brand entity) throws NullFieldException,
			EntityNameExistsException {
		// TODO Auto-generated method stub

	}

	@Override
	public Brand save(Brand entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
