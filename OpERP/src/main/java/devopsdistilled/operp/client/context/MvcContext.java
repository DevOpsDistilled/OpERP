package devopsdistilled.operp.client.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.items.panes.CreateItemPane;
import devopsdistilled.operp.client.items.panes.EditItemPane;
import devopsdistilled.operp.client.items.panes.ListItemPane;
import devopsdistilled.operp.client.items.panes.controllers.CreateItemPaneController;
import devopsdistilled.operp.client.items.panes.controllers.EditItemPaneController;
import devopsdistilled.operp.client.items.panes.controllers.ListItemPaneController;
import devopsdistilled.operp.client.items.panes.controllers.impl.CreateItemPaneControllerImpl;
import devopsdistilled.operp.client.items.panes.controllers.impl.EditItemPaneControllerImpl;
import devopsdistilled.operp.client.items.panes.controllers.impl.ListItemPaneControllerImpl;
import devopsdistilled.operp.client.items.panes.model.CreateItemPaneModel;
import devopsdistilled.operp.client.items.panes.model.EditItemPaneModel;
import devopsdistilled.operp.client.items.panes.model.ListItemPaneModel;
import devopsdistilled.operp.client.items.panes.model.impl.CreateItemPaneModelImpl;
import devopsdistilled.operp.client.items.panes.model.impl.EditItemPaneModelImpl;
import devopsdistilled.operp.client.items.panes.model.impl.ListItemPaneModelImpl;
import devopsdistilled.operp.client.stock.panes.CreateWarehousePane;
import devopsdistilled.operp.client.stock.panes.UpdateStockPane;
import devopsdistilled.operp.client.stock.panes.controllers.CreateWarehousePaneController;
import devopsdistilled.operp.client.stock.panes.controllers.UpdateStockPaneController;
import devopsdistilled.operp.client.stock.panes.controllers.impl.CreateWareHousePaneControllerImpl;
import devopsdistilled.operp.client.stock.panes.controllers.impl.UpdateStockPaneControllerImpl;
import devopsdistilled.operp.client.stock.panes.models.CreateWarehousePaneModel;
import devopsdistilled.operp.client.stock.panes.models.UpdateStockPaneModel;
import devopsdistilled.operp.client.stock.panes.models.impl.CreateWarehousePaneModelImpl;
import devopsdistilled.operp.client.stock.panes.models.impl.UpdateStockPaneModelImpl;

@Configuration
public class MvcContext {
	@Bean
	public CreateItemPaneModel createItemPaneModel() {
		return new CreateItemPaneModelImpl();
	}

	@Bean
	public ListItemPaneModel listItemPaneModel() {
		return new ListItemPaneModelImpl();
	}

	@Bean
	public EditItemPaneModel editItemPaneModel() {
		return new EditItemPaneModelImpl();
	}

	@Bean 
	public UpdateStockPaneModel updateStockPaneModel(){
		return new UpdateStockPaneModelImpl();
	}
	
	@Bean 
	public CreateWarehousePaneModel createWarehousePaneModel(){
		return new CreateWarehousePaneModelImpl();
	}
	
	@Bean
	public CreateItemPane createItemPane() {
		return new CreateItemPane();
	}

	@Bean
	public ListItemPane listItemPane() {
		return new ListItemPane();
	}

	@Bean
	public EditItemPane editItemPane() {
		return new EditItemPane();
	}
	
	@Bean
	public UpdateStockPane updateStockpane(){
		return new UpdateStockPane();
	}
	
	@Bean
	public CreateWarehousePane createWarehousePane(){
		return new CreateWarehousePane();
	}
	
	@Bean
	public CreateItemPaneController createItemPaneController() {
		return new CreateItemPaneControllerImpl();
	}

	@Bean
	public ListItemPaneController listItemPaneController() {
		return new ListItemPaneControllerImpl();
	}

	@Bean
	public EditItemPaneController editItemPaneController() {
		return new EditItemPaneControllerImpl();
	}
	
	@Bean
	public UpdateStockPaneController updateStockPaneController(){
		return new UpdateStockPaneControllerImpl();
	}
	
	@Bean
	public CreateWarehousePaneController createWarehousePaneController(){
		return new CreateWareHousePaneControllerImpl();
	}
}
