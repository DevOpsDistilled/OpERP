package devopsdistilled.operp.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import devopsdistilled.operp.server.service.ItemService;

@Configuration
public class RmiConfig {

    @Bean
    public RmiProxyFactoryBean itemService() {
	RmiProxyFactoryBean rmiProxy = new RmiProxyFactoryBean();
	rmiProxy.setServiceUrl("rmi://127.0.1.1:1099/ItemService");
	rmiProxy.setServiceInterface(ItemService.class);
	return rmiProxy;
    }
}
