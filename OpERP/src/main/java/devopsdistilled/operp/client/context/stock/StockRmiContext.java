package devopsdistilled.operp.client.context.stock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import devopsdistilled.operp.server.data.service.stock.StockService;
import devopsdistilled.operp.server.data.service.stock.WarehouseService;

@Configuration
public class RmiContext {

	@Bean
	public RmiProxyFactoryBean stockService() {
		RmiProxyFactoryBean rmiProxy = new RmiProxyFactoryBean();
		rmiProxy.setServiceUrl("rmi://127.0.1.1:1099/StockService");
		rmiProxy.setServiceInterface(StockService.class);
		return rmiProxy;
	}

	@Bean
	public RmiProxyFactoryBean warehouseService() {
		RmiProxyFactoryBean rmiProxy = new RmiProxyFactoryBean();
		rmiProxy.setServiceUrl("rmi://127.0.1.1:1099/WarehouseService");
		rmiProxy.setServiceInterface(WarehouseService.class);
		return rmiProxy;
	}

}
