package devopsdistilled.operp.client.items.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.items.controllers.BrandController;
import devopsdistilled.operp.client.items.panes.CreateBrandPane;
import devopsdistilled.operp.server.data.entity.items.Brand;

public class BrandControllerImpl implements BrandController {

	@Inject
	private CreateBrandPane createBrandPane;

	@Override
	public void create() {
		createBrandPane.init();
	}

	@Override
	public void edit(Brand entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void list() {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Brand entity) {
		// TODO Auto-generated method stub

	}

}
