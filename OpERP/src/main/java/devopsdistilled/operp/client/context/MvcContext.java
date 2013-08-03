package devopsdistilled.operp.client.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.items.panes.CreateCategoryPane;
import devopsdistilled.operp.client.items.panes.CreateItemPane;
import devopsdistilled.operp.client.items.panes.EditItemPane;
import devopsdistilled.operp.client.items.panes.ListItemPane;
import devopsdistilled.operp.client.items.panes.controllers.CreateCategoryPaneController;
import devopsdistilled.operp.client.items.panes.controllers.CreateItemPaneController;
import devopsdistilled.operp.client.items.panes.controllers.EditItemPaneController;
import devopsdistilled.operp.client.items.panes.controllers.ListItemPaneController;
import devopsdistilled.operp.client.items.panes.controllers.impl.CreateCategoryPaneControllerImpl;
import devopsdistilled.operp.client.items.panes.controllers.impl.CreateItemPaneControllerImpl;
import devopsdistilled.operp.client.items.panes.controllers.impl.EditItemPaneControllerImpl;
import devopsdistilled.operp.client.items.panes.controllers.impl.ListItemPaneControllerImpl;
import devopsdistilled.operp.client.stock.panes.CreateWarehousePane;
import devopsdistilled.operp.client.stock.panes.ListWarehousePane;
import devopsdistilled.operp.client.stock.panes.UpdateStockPane;
import devopsdistilled.operp.client.stock.panes.controllers.CreateWarehousePaneController;
import devopsdistilled.operp.client.stock.panes.controllers.ListWarehousePaneController;
import devopsdistilled.operp.client.stock.panes.controllers.UpdateStockPaneController;
import devopsdistilled.operp.client.stock.panes.controllers.impl.CreateWareHousePaneControllerImpl;
import devopsdistilled.operp.client.stock.panes.controllers.impl.ListWarehousePaneControllerImpl;
import devopsdistilled.operp.client.stock.panes.controllers.impl.UpdateStockPaneControllerImpl;
import devopsdistilled.operp.client.stock.panes.models.CreateWarehousePaneModel;
import devopsdistilled.operp.client.stock.panes.models.ListWarehousePaneModel;
import devopsdistilled.operp.client.stock.panes.models.UpdateStockPaneModel;
import devopsdistilled.operp.client.stock.panes.models.impl.CreateWarehousePaneModelImpl;
import devopsdistilled.operp.client.stock.panes.models.impl.ListWarehousePaneModelImpl;
import devopsdistilled.operp.client.stock.panes.models.impl.UpdateStockPaneModelImpl;
import devopsdistilled.operp.client.items.panes.models.CreateCategoryPaneModel;
import devopsdistilled.operp.client.items.panes.models.CreateItemPaneModel;
import devopsdistilled.operp.client.items.panes.models.EditItemPaneModel;
import devopsdistilled.operp.client.items.panes.models.ListItemPaneModel;
import devopsdistilled.operp.client.items.panes.models.impl.CreateCategoryPaneModelImpl;
import devopsdistilled.operp.client.items.panes.models.impl.CreateItemPaneModelImpl;
import devopsdistilled.operp.client.items.panes.models.impl.EditItemPaneModelImpl;
import devopsdistilled.operp.client.items.panes.models.impl.ListItemPaneModelImpl;

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
	public CreateCategoryPaneModel createCategoryPaneModel() {
		return new CreateCategoryPaneModelImpl();
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
	public ListWarehousePaneModel listWarehousePaneModel(){
		return new ListWarehousePaneModelImpl();
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
	public CreateCategoryPane createCategoryPane() {
		return new CreateCategoryPane();
	}
	
	@Bean
	public ListWarehousePane listWarehousePane(){
		return new ListWarehousePane();
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
	@Bean
	public CreateCategoryPaneController createCategoryPaneController() {
		return new CreateCategoryPaneControllerImpl();
	}
	@Bean
	public ListWarehousePaneController listWarehousePaneController(){
		return new ListWarehousePaneControllerImpl();
	}
}
