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
	public CategoryModel categoryModel() {
		return new CategoryModelImpl();
	}

	@Bean
	public ManufacturerModel manufacturerModel() {
		return new ManufacturerModelImpl();
	}

//	@Bean
//	public RmiServiceExporter rmiEmployeeServiceExporter() {
//		RmiServiceExporter rmiServiceExportor = new RmiServiceExporter();
//		rmiServiceExportor.setServiceInterface(ItemModel.class);
//		// String serviceName = rmiServiceExportor.getServiceInterface()
//		// .getCanonicalName();
//		rmiServiceExportor.setServiceName("ItemModel");
//		rmiServiceExportor.setService(itemModel());
//		rmiServiceExportor.setRegistryPort(1099);
//		System.out.println(rmiServiceExportor);
//		return rmiServiceExportor;
//	}
}
