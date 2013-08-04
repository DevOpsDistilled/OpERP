package devopsdistilled.operp.client.items.panes.models.impl;

import devopsdistilled.operp.client.abstracts.AbstractPaneModel;
import devopsdistilled.operp.client.items.panes.models.ListManufacturerPaneModel;
import devopsdistilled.operp.client.items.panes.models.observers.ListManufacturerPaneModelObserver;

public class ListManufacturerPaneModelImpl extends
		AbstractPaneModel<ListManufacturerPaneModelObserver> implements
		ListManufacturerPaneModel {

	@Override
	public String getTitle() {
		return "Manufacturers List";
	}

}
