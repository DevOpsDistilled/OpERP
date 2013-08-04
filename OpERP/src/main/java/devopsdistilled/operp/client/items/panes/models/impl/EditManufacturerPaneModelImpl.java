package devopsdistilled.operp.client.items.panes.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractEditEntityPaneModel;
import devopsdistilled.operp.client.items.panes.models.EditManufacturerPaneModel;
import devopsdistilled.operp.client.items.panes.models.observers.EditManufacturerPaneModelObserver;
import devopsdistilled.operp.server.data.entity.items.Manufacturer;

public class EditManufacturerPaneModelImpl
		extends
		AbstractEditEntityPaneModel<Manufacturer, EditManufacturerPaneModelObserver>
		implements EditManufacturerPaneModel {

	@Override
	public String getTitle() {
		return "Edit Manufacturer";
	}

}
