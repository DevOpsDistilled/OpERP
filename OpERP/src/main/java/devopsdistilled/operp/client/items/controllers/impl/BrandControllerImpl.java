package devopsdistilled.operp.client.items.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.items.controllers.BrandController;
import devopsdistilled.operp.client.items.models.BrandModel;
import devopsdistilled.operp.client.items.panes.controllers.CreateBrandPaneController;
import devopsdistilled.operp.server.data.entity.items.Brand;

public class BrandControllerImpl implements BrandController {

	@Inject
	private CreateBrandPaneController createBrandPaneController;

	@Inject
	private BrandModel brandModel;

	@Override
	public void create() {
		createBrandPaneController.init();
	}

	@Override
	public void edit(Brand brand) {
		// TODO Auto-generated method stub

	}

	@Override
	public void list() {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Brand brand) {
		brandModel.deleteAndUpdateModel(brand);
	}

}
