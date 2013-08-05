package devopsdistilled.operp.client.items.panes.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.items.exceptions.EntityNameExistsException;
import devopsdistilled.operp.client.items.exceptions.NullFieldException;
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

	@Override
	public void init() {
		view.init();
		manufacturerModel.registerObserver(view);
		model.registerObserver(view);
	}

	@Override
	public void validate(Brand brand) throws NullFieldException,
			EntityNameExistsException {

	}

	@Override
	public Brand save(Brand brand) {
		// TODO Auto-generated method stub
		return null;
	}

}
