package devopsdistilled.operp.client.context.items;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import devopsdistilled.operp.client.items.panes.controllers.CreateBrandPaneController;
import devopsdistilled.operp.client.items.panes.controllers.CreateCategoryPaneController;
import devopsdistilled.operp.client.items.panes.controllers.CreateItemPaneController;
import devopsdistilled.operp.client.items.panes.controllers.CreateManufacturerPaneController;
import devopsdistilled.operp.client.items.panes.controllers.CreateProductPaneController;
import devopsdistilled.operp.client.items.panes.controllers.EditBrandPaneController;
import devopsdistilled.operp.client.items.panes.controllers.EditCategoryPaneController;
import devopsdistilled.operp.client.items.panes.controllers.EditItemPaneController;
import devopsdistilled.operp.client.items.panes.controllers.EditManufacturerPaneController;
import devopsdistilled.operp.client.items.panes.controllers.EditProductPaneController;
import devopsdistilled.operp.client.items.panes.controllers.ListBrandPaneController;
import devopsdistilled.operp.client.items.panes.controllers.ListCategoryPaneController;
import devopsdistilled.operp.client.items.panes.controllers.ListItemPaneController;
import devopsdistilled.operp.client.items.panes.controllers.ListManufacturerPaneController;
import devopsdistilled.operp.client.items.panes.controllers.ListProductPaneController;
import devopsdistilled.operp.client.items.panes.controllers.impl.CreateBrandPaneControllerImpl;
import devopsdistilled.operp.client.items.panes.controllers.impl.CreateCategoryPaneControllerImpl;
import devopsdistilled.operp.client.items.panes.controllers.impl.CreateItemPaneControllerImpl;
import devopsdistilled.operp.client.items.panes.controllers.impl.CreateManufacturerPaneControllerImpl;
import devopsdistilled.operp.client.items.panes.controllers.impl.CreateProductPaneControllerImpl;
import devopsdistilled.operp.client.items.panes.controllers.impl.EditBrandPaneControllerImpl;
import devopsdistilled.operp.client.items.panes.controllers.impl.EditCategoryPaneControllerImpl;
import devopsdistilled.operp.client.items.panes.controllers.impl.EditItemPaneControllerImpl;
import devopsdistilled.operp.client.items.panes.controllers.impl.EditManufacturerPaneControllerImpl;
import devopsdistilled.operp.client.items.panes.controllers.impl.EditProductPaneControllerImpl;
import devopsdistilled.operp.client.items.panes.controllers.impl.ListBrandPaneControllerImpl;
import devopsdistilled.operp.client.items.panes.controllers.impl.ListCategoryPaneControllerImpl;
import devopsdistilled.operp.client.items.panes.controllers.impl.ListItemPaneControllerImpl;
import devopsdistilled.operp.client.stock.panes.controllers.CreateWarehousePaneController;
import devopsdistilled.operp.client.stock.panes.controllers.EditWarehousePaneController;
import devopsdistilled.operp.client.stock.panes.controllers.ListStockPaneController;
import devopsdistilled.operp.client.stock.panes.controllers.ListWarehousePaneController;
import devopsdistilled.operp.client.stock.panes.controllers.UpdateStockPaneController;
import devopsdistilled.operp.client.stock.panes.controllers.impl.CreateWareHousePaneControllerImpl;
import devopsdistilled.operp.client.stock.panes.controllers.impl.EditWarehousePaneControllerImpl;
import devopsdistilled.operp.client.stock.panes.controllers.impl.ListStockPaneControllerImpl;
import devopsdistilled.operp.client.stock.panes.controllers.impl.ListWarehousePaneControllerImpl;
import devopsdistilled.operp.client.stock.panes.controllers.impl.UpdateStockPaneControllerImpl;
import devopsdistilled.operp.client.items.panes.controllers.impl.ListManufacturerPaneControllerImpl;
import devopsdistilled.operp.client.items.panes.controllers.impl.ListProductPaneControllerImpl;

@Configuration
public class MvcControllerContext {

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
	public CreateCategoryPaneController createCategoryPaneController() {
		return new CreateCategoryPaneControllerImpl();
	}

	@Bean
	public EditCategoryPaneController editCategoryPaneController() {
		return new EditCategoryPaneControllerImpl();
	}

	@Bean
	public ListCategoryPaneController listCategoryPaneController() {
		return new ListCategoryPaneControllerImpl();
	}
	
	@Bean
	public ListStockPaneController listStockPaneController(){
		return new ListStockPaneControllerImpl();
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
	public ListWarehousePaneController listWarehousePaneController(){
		return new ListWarehousePaneControllerImpl();
	}
	
	@Bean
	public EditWarehousePaneController editWarehousePaneController(){
		return new EditWarehousePaneControllerImpl();
	}
	
	@Bean
	public CreateProductPaneController createProductPaneController() {
		return new CreateProductPaneControllerImpl();
	}

	@Bean
	public ListProductPaneController listProductPaneController() {
		return new ListProductPaneControllerImpl();
	}

	@Bean
	public EditProductPaneController editProductPaneController() {
		return new EditProductPaneControllerImpl();
	}

	@Bean
	public CreateManufacturerPaneController createManufacturerPaneController() {
		return new CreateManufacturerPaneControllerImpl();
	}

	@Bean
	public ListManufacturerPaneController listManufacturerPaneController() {
		return new ListManufacturerPaneControllerImpl();
	}

	@Bean
	public EditManufacturerPaneController editManufacturerPaneController() {
		return new EditManufacturerPaneControllerImpl();
	}

	@Bean
	public CreateBrandPaneController createBrandPaneController() {
		return new CreateBrandPaneControllerImpl();
	}

	@Bean
	public ListBrandPaneController listBrandPaneController() {
		return new ListBrandPaneControllerImpl();
	}

	@Bean
	public EditBrandPaneController editBrandPaneController() {
		return new EditBrandPaneControllerImpl();
	}
	
}
