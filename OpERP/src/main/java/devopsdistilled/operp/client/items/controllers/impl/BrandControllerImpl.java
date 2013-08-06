package devopsdistilled.operp.client.items.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.items.controllers.BrandController;
import devopsdistilled.operp.client.items.models.BrandModel;
import devopsdistilled.operp.client.items.panes.controllers.CreateBrandPaneController;
import devopsdistilled.operp.client.items.panes.controllers.EditBrandPaneController;
import devopsdistilled.operp.client.items.panes.controllers.ListBrandPaneController;
import devopsdistilled.operp.server.data.entity.items.Brand;

public class BrandControllerImpl implements BrandController {

	@Inject
	private CreateBrandPaneController createBrandPaneController;

	@Inject
	private ListBrandPaneController listBrandPaneController;

	@Inject
	private EditBrandPaneController editBrandPaneController;

	@Inject
	private BrandModel brandModel;

	@Override
	public void create() {
		createBrandPaneController.init();
	}

	@Override
	public void edit(Brand brand) {
		editBrandPaneController.init(brand);
	}

	@Override
	public void list() {
		listBrandPaneController.init();
	}

	@Override
	public void delete(Brand brand) {
		brandModel.deleteAndUpdateModel(brand);
	}

}
