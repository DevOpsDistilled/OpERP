package devopsdistilled.operp.client.stock.controllers.impl;

import javax.inject.Inject;

import org.springframework.context.ApplicationContext;

import devopsdistilled.operp.client.stock.controllers.ItemWarehouseCatalogController;
import devopsdistilled.operp.client.stock.models.ItemWarehouseCatalogModel;
import devopsdistilled.operp.client.stock.panes.ListItemWarehouseCatalogPane;
import devopsdistilled.operp.client.stock.panes.controllers.ListItemWarehouseCatalogPaneController;
import devopsdistilled.operp.server.data.entity.stock.ItemWarehouseCatalog;

public class ItemWarehouseCatalogControllerImpl implements 
		ItemWarehouseCatalogController {

	@Inject
	private ApplicationContext context;
	
	@Inject
	private ItemWarehouseCatalogModel itemWarehouseCatalogModel;
	@Override
	
	public void create() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void edit(ItemWarehouseCatalog entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void list() {
		ListItemWarehouseCatalogPaneController listItemWarehouseCatalogPaneController=context.
				getBean(ListItemWarehouseCatalogPaneController.class);
		listItemWarehouseCatalogPaneController.init();
	}

	@Override
	public void delete(ItemWarehouseCatalog entity) {
		// TODO Auto-generated method stub
		
	}

}
