package devopsdistilled.operp.client.context.stock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.stock.controllers.StockController;
import devopsdistilled.operp.client.stock.controllers.WarehouseController;
import devopsdistilled.operp.client.stock.controllers.impl.StockControllerImpl;
import devopsdistilled.operp.client.stock.controllers.impl.WarehouseControllerImpl;

@Configuration
public class EntityControllerContext {

	@Bean
	public StockController stockController() {
		return new StockControllerImpl();
	}

	@Bean
	public WarehouseController warehouseController() {
		return new WarehouseControllerImpl();
	}

}
