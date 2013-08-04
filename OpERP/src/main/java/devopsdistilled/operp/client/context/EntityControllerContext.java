package devopsdistilled.operp.client.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.items.controllers.CategoryController;
import devopsdistilled.operp.client.items.controllers.ItemController;
import devopsdistilled.operp.client.items.controllers.ProductController;
import devopsdistilled.operp.client.items.controllers.impl.CategoryControllerImpl;
import devopsdistilled.operp.client.items.controllers.impl.ItemControllerImpl;

import devopsdistilled.operp.client.stock.controllers.StockController;
import devopsdistilled.operp.client.stock.controllers.WarehouseController;
import devopsdistilled.operp.client.stock.controllers.impl.StockControllerImpl;
import devopsdistilled.operp.client.stock.controllers.impl.WarehouseControllerImpl;
import devopsdistilled.operp.client.items.controllers.impl.ProductControllerImpl;

@Configuration
public class EntityControllerContext {

	@Bean
	public ItemController itemController() {
		return new ItemControllerImpl();
	}
	@Bean
	public StockController stockController(){
		return new StockControllerImpl();
	}
	
	@Bean
	public WarehouseController warehouseController(){
		return new WarehouseControllerImpl();
	}
	@Bean
	public CategoryController categoryController() {
		return new CategoryControllerImpl();
	}

	@Bean
	public ProductController productController() {
		return new ProductControllerImpl();
	}
}


