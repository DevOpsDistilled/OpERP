package devopsdistilled.operp.client.items.panes.models;

import devopsdistilled.operp.client.abstracts.EditEntityPaneModel;
import devopsdistilled.operp.client.items.panes.models.observers.EditManufacturerPaneModelObserver;
import devopsdistilled.operp.server.data.entity.items.Manufacturer;

public interface EditManufacturerPaneModel extends
		EditEntityPaneModel<Manufacturer, EditManufacturerPaneModelObserver> {

}
