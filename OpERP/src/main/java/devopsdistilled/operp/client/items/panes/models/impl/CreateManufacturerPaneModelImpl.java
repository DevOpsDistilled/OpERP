package devopsdistilled.operp.client.items.panes.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractPaneModel;
import devopsdistilled.operp.client.items.panes.models.CreateManufacturerPaneModel;
import devopsdistilled.operp.client.items.panes.models.observers.CreateManufacturerPaneModelObserver;

public class CreateManufacturerPaneModelImpl extends
		AbstractPaneModel<CreateManufacturerPaneModelObserver> implements
		CreateManufacturerPaneModel {

	@Override
	public String getTitle() {
		return "Create Manufacturer";
	}

}
