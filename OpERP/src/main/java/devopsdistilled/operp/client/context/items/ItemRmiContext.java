package devopsdistilled.operp.client.context.items;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import devopsdistilled.operp.client.context.RmiContext;
import devopsdistilled.operp.server.data.service.items.BrandService;
import devopsdistilled.operp.server.data.service.items.CategoryService;
import devopsdistilled.operp.server.data.service.items.ItemService;
import devopsdistilled.operp.server.data.service.items.ManufacturerService;
import devopsdistilled.operp.server.data.service.items.ProductService;

@Configuration
public class ItemRmiContext extends RmiContext {

	@Bean
	public RmiProxyFactoryBean itemService() {
		RmiProxyFactoryBean rmiProxy = new RmiProxyFactoryBean();
		rmiProxy.setServiceUrl(rmiUrl + "/ItemService");
		rmiProxy.setServiceInterface(ItemService.class);
		return rmiProxy;
	}

	@Bean
	public RmiProxyFactoryBean productService() {
		RmiProxyFactoryBean rmiProxy = new RmiProxyFactoryBean();
		rmiProxy.setServiceUrl(rmiUrl + "/ProductService");
		rmiProxy.setServiceInterface(ProductService.class);
		return rmiProxy;
	}

	@Bean
	public RmiProxyFactoryBean brandService() {
		RmiProxyFactoryBean rmiProxy = new RmiProxyFactoryBean();
		rmiProxy.setServiceUrl(rmiUrl + "/BrandService");
		rmiProxy.setServiceInterface(BrandService.class);
		return rmiProxy;
	}

	@Bean
	public RmiProxyFactoryBean categoryService() {
		RmiProxyFactoryBean rmiProxy = new RmiProxyFactoryBean();
		rmiProxy.setServiceUrl(rmiUrl + "/CategoryService");
		rmiProxy.setServiceInterface(CategoryService.class);
		return rmiProxy;
	}

	@Bean
	public RmiProxyFactoryBean manufacturerService() {
		RmiProxyFactoryBean rmiProxy = new RmiProxyFactoryBean();
		rmiProxy.setServiceUrl(rmiUrl + "/ManufacturerService");
		rmiProxy.setServiceInterface(ManufacturerService.class);
		return rmiProxy;
	}

}
