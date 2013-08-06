package devopsdistilled.operp.client.stock.panes.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.stock.models.ItemWarehouseCatalogModel;
import devopsdistilled.operp.client.stock.panes.ListItemWarehouseCatalogPane;
import devopsdistilled.operp.client.stock.panes.controllers.ListItemWarehouseCatalogPaneController;
import devopsdistilled.operp.client.stock.panes.models.ListItemWarehouseCatalogPaneModel;

public class ListItemWarehouseCatalogPaneControllerImpl 
	implements ListItemWarehouseCatalogPaneController{
	
	@Inject
	private ListItemWarehouseCatalogPane view;
	
	@Inject
	private ListItemWarehouseCatalogPaneModel model;
	
	@Inject
	private ItemWarehouseCatalogModel itemWarehouseCatalogModel;
	@Override
	public void init() {
		view.init();
		model.registerObserver(view);
		itemWarehouseCatalogModel.registerObserver(view);
		
	}

}
