package devopsdistilled.operp.client.context.stock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.stock.models.StockKeeperModel;
import devopsdistilled.operp.client.stock.models.StockModel;
import devopsdistilled.operp.client.stock.models.WarehouseModel;
import devopsdistilled.operp.client.stock.models.impl.StockKeeperModelImpl;
import devopsdistilled.operp.client.stock.models.impl.StockModelImpl;
import devopsdistilled.operp.client.stock.models.impl.WarehouseModelImpl;

@Configuration
public class EntityModelContext {

	@Bean
	public StockModel stockModel() {
		return new StockModelImpl();
	}

	@Bean
	public WarehouseModel warehouseModel() {
		return new WarehouseModelImpl();
	}

	@Bean
	public StockKeeperModel stockKeeperModel() {
		return new StockKeeperModelImpl();
	}
}
