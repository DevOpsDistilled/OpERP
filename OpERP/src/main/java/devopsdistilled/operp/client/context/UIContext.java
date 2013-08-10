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
	public StockController stockController() {
		return new StockControllerImpl();
	}

	@Bean
	private StockModel stockModel(){
		return new StockModelImpl();
	}

	@Bean
	public WarehouseController warehouseController(){
		return new WarehouseControllerImpl();
	}
		
	@Bean
	private WarehouseModel warehouseModel(){
		return new WarehouseModelImpl();
	}
	
	
	
}
