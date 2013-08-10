package devopsdistilled.operp.client.context.stock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

@Configuration
public class MvcControllerContext {

	@Bean
	public ListStockPaneController listStockPaneController() {
		return new ListStockPaneControllerImpl();
	}

	@Bean
	public CreateWarehousePaneController createWarehousePaneController() {
		return new CreateWareHousePaneControllerImpl();
	}

	@Bean
	public ListWarehousePaneController listWarehousePaneController() {
		return new ListWarehousePaneControllerImpl();
	}

	@Bean
	public EditWarehousePaneController editWarehousePaneController() {
		return new EditWarehousePaneControllerImpl();
	}

	@Bean
	public UpdateStockPaneController updateStockPaneController() {
		return new UpdateStockPaneControllerImpl();
	}

}
