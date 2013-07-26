package devopsdistilled.operp.client.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import devopsdistilled.operp.client.items.ItemController;
import devopsdistilled.operp.client.items.ItemControllerImpl;
import devopsdistilled.operp.client.items.controllers.CreateItemPaneController;
import devopsdistilled.operp.client.items.controllers.impl.CreateItemPaneControllerImpl;
import devopsdistilled.operp.client.items.models.BrandModel;
import devopsdistilled.operp.client.items.models.CreateItemPaneModel;
import devopsdistilled.operp.client.items.models.ItemModel;
import devopsdistilled.operp.client.items.models.ProductModel;
import devopsdistilled.operp.client.items.models.impl.BrandModelImpl;
import devopsdistilled.operp.client.items.models.impl.CreateItemPaneModelImpl;
import devopsdistilled.operp.client.items.models.impl.ItemModelImpl;
import devopsdistilled.operp.client.items.models.impl.ProductModelImpl;
import devopsdistilled.operp.client.items.views.CreateItemPane;
import devopsdistilled.operp.client.main.MainModel;
import devopsdistilled.operp.client.main.MainModelImpl;
import devopsdistilled.operp.client.main.MainWindow;
import devopsdistilled.operp.client.main.MainWindowController;
import devopsdistilled.operp.client.main.MainWindowControllerImpl;
import devopsdistilled.operp.client.stock.StockController;
import devopsdistilled.operp.client.stock.StockControllerImpl;
import devopsdistilled.operp.client.stock.controllers.UpdateStockPaneController;
import devopsdistilled.operp.client.stock.controllers.impl.UpdateStockPaneControllerImpl;
import devopsdistilled.operp.client.stock.models.StockModel;
import devopsdistilled.operp.client.stock.models.UpdateStockPaneModel;
import devopsdistilled.operp.client.stock.models.impl.StockModelImpl;
import devopsdistilled.operp.client.stock.models.impl.UpdateStockPanemodelImpl;
import devopsdistilled.operp.client.stock.views.UpdateStockPane;

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
	public UpdateStockPaneModel updateStockPaneModel(){
		return new UpdateStockPanemodelImpl();
	}
	@Bean
	public StockModel stockModel(){
		return new StockModelImpl();
		
	}
	@Bean
	public UpdateStockPane stockPane(){
		return new UpdateStockPane();
	}
	
	@Bean 
	public UpdateStockPaneController updateStockPaneController(){
		return new UpdateStockPaneControllerImpl();
			
	}
	

}
