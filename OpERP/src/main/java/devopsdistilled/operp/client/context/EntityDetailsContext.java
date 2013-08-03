package devopsdistilled.operp.client.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.items.panes.CategoryDetailsPane;
import devopsdistilled.operp.client.items.panes.ItemDetailsPane;
import devopsdistilled.operp.client.stock.panes.WarehouseDetailsPane;

@Configuration
public class EntityDetailsContext {

	@Bean
	public ItemDetailsPane itemDetailsPane() {
		return new ItemDetailsPane();
	}

	@Bean
	public CategoryDetailsPane categoryDetailsPane() {
		return new CategoryDetailsPane();
	}
	
	@Bean
	public WarehouseDetailsPane warehouseDetailsPane(){
		return new WarehouseDetailsPane();
	}
}
