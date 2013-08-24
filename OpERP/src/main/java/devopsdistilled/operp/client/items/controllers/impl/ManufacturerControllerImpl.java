package devopsdistilled.operp.client.items.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.items.controllers.ManufacturerController;
import devopsdistilled.operp.client.items.models.ManufacturerModel;
import devopsdistilled.operp.client.items.panes.controllers.CreateManufacturerPaneController;
import devopsdistilled.operp.client.items.panes.controllers.EditManufacturerPaneController;
import devopsdistilled.operp.client.items.panes.controllers.ListManufacturerPaneController;
import devopsdistilled.operp.server.data.entity.items.Manufacturer;

public class ManufacturerControllerImpl implements ManufacturerController {

	@Inject
	private CreateManufacturerPaneController createManufacturerPaneController;

	@Inject
	private ListManufacturerPaneController listManufacturerPaneController;

	@Inject
	private EditManufacturerPaneController editManufacturerPaneController;

	@Inject
	private ManufacturerModel manufacturerModel;

	@Override
	public void create() {
		createManufacturerPaneController.init();
	}

	@Override
	public void edit(Manufacturer manufacturer) {
		editManufacturerPaneController.init(manufacturer);
	}

	@Override
	public void list() {
		listManufacturerPaneController.init();
	}

	@Override
	public void delete(Manufacturer manufacturer) {
		manufacturerModel.deleteAndUpdateModel(manufacturer);
	}

	@Override
	public void showDetails(Manufacturer entity) {
		// TODO Auto-generated method stub

	}

}
