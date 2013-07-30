package devopsdistilled.operp.client.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import devopsdistilled.operp.client.items.controllers.ItemController;
import devopsdistilled.operp.client.items.controllers.impl.ItemControllerImpl;
import devopsdistilled.operp.client.items.models.BrandModel;
import devopsdistilled.operp.client.items.models.ItemModel;
import devopsdistilled.operp.client.items.models.ProductModel;
import devopsdistilled.operp.client.items.models.impl.BrandModelImpl;
import devopsdistilled.operp.client.items.models.impl.ItemModelImpl;
import devopsdistilled.operp.client.items.models.impl.ProductModelImpl;
import devopsdistilled.operp.client.items.panes.CreateItemPane;
import devopsdistilled.operp.client.items.panes.controllers.CreateItemPaneController;
import devopsdistilled.operp.client.items.panes.controllers.impl.CreateItemPaneControllerImpl;
import devopsdistilled.operp.client.items.panes.model.CreateItemPaneModel;
import devopsdistilled.operp.client.items.panes.model.impl.CreateItemPaneModelImpl;
import devopsdistilled.operp.client.main.MainModel;
import devopsdistilled.operp.client.main.MainModelImpl;
import devopsdistilled.operp.client.main.MainWindow;
import devopsdistilled.operp.client.main.MainWindowController;
import devopsdistilled.operp.client.main.MainWindowControllerImpl;
import devopsdistilled.operp.client.stock.controllers.StockController;
import devopsdistilled.operp.client.stock.controllers.WarehouseController;
import devopsdistilled.operp.client.stock.controllers.impl.StockControllerImpl;
import devopsdistilled.operp.client.stock.controllers.impl.WarehouseControllerImpl;
import devopsdistilled.operp.client.stock.models.StockModel;
import devopsdistilled.operp.client.stock.models.WarehouseModel;
import devopsdistilled.operp.client.stock.models.impl.StockModelImpl;
import devopsdistilled.operp.client.stock.models.impl.WarehouseModelImpl;
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
@Import({ NavigationContext.class })
public class UIContext {

	@Bean
	public MainWindowController mainWindowController() {
		return new MainWindowControllerImpl();
	}

	@Bean
	public MainModel mainModel() {
		return new MainModelImpl();
	}

	@Bean
	public MainWindow mainWindow() {
		MainWindow window = MainWindow.getInstance();
		return window;
	}

	@Bean
	public ItemController itemController() {
		return new ItemControllerImpl();
	}

	@Bean
	public CreateItemPaneModel createItemPaneModel() {
		return new CreateItemPaneModelImpl();
	}

	@Bean
	public ItemModel itemModel() {
		return new ItemModelImpl();
	}

	@Bean
	public ProductModel productModel() {
		return new ProductModelImpl();
	}

	@Bean
	public BrandModel brandModel() {
		return new BrandModelImpl();
	}

	@Bean
	public CreateItemPane createItemPane() {
		return new CreateItemPane();
	}

	@Bean
	public CreateItemPaneController createItemPaneController() {
		return new CreateItemPaneControllerImpl();
	}

	@Bean
	public StockController stockController() {
		return new StockControllerImpl();
	}

	@Bean
	public UpdateStockPaneModel updateStockPaneModel() {
		return new UpdateStockPaneModelImpl();
	}

	@Bean
	private StockModel stockModel(){
		return new StockModelImpl();
	}
	
	@Bean
	public UpdateStockPane updateStockPane() {
		return new UpdateStockPane();
	}

	@Bean
	public UpdateStockPaneController updateStockPaneController() {
		return new UpdateStockPaneControllerImpl();
	}

	@Bean
	public WarehouseController warehouseController(){
		return new WarehouseControllerImpl();
	}
	
	@Bean
	public CreateWarehousePaneModel createWarehousePaneModel(){
		return new CreateWarehousePaneModelImpl();
	}
	
	@Bean
	private WarehouseModel warehouseModel(){
		return new WarehouseModelImpl();
	}
	
	@Bean
	public CreateWarehousePane wareHousePane() {
		return new CreateWarehousePane();
	}

	@Bean
	public CreateWarehousePaneController createWarehousePaneController(){
		return new CreateWareHousePaneControllerImpl();
	}
}
