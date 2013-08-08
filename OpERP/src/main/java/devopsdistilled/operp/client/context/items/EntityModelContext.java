package devopsdistilled.operp.client.context.items;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.items.models.BrandModel;
import devopsdistilled.operp.client.items.models.CategoryModel;
import devopsdistilled.operp.client.items.models.ItemModel;
import devopsdistilled.operp.client.items.models.ManufacturerModel;
import devopsdistilled.operp.client.items.models.ProductModel;
import devopsdistilled.operp.client.items.models.impl.BrandModelImpl;
import devopsdistilled.operp.client.items.models.impl.CategoryModelImpl;
import devopsdistilled.operp.client.items.models.impl.ItemModelImpl;
import devopsdistilled.operp.client.items.models.impl.ManufacturerModelImpl;
import devopsdistilled.operp.client.items.models.impl.ProductModelImpl;
import devopsdistilled.operp.client.stock.models.StockModel;
import devopsdistilled.operp.client.stock.models.WarehouseModel;
import devopsdistilled.operp.client.stock.models.impl.StockModelImpl;
import devopsdistilled.operp.client.stock.models.impl.WarehouseModelImpl;

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
	public StockModel stockModel() {
		return new StockModelImpl();
	}

	@Bean
	public WarehouseModel warehouseModel() {
		return new WarehouseModelImpl();
	}

	@Bean
	public CategoryModel categoryModel() {
		return new CategoryModelImpl();
	}

	@Bean
	public ManufacturerModel manufacturerModel() {
		return new ManufacturerModelImpl();
	}

}
