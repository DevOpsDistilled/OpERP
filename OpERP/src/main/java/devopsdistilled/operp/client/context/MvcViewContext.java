package devopsdistilled.operp.client.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.items.panes.CreateCategoryPane;
import devopsdistilled.operp.client.items.panes.CreateItemPane;
import devopsdistilled.operp.client.items.panes.CreateProductPane;
import devopsdistilled.operp.client.items.panes.EditCategoryPane;
import devopsdistilled.operp.client.items.panes.EditItemPane;
import devopsdistilled.operp.client.items.panes.EditProductPane;
import devopsdistilled.operp.client.items.panes.ListCategoryPane;
import devopsdistilled.operp.client.items.panes.ListItemPane;
import devopsdistilled.operp.client.stock.panes.CreateWarehousePane;
import devopsdistilled.operp.client.stock.panes.EditWarehousePane;
import devopsdistilled.operp.client.stock.panes.ListWarehousePane;
import devopsdistilled.operp.client.stock.panes.UpdateStockPane;
import devopsdistilled.operp.client.items.panes.ListProductPane;

@Configuration
public class MvcViewContext {

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
	public CreateCategoryPane createCategoryPane() {
		return new CreateCategoryPane();
	}

	@Bean
	public EditCategoryPane editCategoryPane() {
		return new EditCategoryPane();
	}

	@Bean
	public ListCategoryPane listCategoryPane() {
		return new ListCategoryPane();
	}
	
	@Bean
	public CreateWarehousePane createWarehousePane(){
		return new CreateWarehousePane();
	}
	
	@Bean
	public ListWarehousePane listWarehousePane(){
		return new ListWarehousePane();
	}
	
	@Bean
	public EditWarehousePane editWarehousePane(){
		return new EditWarehousePane();
	}
	
	@Bean
	public UpdateStockPane updateStockpane(){
		return new UpdateStockPane();
	}
	
	@Bean
	public CreateProductPane createProductPane() {
		return new CreateProductPane();
	}

	@Bean
	public ListProductPane listProductPane() {
		return new ListProductPane();
	}

	@Bean
	public EditProductPane editProductPane() {
		return new EditProductPane();
	}
}
