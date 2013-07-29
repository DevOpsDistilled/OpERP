package devopsdistilled.operp.client.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.items.controllers.ItemController;
import devopsdistilled.operp.client.items.controllers.impl.ItemControllerImpl;
import devopsdistilled.operp.client.stock.StockController;
import devopsdistilled.operp.client.stock.StockControllerImpl;

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
	

}


