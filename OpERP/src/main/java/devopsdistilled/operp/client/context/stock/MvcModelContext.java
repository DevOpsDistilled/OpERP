package devopsdistilled.operp.client.context.stock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.stock.panes.models.CreateWarehousePaneModel;
import devopsdistilled.operp.client.stock.panes.models.EditWarehousePaneModel;
import devopsdistilled.operp.client.stock.panes.models.ListStockPaneModel;
import devopsdistilled.operp.client.stock.panes.models.ListWarehousePaneModel;
import devopsdistilled.operp.client.stock.panes.models.UpdateStockPaneModel;
import devopsdistilled.operp.client.stock.panes.models.impl.CreateWarehousePaneModelImpl;
import devopsdistilled.operp.client.stock.panes.models.impl.EditWarehousePaneModelImpl;
import devopsdistilled.operp.client.stock.panes.models.impl.ListStockPaneModelImpl;
import devopsdistilled.operp.client.stock.panes.models.impl.ListWarehousePaneModelImpl;
import devopsdistilled.operp.client.stock.panes.models.impl.UpdateStockPaneModelImpl;

@Configuration
public class MvcModelContext {

	@Bean
	public UpdateStockPaneModel createStockPaneModel() {
		return new UpdateStockPaneModelImpl();
	}

	@Bean
	public ListStockPaneModel listStockPaneModel() {
		return new ListStockPaneModelImpl();
	}

	@Bean
	public CreateWarehousePaneModel createWarehousePaneModel() {
		return new CreateWarehousePaneModelImpl();
	}

	@Bean
	public ListWarehousePaneModel listWarehousePaneModel() {
		return new ListWarehousePaneModelImpl();
	}

	@Bean
	public EditWarehousePaneModel editWarehousePaneModel() {
		return new EditWarehousePaneModelImpl();
	}

	@Bean
	public UpdateStockPaneModel updateStockPaneModel() {
		return new UpdateStockPaneModelImpl();
	}

}
