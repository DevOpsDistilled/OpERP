package devopsdistilled.operp.client.context.items;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import devopsdistilled.operp.server.data.service.items.BrandService;
import devopsdistilled.operp.server.data.service.items.CategoryService;
import devopsdistilled.operp.server.data.service.items.ItemService;
import devopsdistilled.operp.server.data.service.items.ManufacturerService;
import devopsdistilled.operp.server.data.service.items.ProductService;

@Configuration
public class RmiContext {

	@Bean
	public RmiProxyFactoryBean itemService() {
		RmiProxyFactoryBean rmiProxy = new RmiProxyFactoryBean();
		rmiProxy.setServiceUrl("rmi://127.0.1.1:1099/ItemService");
		rmiProxy.setServiceInterface(ItemService.class);
		return rmiProxy;
	}

	@Bean
	public RmiProxyFactoryBean productService() {
		RmiProxyFactoryBean rmiProxy = new RmiProxyFactoryBean();
		rmiProxy.setServiceUrl("rmi://127.0.1.1:1099/ProductService");
		rmiProxy.setServiceInterface(ProductService.class);
		return rmiProxy;
	}

	@Bean
	public RmiProxyFactoryBean brandService() {
		RmiProxyFactoryBean rmiProxy = new RmiProxyFactoryBean();
		rmiProxy.setServiceUrl("rmi://127.0.1.1:1099/BrandService");
		rmiProxy.setServiceInterface(BrandService.class);
		return rmiProxy;
	}

	@Bean
	public RmiProxyFactoryBean categoryService() {
		RmiProxyFactoryBean rmiProxy = new RmiProxyFactoryBean();
		rmiProxy.setServiceUrl("rmi://127.0.1.1:1099/CategoryService");
		rmiProxy.setServiceInterface(CategoryService.class);
		return rmiProxy;
	}

	@Bean
	public RmiProxyFactoryBean manufacturerService() {
		RmiProxyFactoryBean rmiProxy = new RmiProxyFactoryBean();
		rmiProxy.setServiceUrl("rmi://127.0.1.1:1099/ManufacturerService");
		rmiProxy.setServiceInterface(ManufacturerService.class);
		return rmiProxy;
	}

}
