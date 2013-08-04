package devopsdistilled.operp.client.items.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.items.controllers.ManufacturerController;
import devopsdistilled.operp.client.items.panes.controllers.CreateManufacturerPaneController;
import devopsdistilled.operp.server.data.entity.items.Manufacturer;

public class ManufacturerControllerImpl implements ManufacturerController {

	@Inject
	private CreateManufacturerPaneController createManufacturerPaneController;

	@Override
	public void create() {
		createManufacturerPaneController.init();
	}

	@Override
	public void edit(Manufacturer entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void list() {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Manufacturer entity) {
		// TODO Auto-generated method stub

	}

}
