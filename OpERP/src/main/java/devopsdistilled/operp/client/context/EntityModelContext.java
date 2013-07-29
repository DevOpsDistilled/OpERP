package devopsdistilled.operp.client.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.items.models.BrandModel;
import devopsdistilled.operp.client.items.models.ItemModel;
import devopsdistilled.operp.client.items.models.ProductModel;
import devopsdistilled.operp.client.items.models.impl.BrandModelImpl;
import devopsdistilled.operp.client.items.models.impl.ItemModelImpl;
import devopsdistilled.operp.client.items.models.impl.ProductModelImpl;
import devopsdistilled.operp.client.stock.panes.models.StockModel;
import devopsdistilled.operp.client.stock.panes.models.impl.StockModelImpl;

@Configuration
public class EntityModelContext {
	@Bean
	public ItemModel itemModel() {
		return new ItemModelImpl();
	}

	@Bean
	public ProductModel productModel() {
		return new ProductModelImpl();
	}

	@Bean
	public BrandModel brandModel() {
		return new BrandModelImpl();
	}
	
	@Bean 
	public StockModel stockmodel(){
		return new StockModelImpl();
	}
}
