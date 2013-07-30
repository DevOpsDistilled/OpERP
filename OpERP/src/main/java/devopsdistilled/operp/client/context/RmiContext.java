package devopsdistilled.operp.client.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import devopsdistilled.operp.server.data.service.items.BrandService;
import devopsdistilled.operp.server.data.service.items.ItemService;
import devopsdistilled.operp.server.data.service.items.ProductService;
import devopsdistilled.operp.server.data.service.stock.StockService;
import devopsdistilled.operp.server.data.service.stock.WarehouseService;
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
	public RmiProxyFactoryBean stockService(){
		RmiProxyFactoryBean rmiProxy=new RmiProxyFactoryBean();
		rmiProxy.setServiceUrl("rmi://127.0.1.1:1099/StockService");
		rmiProxy.setServiceInterface(StockService.class);
		return rmiProxy;
		
	}
	public RmiProxyFactoryBean warehouseService(){
		RmiProxyFactoryBean rmiProxy=new RmiProxyFactoryBean();
		rmiProxy.setServiceUrl("rmi://127.0.1.1:1099/WarehouseService");
		rmiProxy.setServiceInterface(WarehouseService.class);
		return rmiProxy;
	}
}
