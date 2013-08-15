package devopsdistilled.operp.client.context.stock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import devopsdistilled.operp.client.context.RmiContext;
import devopsdistilled.operp.server.data.service.stock.StockKeeperService;
import devopsdistilled.operp.server.data.service.stock.StockService;
import devopsdistilled.operp.server.data.service.stock.WarehouseService;

@Configuration
public class StockRmiContext extends RmiContext {

	@Bean
	public RmiProxyFactoryBean stockService() {
		RmiProxyFactoryBean rmiProxy = new RmiProxyFactoryBean();
		rmiProxy.setServiceUrl(rmiUrl + "/StockService");
		rmiProxy.setServiceInterface(StockService.class);
		return rmiProxy;
	}

	@Bean
	public RmiProxyFactoryBean warehouseService() {
		RmiProxyFactoryBean rmiProxy = new RmiProxyFactoryBean();
		rmiProxy.setServiceUrl(rmiUrl + "/WarehouseService");
		rmiProxy.setServiceInterface(WarehouseService.class);
		return rmiProxy;
	}

	@Bean
	public RmiProxyFactoryBean stockKeeperService() {
		RmiProxyFactoryBean rmiProxy = new RmiProxyFactoryBean();
		rmiProxy.setServiceUrl(rmiUrl + "/StockKeeperService");
		rmiProxy.setServiceInterface(StockKeeperService.class);
		return rmiProxy;
	}

}
