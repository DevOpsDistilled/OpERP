package devopsdistilled.operp.client.context.stock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.stock.panes.details.StockDetailsPane;
import devopsdistilled.operp.client.stock.panes.details.StockKeepingDetailsPane;
import devopsdistilled.operp.client.stock.panes.details.WarehouseDetailsPane;

@Configuration
public class EntityDetailsContext {

	@Bean
	public WarehouseDetailsPane warehouseDetailsPane() {
		return new WarehouseDetailsPane();
	}

	@Bean
	public StockDetailsPane stockDetailsPane() {
		return new StockDetailsPane();
	}

	@Bean
	public StockKeepingDetailsPane stockKeepingDetailsPane() {
		return new StockKeepingDetailsPane();
	}
}
